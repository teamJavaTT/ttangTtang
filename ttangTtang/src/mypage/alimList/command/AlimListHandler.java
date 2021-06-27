package mypage.alimList.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.Alim;
import member.service.User;
import mvc.command.CommandHandler;
import mypage.alimList.service.AlimListService;

public class AlimListHandler implements CommandHandler {

	private static final String FORM_VIEW = "/WEB-INF/ogani-master/mypage/alimList.jsp";
	private AlimListService alimListService = new AlimListService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		req.setCharacterEncoding("utf-8");
		HttpSession session = req.getSession(false);
		User user = (User) session.getAttribute("memberUser");
		List<Alim> alimAll = alimListService.alimAll(user.getUserid());
		req.setAttribute("alimAll", alimAll);
		alimListService.alimChkUpdate(user.getUserid());
		req.getSession().setAttribute("alim", null);
		return FORM_VIEW;
	}

}
