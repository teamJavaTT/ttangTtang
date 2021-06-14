package admin.blacklist.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.blacklist.service.BlacklistService;
import mvc.command.CommandHandler;

public class BlacklistdeleteHandler implements CommandHandler {
	
	private BlacklistService blacklistService = new BlacklistService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String requestNo = req.getParameter("no");
		int delNo = Integer.parseInt(requestNo);
		
		blacklistService.getBlacklistDelete(delNo);
		return "/WEB-INF/ogani-master/admin/userid/useridsuccess.jsp";
	}

}
