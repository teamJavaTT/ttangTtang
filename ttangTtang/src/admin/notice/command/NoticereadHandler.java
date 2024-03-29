package admin.notice.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.notice.service.NoticeData;
import admin.notice.service.NoticeService;
import mvc.command.CommandHandler;

public class NoticereadHandler implements CommandHandler {
	
private NoticeService noticeService = new NoticeService();
	

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String noVal = req.getParameter("no");
		int noticeNum = Integer.parseInt(noVal);
		NoticeData noticeData = noticeService.getNoticeRead(noticeNum);
		req.setAttribute("noticeData", noticeData);
		return "/WEB-INF/ogani-master/admin/notice/noticeread.jsp";
	}
}
