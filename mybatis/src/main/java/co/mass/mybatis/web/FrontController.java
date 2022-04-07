package co.mass.mybatis.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.mass.mybatis.comm.Command;
import co.mass.mybatis.command.HomeCommand;
import co.mass.mybatis.command.MemberJoin;
import co.mass.mybatis.command.MemberJoinForm;
import co.mass.mybatis.command.MemberList;
import co.mass.mybatis.command.MemberLogOut;
import co.mass.mybatis.command.MemberLogin;
import co.mass.mybatis.command.MemberLoginForm;
import co.mass.mybatis.command.MemberSelect;
import co.mass.mybatis.command.NoticeCon;
import co.mass.mybatis.command.NoticeEdit;
import co.mass.mybatis.command.NoticeForm;
import co.mass.mybatis.command.NoticeInsert;
import co.mass.mybatis.command.NoticeList;


@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private HashMap<String, Command> map = new HashMap<String, Command>();

	public FrontController() {
		super();

	}

	public void init(ServletConfig config) throws ServletException {
		map.put("/home.do", new HomeCommand()); //홈으로
		map.put("/memberList.do", new MemberList()); //멤버리스트 가져오기
		map.put("/memberSelect.do", new MemberSelect());//한명(단건) 검색
		map.put("/noticeList.do", new NoticeList()); //공지사항 리스트
		map.put("/noticeCon.do", new NoticeCon());//공지사항 세부 내용
		map.put("/noticeEdit.do", new NoticeEdit());//공지사항 수정
		map.put("/noticeForm.do", new NoticeForm());//게시글 작성 폼
		map.put("/noticeInsert.do", new NoticeInsert()); //게시글저장
		
		map.put("/memberLoginForm.do", new MemberLoginForm()); //로그인 페이지 호출
		map.put("/memberLogin.do", new MemberLogin()); //로그인 기능
		map.put("/memberLogOut.do", new MemberLogOut()); //로그아웃
		map.put("/memberJoinForm.do", new MemberJoinForm()); //회원가입 페이지호출
		map.put("/memberJoin.do", new MemberJoin()); //회원가입 응답
		
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String page = uri.substring(contextPath.length());
		System.out.println(page);
		//자기자신은 받을수가 없기떄문에 하위요소를 받는다.
		Command command = map.get(page);
		String viewPage = command.run(request, response);

		if (!viewPage.endsWith(".do")) {
			viewPage = "WEB-INF/views/" + viewPage + ".jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
