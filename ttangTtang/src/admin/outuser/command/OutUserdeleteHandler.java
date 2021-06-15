package admin.outuser.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.outuser.service.OutUserService;
import mvc.command.CommandHandler;

public class OutUserdeleteHandler implements CommandHandler {
	
	private OutUserService outuserService = new OutUserService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String requestNo = req.getParameter("no");
		int delNo = Integer.parseInt(requestNo);
		
		outuserService.getOutUserDelete(delNo);
		return "/WEB-INF/ogani-master/admin/userid/useridsuccess.jsp";
	}

}
