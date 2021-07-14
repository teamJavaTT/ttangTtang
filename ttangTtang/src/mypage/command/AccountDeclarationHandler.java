package mypage.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.Member;
import member.service.MemberService;
import member.service.User;
import mvc.command.CommandHandler;
import mypage.service.AccountDeclarationService;

public class AccountDeclarationHandler implements CommandHandler {

	private static final String FORM_VIEW = "/WEB-INF/ogani-master/mypage/accountDeclaration.jsp";
	private AccountDeclarationService accountDeclarationService = new AccountDeclarationService();

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
		MemberService memberService = new MemberService();
		
		req.setCharacterEncoding("utf-8");
		HttpSession session = req.getSession(false);
		User user = (User) session.getAttribute("memberUser");

		if (req.getParameter("no") == "1" || req.getParameter("no").equals("1")) {
			String badid = req.getParameter("badid");
			Member member = memberService.selectById(badid);
			if (member == null) {
				req.setAttribute("idChkOk", 0);
				return FORM_VIEW;
			} else {

				if (user.getUserid() == member.getUserid() || user.getUserid().equals(member.getUserid())) {
					req.setAttribute("idChkOk", 2);

				} else {
					req.setAttribute("idChkOk", 1);

				}
				return FORM_VIEW;
			}


		} else {

			
			req.setCharacterEncoding("utf-8");

			String userId = user.getUserid();
			String declId = req.getParameter("declId");
			String dText = req.getParameter("dtext");
			accountDeclarationService.getAccountDeclaration(userId, declId, dText);
			
			return "/WEB-INF/ogani-master/mypage/accountDeclarationSuccess.jsp";
		}
	}
}
