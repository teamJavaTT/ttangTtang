package admin.userproduct.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.userproduct.service.UserProductPage;
import admin.userproduct.service.UserProductService;
import mvc.command.CommandHandler;

public class UserProductlistHandler implements CommandHandler {
	
	private UserProductService userproductService = new UserProductService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String pageVal = req.getParameter("pageNo");
		int pageNo = 1;
		if(pageVal != null) {
			pageNo = Integer.parseInt(pageVal);
		}
		UserProductPage userproductPage = userproductService.getUserProductPage(pageNo);
		req.setAttribute("userproductPage", userproductPage);
		return "/WEB-INF/ogani-master/admin/userproduct/userproduct.jsp";
	}

}
