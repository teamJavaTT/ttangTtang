package admin.outuser.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.outuser.service.OutuserData;
import admin.outuser.service.OutuserService;
import mvc.command.CommandHandler;

public class OutuserreadHandler implements CommandHandler {
	
private OutuserService outuserService = new OutuserService();
	

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) 
			throws Exception {
		String noVal = req.getParameter("no");
		int outuserNum = Integer.parseInt(noVal);
		OutuserData outuserData = outuserService.getOutuserRead(outuserNum);
		req.setAttribute("outuserData", outuserData);
		return "/WEB-INF/ogani-master/admin/outuser/outuserread.jsp";
		
	}
}
