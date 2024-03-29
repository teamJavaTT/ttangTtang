package member.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import AES256.AES256Util;
import member.service.DuplicateIdException;
import member.service.MemberRequest;
import member.service.MemberService;
import mvc.command.CommandHandler;

public class JoinHandler implements CommandHandler {
	private static final String FORM_VIEW = "/WEB-INF/ogani-master/login/join.jsp";
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
		AES256Util aes256Util = new AES256Util();
		MemberRequest memberReq = new MemberRequest();
		req.setCharacterEncoding("utf-8");
		memberReq.setUserid(req.getParameter("userid"));
		memberReq.setUpw(aes256Util.encrypt(req.getParameter("upw")));
		memberReq.setUpw2(aes256Util.encrypt(req.getParameter("upw2")));
		memberReq.setUemail(req.getParameter("uemail"));
		memberReq.setUname(req.getParameter("uname"));
		memberReq.setPhone(req.getParameter("phone"));
		memberReq.setSex(req.getParameter("sex"));
		memberReq.setAddress1(req.getParameter("address1"));
		memberReq.setAddress2(req.getParameter("address2"));
		memberReq.setAddress3(req.getParameter("address3"));
		
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);

		memberReq.validate(errors);

		if (!errors.isEmpty()) {
			return FORM_VIEW;
		}

		try {
	         memberService.memberInsert(memberReq);
	         return "/WEB-INF/ogani-master/login/joinSuccess.jsp";
	      
		} catch (DuplicateIdException e) {
			errors.put("duplicateId", Boolean.TRUE);
			return FORM_VIEW;
		}
	}

}
