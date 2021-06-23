package mypage.blockUser.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.Member;
import member.service.MemberService;
import member.service.User;
import mvc.command.CommandHandler;
import mypage.blockUser.service.BlockUserService;

public class BlockUserHandler implements CommandHandler {

	private static final String FORM_VIEW = "/WEB-INF/ogani-master/mypage/blockUser.jsp";
	private BlockUserService blockUserService = new BlockUserService();

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
			String blockid = req.getParameter("blockid");
			Member member = memberService.selectById(blockid);

			if (member == null) {
				req.setAttribute("idBlockOk", 0);
				return FORM_VIEW;
			} else {

				if (user.getUserid() == member.getUserid() || user.getUserid().equals(member.getUserid())) {
					req.setAttribute("idBlockOk", 2);

				} else {
					req.setAttribute("idBlockOk", 1);

				}
				return FORM_VIEW;
			}

		} else {

			req.setCharacterEncoding("utf-8");

			// String userId = user.getUserid();
			String userId = "ssmsm";
			String bId = req.getParameter("blockid2");
			String bText = req.getParameter("btext");
			blockUserService.getBlockUser(userId, bId, bText);

			return "/WEB-INF/ogani-master/mypage/blockSuccess.jsp";
		}
	}
}
