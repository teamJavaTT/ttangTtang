package admin.outuser.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.outuser.service.OutuserService;
import mvc.command.CommandHandler;

public class OutuserdeleteHandler implements CommandHandler {
	
	private OutuserService outuserService = new OutuserService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String requestNo = req.getParameter("no");
		int delNo = Integer.parseInt(requestNo);
		
		outuserService.getOutuserDelete(delNo);
		return "/WEB-INF/ogani-master/admin/userid/useridsuccess.jsp";
	}

}
