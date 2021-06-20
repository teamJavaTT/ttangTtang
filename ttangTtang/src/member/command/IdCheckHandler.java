package member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.service.LoginFailException;
import member.service.MemberService;
import mvc.command.CommandHandler;

public class IdCheckHandler implements CommandHandler {

	private static final String FORM_VIEW = "/WEB-INF/ogani-master/login/idCheck.jsp";
	private MemberService memberService = new MemberService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		req.setCharacterEncoding("utf-8");

		String userid = req.getParameter("userid");

		if(userid == null || userid == "") {
			req.setAttribute("idCheck", null);
			return FORM_VIEW;
		}
		
		int idCheck = memberService.idCheck(userid);
		req.setAttribute("idCheck", idCheck);
		return FORM_VIEW;

	}
}