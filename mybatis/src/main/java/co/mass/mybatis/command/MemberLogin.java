package co.mass.mybatis.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.mass.mybatis.comm.Command;
import co.mass.mybatis.member.service.MemberService;
import co.mass.mybatis.member.service.MemberVO;
import co.mass.mybatis.member.serviceImpl.MemberServiceImpl;


public class MemberLogin implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		MemberService memberDao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		
//		vo.setId(session.setAttribute("id", vo)); //로그인 되었을떄 세션이 존재하면 id세션값을 가져온다.
		
		vo.setId(request.getParameter("id"));
		vo.setPassword(request.getParameter("password"));
		vo = memberDao.memberSelect(vo);
		request.setAttribute("member", vo);
		
		if(vo != null) { //vo 에 낫널(값이있으면?) 이면 아래에 값을
			request.setAttribute("message", vo.getName()+"님 환영합니다.");
			session.setAttribute("id", vo.getId());
			session.setAttribute("author", vo.getAuthor());
			session.setAttribute("name", vo.getName());
		}else {
			request.setAttribute("message", "로그인실패,또 오타있다 찾아라 ");
		}
		
		return "member/memberLogin";
	}

}
