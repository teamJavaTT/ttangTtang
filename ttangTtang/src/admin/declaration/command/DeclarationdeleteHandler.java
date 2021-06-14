package admin.declaration.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.declaration.service.DeclarationService;
import mvc.command.CommandHandler;

public class DeclarationdeleteHandler implements CommandHandler {
	
	private DeclarationService declarationService = new DeclarationService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String requestNo = req.getParameter("no");
		int delNo = Integer.parseInt(requestNo);
		
		declarationService.getDeclarationDelete(delNo);
		return "/WEB-INF/ogani-master/admin/userid/useridsuccess.jsp";
	}

}
