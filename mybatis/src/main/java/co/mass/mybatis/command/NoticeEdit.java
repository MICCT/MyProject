package co.mass.mybatis.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.mass.mybatis.comm.Command;
import co.mass.mybatis.notice.service.NoticeService;
import co.mass.mybatis.notice.service.NoticeVO;
import co.mass.mybatis.notice.serviceImpl.NoticeServiceImpl;

public class NoticeEdit implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		//게시글 수정
		NoticeService noticeDao = new NoticeServiceImpl();
		NoticeVO vo = new NoticeVO();
		vo.setNid(Integer.valueOf(request.getParameter("nid")));
		vo.setTitle(request.getParameter("title"));
		vo.setContents(request.getParameter("contents"));
		
		System.out.println(vo.getTitle());
		System.out.println(vo.getContents());
		
		int a = noticeDao.noticeUpdate(vo);
		String viewPage = null;
		System.out.println(a);
		if (a != 0) {
			viewPage = "noticeList.do";
		}else {
			request.setAttribute("message", "수정 실패하였습니다.");
			viewPage = "notice/noticeFail";
		}
		
		return viewPage;
	}

}
