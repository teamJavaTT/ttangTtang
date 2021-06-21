package admin.notice.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import admin.notice.service.NoticeService;
import admin.notice.model.Notice;
import admin.notice.service.NoticeData;

public class NoticemodifyHandler implements CommandHandler {
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
		NoticeData noticeData = noticeService.getNoticeRead(noticeNum);
		req.setAttribute("noticeData", noticeData);
		return "/WEB-INF/ogani-master/admin/notice/noticemodify.jsp";
	}
	
	
	// 데이터를 보내는 것
	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws Exception {
		req.setCharacterEncoding("utf-8");
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);
		String requestNo = req.getParameter("no");
		int delNo = Integer.parseInt(requestNo);
		Notice modReq = new Notice(req.getParameter("title"), req.getParameter("content").replace("\r\n", "<br>"));
		
		if (!errors.isEmpty()) {
			return FORM_VIEW;
		}

		int noticeModno = noticeService.noticeMod(delNo, modReq);
		req.setAttribute("noticeModno", noticeModno);

		return "/WEB-INF/ogani-master/admin/notice/noticesuccess.jsp";
	}
}
