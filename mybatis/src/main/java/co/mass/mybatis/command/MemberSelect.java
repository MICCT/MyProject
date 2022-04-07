package co.mass.mybatis.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.mass.mybatis.comm.Command;
import co.mass.mybatis.member.service.MemberService;
import co.mass.mybatis.member.service.MemberVO;
import co.mass.mybatis.member.serviceImpl.MemberServiceImpl;

public class MemberSelect implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		MemberService memberDao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		
		vo.setId((String)session.getAttribute("id")); //강제로 하지않고 세션이 가지고있는 id값을 가져온다
		 
	//	vo.setId("Choi"); //강제로
		request.setAttribute("member", memberDao.memberSelect(vo));
		
		return "member/memberSelect";
	}

}
