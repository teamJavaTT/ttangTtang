package admin.blacklist.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.blacklist.service.ArticleNotFoundException;
import admin.blacklist.service.BlacklistData;
import admin.blacklist.service.BlacklistService;
import mvc.command.CommandHandler;

public class BlacklistreadHandler implements CommandHandler {
	
private BlacklistService blacklistService = new BlacklistService();
	

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) 
			throws Exception {
		String noVal = req.getParameter("no");
		int blacklistNum = Integer.parseInt(noVal);
		try {
			BlacklistData blacklistData = blacklistService.getBlacklistRead(blacklistNum);
			req.setAttribute("blacklistData", blacklistData);
			return "/WEB-INF/ogani-master/admin/blacklist/blacklistread.jsp";
		} catch (ArticleNotFoundException e) {
			req.getServletContext().log("no article", e);
			res.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
	}
}
