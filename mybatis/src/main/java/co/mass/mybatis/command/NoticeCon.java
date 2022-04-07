package co.mass.mybatis.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.mass.mybatis.comm.Command;
import co.mass.mybatis.notice.service.NoticeService;
import co.mass.mybatis.notice.service.NoticeVO;
import co.mass.mybatis.notice.serviceImpl.NoticeServiceImpl;

public class NoticeCon implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		//선택한 게시글 상세보기
		NoticeService noticeDao = new NoticeServiceImpl();
		NoticeVO vo = new NoticeVO();
		
		//request.getParameter <- String 타입이라서 변환필요
		vo.setNid(Integer.valueOf(request.getParameter("nid")));
		vo = noticeDao.noticeSelect(vo);
		request.setAttribute("notice", vo);
		
		return "notice/NoticeCon";
	}

}
