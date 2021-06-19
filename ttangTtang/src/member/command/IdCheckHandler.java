package member.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import AES256.AES256Util;
import member.dao.MemberDao;
import member.service.IdFind;
import member.service.LoginFailException;
import member.service.MemberService;
import member.service.User;
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
		
		
		int check = MemberDao.
		logger.info(check + check); 
		
		req.setAttribute("check", check);
		req.setAttribute("userid", userid);
		
		return "/WEB-INF/ogani-master/login/idCheck.jsp"

}
}
