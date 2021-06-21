package member.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import AES256.AES256Util;
import member.model.Member;
import member.service.DuplicateIdException;
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
		Member member = memberService.selectById(user.getUserid());
		req.setAttribute("member", member);
		return FORM_VIEW;
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws Exception {
		AES256Util aes256Util = new AES256Util();
		MemberRequest memberEdit = new MemberRequest();
		req.setCharacterEncoding("utf-8");
		
		HttpSession session = req.getSession(false);
		User user = (User) session.getAttribute("memberUser");
		Member member = memberService.selectById(user.getUserid());
		
		String upw = "";
		String upw2 = "";
		if(req.getParameter("upw") == null | req.getParameter("upw") == "") {
			upw = aes256Util.decrypt(member.getUpw());
			upw2 = aes256Util.decrypt(member.getUpw());
		}else {
			upw = req.getParameter("upw");
			upw2 = req.getParameter("upw2");
		}
	
		memberEdit.setUserid(user.getUserid());
		memberEdit.setUpw(aes256Util.encrypt(upw));
		memberEdit.setUpw2(aes256Util.encrypt(upw2));
		memberEdit.setUemail(req.getParameter("uemail"));
		memberEdit.setPhone(req.getParameter("phone"));
		memberEdit.setAddress1(req.getParameter("address1"));
		memberEdit.setAddress2(req.getParameter("address2"));
		memberEdit.setAddress3(req.getParameter("address3"));

		try {
			memberService.memberEdit(memberEdit);
			res.sendRedirect(req.getContextPath() + "/index.do");
			return null;
		} catch (DuplicateIdException e) {
			return FORM_VIEW;
		}
	}
}
