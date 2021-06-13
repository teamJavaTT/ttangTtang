package admin.userinfo.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.userinfo.service.UserinfoService;
import mvc.command.CommandHandler;

public class UserInfodeleteHandler implements CommandHandler {
	
	private UserinfoService userinfoService = new UserinfoService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String requestNo = req.getParameter("no");
		int delNo = Integer.parseInt(requestNo);
		
		userinfoService.getUserinfoDelete(delNo);
		return "/WEB-INF/ogani-master/admin/userid/useridsuccess.jsp";
	}

}
