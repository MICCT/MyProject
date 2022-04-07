package co.mass.mybatis.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.taglibs.standard.tag.rt.fmt.RequestEncodingTag;

import co.mass.mybatis.comm.Command;
import co.mass.mybatis.member.service.MemberVO;
import co.mass.mybatis.notice.service.NoticeService;
import co.mass.mybatis.notice.service.NoticeVO;
import co.mass.mybatis.notice.serviceImpl.NoticeServiceImpl;

public class NoticeInsert implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		// 게시글 저장
		HttpSession session = request.getSession();

		NoticeService noticeDao = new NoticeServiceImpl();
		NoticeVO vo = new NoticeVO();

		vo.setId(request.getParameter("id"));
		vo.setName(request.getParameter("name"));

		vo.setTitle(request.getParameter("title"));
		vo.setContents(request.getParameter("contents"));

		System.out.println(request.getParameter("id"));
		System.out.println(request.getParameter("name"));
		System.out.println(request.getParameter("title"));
		System.out.println(request.getParameter("contents"));

		int I = noticeDao.noticeInsert(vo);
		String viewPage = null;

		if (I != 0) {
			viewPage = "noticeList.do";
		} else {
			request.setAttribute("message", "등록에 실패하였습니다...");
			viewPage = "notice/noticeFail";
		}

		return viewPage;
	}

}
