package admin.qna.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.qna.service.ArticleNotFoundException;
import admin.qna.service.QnaData;
import admin.qna.service.QnaService;
import mvc.command.CommandHandler;

public class QnareadHandler implements CommandHandler {
	
private QnaService qnaService = new QnaService();
	

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) 
			throws Exception {
		String noVal = req.getParameter("no");
		int qnaNum = Integer.parseInt(noVal);
		try {
			QnaData qnaData = qnaService.getQnaRead(qnaNum);
			req.setAttribute("qnaData", qnaData);
			return "/WEB-INF/ogani-master/admin/notice/noticeread.jsp";
		} catch (ArticleNotFoundException e) {
			req.getServletContext().log("no article", e);
			res.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
	}
}
