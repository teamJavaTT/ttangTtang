package admin.notice.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.notice.service.NoticePage;
import admin.notice.service.NoticeService;
import auth.service.MainPage;
import mvc.command.CommandHandler;

public class NoticedeleteHandler implements CommandHandler {
	
	private NoticeService noticeService = new NoticeService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String requestNo = req.getParameter("no");
		int delNo = Integer.parseInt(requestNo);
		
		noticeService.getNoticeDelete(delNo);
		return "/WEB-INF/ogani-master/admin/notice/noticedeletesuccess.jsp";
	}

}
