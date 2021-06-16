package admin.userinfo.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.userinfo.service.UserinfoData;
import admin.userinfo.service.UserinfoService;
import mvc.command.CommandHandler;

public class UserInforeadHandler implements CommandHandler {
	
private UserinfoService userinfoService = new UserinfoService();
	

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) 
			throws Exception {
		String noVal = req.getParameter("id");
		UserinfoData userinfoData = userinfoService.getUserinfoRead(noVal);
		req.setAttribute("userinfoData", userinfoData);
		return "/WEB-INF/ogani-master/admin/userinfo/userinforead.jsp";
	}
}
