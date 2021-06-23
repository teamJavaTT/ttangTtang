package mypage.declarationAndBlockList.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import mypage.declarationAndBlockList.service.DeclarationAndBlockListService;
import mypage.declarationAndBlockList.service.ListPage;

public class DeclarationAndBlockListHandler implements CommandHandler {
private DeclarationAndBlockListService declarationAndBlockListService = new DeclarationAndBlockListService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String pageVal = req.getParameter("pageNo");
		int pageNo = 1;
		
		String declarationChkVal = req.getParameter("declarationChk");
		if(pageVal != null) {
			pageNo = Integer.parseInt(pageVal);
		}
		if(declarationChkVal == null) {
			declarationChkVal = "A";
		}
		if(declarationChkVal.equals("Y") || declarationChkVal.equals("N")) { // 정규회원이랑 탈퇴회원 체크시
			ListPage sellCheckListPage = declarationAndBlockListService.getCheckListPage(pageNo, declarationChkVal);
			req.setAttribute("sellCheckPage", sellCheckListPage);
		}else {// 전체 회원 체크시
 			ListPage sellCheckPage = declarationAndBlockListService.getListPage(pageNo);
			req.setAttribute("sellCheckPage", sellCheckPage);
		}
		return "/WEB-INF/ogani-master/mypage/declarationAndBlockList.jsp";
		
	}
}
