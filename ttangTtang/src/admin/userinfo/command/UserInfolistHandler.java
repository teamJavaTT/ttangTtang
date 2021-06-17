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
		
		String memChkVal = req.getParameter("memberChk");
		int memberChk = 0;
		if(pageVal != null) {
			pageNo = Integer.parseInt(pageVal);
		}
		if(memChkVal != null) {
			memberChk = Integer.parseInt(memChkVal);
		}
		
		if(memberChk == 1 || memberChk == 2) { // 정규회원이랑 탈퇴회원 체크시
			UserinfoPage userinfoMemberChkPage = userinfoService.getUserinfoMemberChkPage(pageNo, memberChk);
			req.setAttribute("userinfoPage", userinfoMemberChkPage);
		}else {// 전체 회원 체크시
			UserinfoPage userinfoPage = userinfoService.getUserinfoPage(pageNo);
			req.setAttribute("userinfoPage", userinfoPage);
		}
		return "/WEB-INF/ogani-master/admin/userinfo/userinfo.jsp";
	}

}
