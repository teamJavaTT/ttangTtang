package mypage.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;

public class MypageMainHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) {
		return processForm(req, res);
	}
	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		return "/WEB-INF/ogani-master/mypage/mypageMain.jsp";
	}
}
