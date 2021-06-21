package mypage.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import AES256.AES256Util;
import member.service.DuplicateIdException;
import member.service.MemberRequest;
import member.service.MemberService;
import member.service.User;
import mvc.command.CommandHandler;
import mypage.service.DeleteFormService;

public class DeleteFormHandler implements CommandHandler {

	private static final String FORM_VIEW = "/WEB-INF/ogani-master/mypage/deleteForm.jsp";
	private MemberService memberService = new MemberService();
	private DeleteFormService deleteFormService = new DeleteFormService();

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
		HttpSession session = req.getSession(false);
		User user = (User) session.getAttribute("memberUser");

		String userId = user.getUserid();
		String sText = req.getParameter("sText");

		deleteFormService.getDeleteform(userId, sText);

		if (session != null) {
			session.invalidate();
		}
		return "/WEB-INF/ogani-master/mypage/memberDeleteSuccess.jsp";
	}

}
