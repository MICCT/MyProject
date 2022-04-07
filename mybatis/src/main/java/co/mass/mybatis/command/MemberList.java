package co.mass.mybatis.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.mass.mybatis.comm.Command;
import co.mass.mybatis.member.service.MemberService;
import co.mass.mybatis.member.serviceImpl.MemberServiceImpl;

public class MemberList implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		MemberService memberDao = new MemberServiceImpl();
		//멤버 리스트 값을 멤버즈 에 담는다
		request.setAttribute("members", memberDao.memberSelectList());
		
		
		return "member/memberList";
	}

}
