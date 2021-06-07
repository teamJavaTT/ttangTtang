package admin.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.service.NoticePage;
import admin.service.NoticeService;
import auth.service.MainPage;
import mvc.command.CommandHandler;

public class NoticereadHandler implements CommandHandler {
	
	private NoticeService noticeService = new NoticeService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		NoticePage noticePage = noticeService.getNoticePage();
		req.setAttribute("noticePage", noticePage);
		return "/WEB-INF/ogani-master/admin/notice/noticeread.jsp";
	}

}
