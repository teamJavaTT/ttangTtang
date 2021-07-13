package member.command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import AES256.AES256Util;
import member.model.Alim;
import member.service.LoginFailException;
import member.service.MemberService;
import member.service.PasswordFailException;
import member.service.User;
import mvc.command.CommandHandler;
import mypage.service.AlimListService;
import mypage.service.LikeProductService;

public class LoginHandler implements CommandHandler {

	private static final String FORM_VIEW = "/WEB-INF/ogani-master/login/login.jsp";
	private MemberService memberService = new MemberService();
	private LikeProductService likeProductService = new LikeProductService();
	private AlimListService alimListService = new AlimListService();
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
		HttpSession session = req.getSession(false);
		User user = (User) session.getAttribute("memberUser");
		
		if(user == null) {
			req.setAttribute("login", false);
		}else {
			req.setAttribute("login", true);
		}
		
		return FORM_VIEW;
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws Exception {
		AES256Util aes256Util = new AES256Util();
		String id = req.getParameter("userid");
		String password = aes256Util.encrypt(req.getParameter("upw"));

		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);

		if (id == null || id.isEmpty())
			errors.put("id", Boolean.TRUE);
		if (password == null || password.isEmpty())
			errors.put("password", Boolean.TRUE);

		if (!errors.isEmpty()) {
			return FORM_VIEW;
		}

		try {
			User user = memberService.login(id, password);
						
			if(user.getMemberChk() == "1" || user.getMemberChk().equals("1")) {
				int likeCount = likeProductService.likeProductCount(user.getUserid());
				ArrayList<Alim> alimList = alimListService.alimSelect(user.getUserid());
				req.getSession().setAttribute("alim", alimList);
				req.getSession().setAttribute("memberUser", user);
				req.getSession().setAttribute("userid", user.getUserid());
				req.getSession().setAttribute("likeCount", likeCount);
				res.sendRedirect("index.do");
			}else {
				req.setAttribute("memberChk", 2);
				return FORM_VIEW;
			}
			return null;
		} catch (LoginFailException e) {
			req.setAttribute("login", false);
			errors.put("idNotMatch", Boolean.TRUE);
			return FORM_VIEW;
		} catch (PasswordFailException e) {
			req.setAttribute("login", false);
			errors.put("pwdNotMatch", Boolean.TRUE);
			return FORM_VIEW;
		}
	}

}
