package mypage.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import mypage.service.DeleteFromService;

public class DeleteFromHandler implements CommandHandler {
	
	private DeleteFromService deleteFromService = new DeleteFromService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String requestNo = req.getParameter("no");
		int delNo = Integer.parseInt(requestNo);
		
		deleteFromService.getOutuserDelete(delNo);
		return "/WEB-INF/ogani-master/admin/userid/useridsuccess.jsp";
	}

}
