package mypage.declarationAndBlockList.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.service.User;
import mvc.command.CommandHandler;
import mypage.declarationAndBlockList.service.BlockListPage;
import mypage.declarationAndBlockList.service.DeclarationAndBlockListService;
import mypage.declarationAndBlockList.service.DeclarationListPage;

public class DeclarationAndBlockListHandler implements CommandHandler {
	private DeclarationAndBlockListService declarationAndBlockListService = new DeclarationAndBlockListService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String pageVal = req.getParameter("pageNo");
		int pageNo = 1;
		HttpSession session = req.getSession(false);
		User user = (User) session.getAttribute("memberUser");
		String userId = user.getUserid();

		String sellChk = req.getParameter("sellChk");
		if (pageVal != null) {
			pageNo = Integer.parseInt(pageVal);
		}
		if (sellChk == null) {
			sellChk = "D";
		}
		if (sellChk.equals("D")) { // 신고
			DeclarationListPage declarationListPage = declarationAndBlockListService.getDeclarationPage(userId, pageNo);
			req.setAttribute("listPage", declarationListPage);
			req.setAttribute("key", "D");
		} else {                              // 차단
			BlockListPage blockListPage = declarationAndBlockListService.getBlockPage(userId, pageNo);
			req.setAttribute("listPage", blockListPage);
			req.setAttribute("key", "B");
		}
		return "/WEB-INF/ogani-master/mypage/declarationAndBlockList.jsp";

	}
}
