package admin.blacklist.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.blacklist.service.BlacklistPage;
import admin.blacklist.service.BlacklistService;
import mvc.command.CommandHandler;

public class BlacklistlistHandler implements CommandHandler {
	
	private BlacklistService blacklistService = new BlacklistService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String pageVal = req.getParameter("pageNo");
		int pageNo = 1;
		if(pageVal != null) {
			pageNo = Integer.parseInt(pageVal);
		}
		BlacklistPage blacklistPage = blacklistService.getBlacklistPage(pageNo);
		req.setAttribute("blacklistPage", blacklistPage);
		return "/WEB-INF/ogani-master/admin/blacklist/blacklist.jsp";
	}

}
