package admin.qna.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import admin.notice.service.NoticeService;
import admin.notice.model.Notice;
import admin.notice.model.Noticecolumn;
import admin.notice.service.NoticeUser;
import admin.notice.service.ArticleNotFoundException;
import admin.notice.service.NoticeData;
import admin.notice.service.NoticePage;
import admin.notice.service.NoticeRequest;

public class OnamodifyHandler implements CommandHandler {
	private static final String FORM_VIEW = "/WEB-INF/ogani-master/admin/notice/noticemodify.jsp";
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
	
	// 데이터를 가져오는것
	private String processForm(HttpServletRequest req, HttpServletResponse res) throws Exception{
		String noVal = req.getParameter("no");
		int noticeNum = Integer.parseInt(noVal);
		try {
			NoticeData noticeData = noticeService.getNoticeMod(noticeNum);
			req.setAttribute("noticeData", noticeData);
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
		Notice modReq = new Notice(req.getParameter("title"), req.getParameter("content"));
		
		if (!errors.isEmpty()) {
			return FORM_VIEW;
		}

		int noticeModno = noticeService.noticemod(delNo, modReq);
		req.setAttribute("noticeModno", noticeModno);

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
