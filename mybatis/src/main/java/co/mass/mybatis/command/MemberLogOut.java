package co.mass.mybatis.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.mass.mybatis.comm.Command;

public class MemberLogOut implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		session.invalidate(); //현재 들어와있는 세션을 삭제시킨다.
		
		return "home.do"; // 현재세션을 초기화 시키고 홈으로 강제이동 시킨다.
	}

}
