package admin.userinfo.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.userinfo.service.UserinfoPage;
import admin.userinfo.service.UserinfoService;
import mvc.command.CommandHandler;

public class UserInfolistHandler implements CommandHandler {
	
	private UserinfoService userinfoService = new UserinfoService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String pageVal = req.getParameter("pageNo");
		int pageNo = 1;
		if(pageVal != null) {
			pageNo = Integer.parseInt(pageVal);
		}
		UserinfoPage userinfoPage = userinfoService.getUserinfoPage(pageNo);
		req.setAttribute("userinfoPage", userinfoPage);
		return "/WEB-INF/ogani-master/admin/userinfo/userinfo.jsp";
	}

}
