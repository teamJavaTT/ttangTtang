package admin.userproduct.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.qna.service.ArticleNotFoundException;
import admin.userproduct.service.UserProductData;
import admin.userproduct.service.UserProductService;
import mvc.command.CommandHandler;

public class UserProductreadHandler implements CommandHandler {
	
private UserProductService userproductService = new UserProductService();
	

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) 
			throws Exception {
		String noVal = req.getParameter("no");
		int userproductNum = Integer.parseInt(noVal);
		try {
			UserProductData userproductData = userproductService.getUserProductRead(userproductNum);
			req.setAttribute("userproductData", userproductData);
			return "/WEB-INF/ogani-master/admin/userproduct/userproductread.jsp";
		} catch (ArticleNotFoundException e) {
			req.getServletContext().log("no article", e);
			res.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
	}
}
