package admin.declaration.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.declaration.service.DeclarationPage;
import admin.declaration.service.DeclarationService;
import mvc.command.CommandHandler;

public class DeclarationlistHandler implements CommandHandler {
	
	private DeclarationService declarationService = new DeclarationService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String pageVal = req.getParameter("pageNo");
		int pageNo = 1;
		if(pageVal != null) {
			pageNo = Integer.parseInt(pageVal);
		}
		DeclarationPage declarationPage = declarationService.getDeclarationPage(pageNo);
		req.setAttribute("declarationPage", declarationPage);
		return "/WEB-INF/ogani-master/admin/declaration/declaration.jsp";
	}

}
