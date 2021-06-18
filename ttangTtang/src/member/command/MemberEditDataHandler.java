package member.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import AES256.AES256Util;
import member.dao.MemberDao;
import member.model.Member;
import member.service.DuplicateIdException;
import member.service.LoginFailException;
import member.service.MemberRequest;
import member.service.MemberService;
import member.service.User;
import mvc.command.CommandHandler;

public class MemberEditDataHandler implements CommandHandler {
	private static final String FORM_VIEW = "/WEB-INF/ogani-master/login/memberEdit.jsp";
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

	private String processForm(HttpServletRequest req, HttpServletResponse res) throws Exception {
		HttpSession session = req.getSession(false);
		User user = (User) session.getAttribute("memberUser");
		Member member= memberService.selectById(user.getUserid());
		req.setAttribute("member", member);
		return FORM_VIEW;
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws Exception {
		AES256Util aes256Util = new AES256Util();
		MemberRequest memberReq = new MemberRequest();
		req.setCharacterEncoding("utf-8");
		
		memberReq.setUpw(aes256Util.encrypt(req.getParameter("upw")));
		memberReq.setUpw2(aes256Util.encrypt(req.getParameter("upw2")));
		memberReq.setUemail(req.getParameter("uemail"));
		memberReq.setPhone(req.getParameter("phone"));
		memberReq.setAddress1(req.getParameter("Address1"));
		memberReq.setAddress2(req.getParameter("Address2"));
		memberReq.setAddress3(req.getParameter("Address3"));
		
		

		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);

		memberReq.validate(errors);

		if (!errors.isEmpty()) {
			return FORM_VIEW;
		}

		try {
			memberService.memberInsert(memberReq);
			res.sendRedirect(req.getContextPath() + "/login.do");
			return null;
		} catch (DuplicateIdException e) {
			errors.put("duplicateId", Boolean.TRUE);
			return FORM_VIEW;
		}
		}
	}


