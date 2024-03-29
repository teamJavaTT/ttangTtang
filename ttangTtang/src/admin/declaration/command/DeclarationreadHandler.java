package admin.declaration.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.declaration.service.DeclarationData;
import admin.declaration.service.DeclarationService;
import mvc.command.CommandHandler;

public class DeclarationreadHandler implements CommandHandler {
	
private DeclarationService declarationService = new DeclarationService();
	

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) 
			throws Exception {
		String noVal = req.getParameter("no");
		int declarationNum = Integer.parseInt(noVal);
		DeclarationData declarationData = declarationService.getDeclarationRead(declarationNum);
		req.setAttribute("declarationData", declarationData);
		return "/WEB-INF/ogani-master/admin/declaration/declarationread.jsp";
	}
}
