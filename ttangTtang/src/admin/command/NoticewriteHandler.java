package admin.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import admin.service.NoticeService;
import admin.model.Notice;
import admin.service.NoticeUser;
import admin.service.NoticePage;
import admin.service.NoticeRequest;

public class NoticewriteHandler implements CommandHandler {
	private static final String FORM_VIEW = "/WEB-INF/ogani-master/admin/noticewrite.jsp";
	private NoticeService noticeService = new NoticeService();

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
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);

		// NoticeRequest writeReq =new NoticeRequest(new Notice(noticeuser.getmno(),
		// noticeuser.getmtit(), noticeuser.getmtext(), noticeuser.getmdate()));
		Notice writeReq = new Notice(req.getParameter("title"), req.getParameter("content"));
		

		if (!errors.isEmpty()) {
			return FORM_VIEW;
		}

		int newArticleNo = noticeService.noticewrite(writeReq);
		req.setAttribute("newArticleNo", newArticleNo);

		return "/WEB-INF/ogani-master/admin/noticesuccess.jsp";
	}

	/*
	 * //값을 가져오는 거
	 * 
	 * @Override public String process(HttpServletRequest req, HttpServletResponse
	 * res) throws Exception { NoticewritePage noticewritePage =
	 * noticewriteService.getNoticewritePage(); req.setAttribute("noticewritePage",
	 * noticewritePage); return "/WEB-INF/ogani-master/index.jsp"; }
	 */

}
