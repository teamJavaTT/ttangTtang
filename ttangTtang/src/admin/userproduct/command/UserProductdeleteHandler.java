package admin.userproduct.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.userproduct.service.UserProductService;
import mvc.command.CommandHandler;

public class UserProductdeleteHandler implements CommandHandler {
	
	private UserProductService userproductService = new UserProductService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String requestNo = req.getParameter("no");
		int delNo = Integer.parseInt(requestNo);
		
		userproductService.getUserProductDelete(delNo);
		return "/WEB-INF/ogani-master/admin/userproduct/userproductdeletesuccess.jsp";
	}

}
