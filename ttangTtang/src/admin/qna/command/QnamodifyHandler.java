package admin.qna.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import admin.qna.service.QnaService;
import admin.qna.model.Qna;
import admin.qna.service.ArticleNotFoundException;
import admin.qna.service.QnaData;

public class QnamodifyHandler implements CommandHandler {
	private static final String FORM_VIEW = "/WEB-INF/ogani-master/admin/notice/noticemodify.jsp";
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
	
	// 데이터를 가져오는것
	private String processForm(HttpServletRequest req, HttpServletResponse res) throws Exception{
		String noVal = req.getParameter("no");
		int qnaNum = Integer.parseInt(noVal);
		try {
			QnaData qnaData = qnaService.getQnaMod(qnaNum);
			req.setAttribute("QnaData", qnaData);
			return "/WEB-INF/ogani-master/admin/notice/noticemodify.jsp";
		} catch (ArticleNotFoundException e) {
			req.getServletContext().log("no article", e);
			res.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
	}
	
	
	// 데이터를 보내는 것
	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws Exception {
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);
		String requestNo = req.getParameter("no");
		int delNo = Integer.parseInt(requestNo);
		// NoticeRequest writeReq =new NoticeRequest(new Notice(noticeuser.getmno(),
		// noticeuser.getmtit(), noticeuser.getmtext(), noticeuser.getmdate()));
		Qna modReq = new Qna(req.getParameter("title"), req.getParameter("content"));
		
		if (!errors.isEmpty()) {
			return FORM_VIEW;
		}

		int qnaModno = qnaService.qnamod(delNo, modReq);
		req.setAttribute("noticeModno", qnaModno);

		return "/WEB-INF/ogani-master/admin/notice/noticesuccess.jsp";
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