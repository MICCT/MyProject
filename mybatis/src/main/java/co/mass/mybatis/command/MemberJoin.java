package co.mass.mybatis.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.mass.mybatis.comm.Command;
import co.mass.mybatis.member.service.MemberService;
import co.mass.mybatis.member.service.MemberVO;
import co.mass.mybatis.member.serviceImpl.MemberServiceImpl;

public class MemberJoin implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		// 회원가입을 처리해주는 폼
		
		MemberService memberDao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		
		vo.setId(request.getParameter("id"));
		vo.setPassword(request.getParameter("password"));
		vo.setName(request.getParameter("name"));
		vo.setAddress(request.getParameter("address"));
		vo.setTel(request.getParameter("tel"));
		vo.setAuthor(request.getParameter("author"));
		
		
		//위에 입력한 값을들 vo 값으로 받아서 인설트 함수로 받아서
		int a = memberDao.memberInsert(vo);
		String viewPage = null;
		
		
		if(a != 0) {//a 값이 0이 아니아면
			request.setAttribute("message", "회원가입이 성공하였습니다.");
			viewPage = "member/memberJoinSuccess";
		}
		
		
		return viewPage;
	}

}
