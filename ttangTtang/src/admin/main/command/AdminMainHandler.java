package admin.main.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;

public class AdminMainHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) {
		return processForm(req, res);
	}
	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		return "/WEB-INF/ogani-master/admin/adminmain.jsp";
	}
}
