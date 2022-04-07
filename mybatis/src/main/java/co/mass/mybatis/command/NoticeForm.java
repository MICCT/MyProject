package co.mass.mybatis.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.mass.mybatis.comm.Command;
import co.mass.mybatis.member.service.MemberService;
import co.mass.mybatis.member.service.MemberVO;
import co.mass.mybatis.member.serviceImpl.MemberServiceImpl;

public class NoticeForm implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		//공지사항 작성페이지 폼
		HttpSession session = request.getSession();
		
		MemberService memberDao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		
		
		vo.setId((String)session.getAttribute("id"));
		vo.setName((String)session.getAttribute("name"));
		request.setAttribute("notice", memberDao.memberSelect(vo));
		
		return "notice/noticeForm";
	}

}
