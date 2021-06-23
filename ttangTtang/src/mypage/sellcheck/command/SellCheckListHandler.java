package mypage.sellcheck.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.service.User;
import mvc.command.CommandHandler;
import mypage.sellcheck.service.SellCheckPage;
import mypage.sellcheck.service.SellCheckService;

public class SellCheckListHandler implements CommandHandler {
	
	private SellCheckService sellCheckService = new SellCheckService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String pageVal = req.getParameter("pageNo");
		int pageNo = 1;
		HttpSession session = req.getSession(false);
		User user = (User) session.getAttribute("memberUser");
		String userId = user.getUserid();
		
		String sellChkVal = req.getParameter("sellChk");
		if(pageVal != null) {
			pageNo = Integer.parseInt(pageVal);
		}
		if(sellChkVal == null) {
			sellChkVal = "A";
		}
		if(sellChkVal.equals("Y") || sellChkVal.equals("N")) {
			SellCheckPage sellCheckListPage = sellCheckService.getSellCheckListPage(pageNo, userId, sellChkVal);
			req.setAttribute("sellCheckPage", sellCheckListPage);
		}else {
 			SellCheckPage sellCheckPage = sellCheckService.getSellCheckPage(pageNo, userId);
			req.setAttribute("sellCheckPage", sellCheckPage);
		}
		return "/WEB-INF/ogani-master/mypage/sellcheck.jsp";
	}

}
