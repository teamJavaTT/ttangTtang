package admin.outuser.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.outuser.service.OutUserPage;
import admin.outuser.service.OutUserService;
import mvc.command.CommandHandler;

public class OutUserlistHandler implements CommandHandler {
	
	private OutUserService outuserService = new OutUserService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String pageVal = req.getParameter("pageNo");
		int pageNo = 1;
		if(pageVal != null) {
			pageNo = Integer.parseInt(pageVal);
		}
		OutUserPage outuserPage = outuserService.getOutUserPage(pageNo);
		req.setAttribute("outuserPage", outuserPage);
		return "/WEB-INF/ogani-master/admin/outuser/outuser.jsp";
	}

}
