package admin.outuser.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.outuser.service.OutuserPage;
import admin.outuser.service.OutuserService;
import mvc.command.CommandHandler;

public class OutuserlistHandler implements CommandHandler {
	
	private OutuserService outuserService = new OutuserService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String pageVal = req.getParameter("pageNo");
		int pageNo = 1;
		if(pageVal != null) {
			pageNo = Integer.parseInt(pageVal);
		}
		OutuserPage outuserPage = outuserService.getOutuserPage(pageNo);
		req.setAttribute("outuserPage", outuserPage);
		return "/WEB-INF/ogani-master/admin/outuser/outuser.jsp";
	}

}
