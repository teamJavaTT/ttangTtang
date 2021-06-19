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
		if (req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, res);
		} else if (req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, res);
		} else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		return FORM_VIEW;
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws Exception {

		req.setCharacterEncoding("utf-8");

		String userid = req.getParameter("userid");

		try {

			int idCheck = memberService.idCheck(userid);
			
			req.setAttribute("idCheck", idCheck);

			return FORM_VIEW;

		} catch (LoginFailException e) {

			return FORM_VIEW;

		}

	}
}
