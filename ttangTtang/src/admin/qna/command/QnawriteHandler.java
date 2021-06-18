package admin.qna.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import admin.qna.service.QnaService;
import admin.qna.model.Qna;

public class QnawriteHandler implements CommandHandler {
	private static final String FORM_VIEW = "/WEB-INF/ogani-master/admin/qna/qnawrite.jsp";
	private QnaService qnaService = new QnaService();

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
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);

		// NoticeRequest writeReq =new NoticeRequest(new Notice(noticeuser.getmno(),
		// noticeuser.getmtit(), noticeuser.getmtext(), noticeuser.getmdate()));
		Qna writeReq = new Qna(req.getParameter("userid"), req.getParameter("title"), req.getParameter("content").replace("\r\n", "<br>"));
		
		if (!errors.isEmpty()) {
			return FORM_VIEW;
		}

		int newArticleNo = qnaService.qnaWrite(writeReq);
		req.setAttribute("newArticleNo", newArticleNo);

		return "/WEB-INF/ogani-master/admin/qna/qnasuccess.jsp";
	}
}
