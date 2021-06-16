package admin.outuser.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.outuser.service.ArticleNotFoundException;
import admin.outuser.service.OutuserData;
import admin.outuser.service.OutuserService;
import mvc.command.CommandHandler;

public class OutuserreadHandler implements CommandHandler {
	
private OutuserService outuserService = new OutuserService();
	

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) 
			throws Exception {
		String noVal = req.getParameter("id");
		try {
			OutuserData outuserData = outuserService.getOutuserRead(noVal);
			req.setAttribute("outuserData", outuserData);
			return "/WEB-INF/ogani-master/admin/outuser/outuserread.jsp";
		} catch (ArticleNotFoundException e) {
			req.getServletContext().log("no article", e);
			res.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
	}
}
