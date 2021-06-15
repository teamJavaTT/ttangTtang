package member.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import AES256.AES256Util;
import member.service.IdFind;
import member.service.LoginFailException;
import member.service.MemberService;
import member.service.User;
import mvc.command.CommandHandler;

public class IdFindHandler implements CommandHandler {

	private static final String FORM_VIEW = "/WEB-INF/ogani-master/login/idfind.jsp";
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
		String uname = req.getParameter("uname");
		String uemail = req.getParameter("uemail");

		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);

		if (uname == null || uname.isEmpty())
			errors.put("uname", Boolean.TRUE);
		if (uemail == null || uemail.isEmpty())
			errors.put("uemail", Boolean.TRUE);

		if (!errors.isEmpty()) {
			return FORM_VIEW;
		}

		try {
			String idfind= memberService.memberidFind(uname, uemail);
			req.setAttribute("idfind", idfind);
			return FORM_VIEW;
		} catch (LoginFailException e) {
			errors.put("idOrPwNotMatch", Boolean.TRUE);
			return FORM_VIEW;
		}
	}

}
