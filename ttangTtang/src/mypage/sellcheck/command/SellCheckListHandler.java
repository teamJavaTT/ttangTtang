package mypage.sellcheck.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import mypage.sellcheck.service.SellCheckPage;
import mypage.sellcheck.service.SellCheckService;

public class SellCheckListHandler implements CommandHandler {
	
	private SellCheckService sellCheckService = new SellCheckService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String pageVal = req.getParameter("pageNo");
		int pageNo = 1;
		
		String sellChkVal = req.getParameter("sellChk");
		if(pageVal != null) {
			pageNo = Integer.parseInt(pageVal);
		}
		if(sellChkVal == null) {
			sellChkVal = "A";
		}
		if(sellChkVal.equals("Y") || sellChkVal.equals("N")) { // 정규회원이랑 탈퇴회원 체크시
			SellCheckPage sellCheckListPage = sellCheckService.getSellCheckListPage(pageNo, sellChkVal);
			req.setAttribute("sellCheckPage", sellCheckListPage);
		}else {// 전체 회원 체크시
 			SellCheckPage sellCheckPage = sellCheckService.getSellCheckPage(pageNo);
			req.setAttribute("sellCheckPage", sellCheckPage);
		}
		return "/WEB-INF/ogani-master/mypage/sellcheck.jsp";
	}

}
