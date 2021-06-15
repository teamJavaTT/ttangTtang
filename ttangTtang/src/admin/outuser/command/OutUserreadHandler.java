package admin.outuser.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.outuser.service.ArticleNotFoundException;
import admin.outuser.service.OutUserData;
import admin.outuser.service.OutUserService;
import mvc.command.CommandHandler;

public class OutUserreadHandler implements CommandHandler {
	
private OutUserService outuserService = new OutUserService();
	

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) 
			throws Exception {
		String noVal = req.getParameter("no");
		int outuserNum = Integer.parseInt(noVal);
		try {
			OutUserData outuserData = outuserService.getOutUserRead(outuserNum);
			req.setAttribute("outuserData", outuserData);
			return "/WEB-INF/ogani-master/admin/outuser/outuserread.jsp";
		} catch (ArticleNotFoundException e) {
			req.getServletContext().log("no article", e);
			res.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
	}
}
