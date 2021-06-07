package admin.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.service.NoticePage;
import admin.service.NoticeService;
import auth.service.MainPage;
import mvc.command.CommandHandler;

public class NoticelistHandler implements CommandHandler {
	
	private NoticeService noticeService = new NoticeService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String pageVal = req.getParameter("pageNo");
		int pageNo = 1;
		if(pageVal != null) {
			pageNo = Integer.parseInt(pageVal);
		}
		NoticePage noticePage = noticeService.getNoticePage(pageNo);
		req.setAttribute("noticePage", noticePage);
		return "/WEB-INF/ogani-master/admin/notice/notice.jsp";
	}

}
