package admin.qna.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.qna.service.QnaPage;
import admin.qna.service.QnaService;
import mvc.command.CommandHandler;

public class QnalistHandler implements CommandHandler {
	
	private QnaService qnaService = new QnaService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String pageVal = req.getParameter("pageNo");
		int pageNo = 1;
		if(pageVal != null) {
			pageNo = Integer.parseInt(pageVal);
		}
		QnaPage qnaPage = qnaService.getQnaPage(pageNo);
		req.setAttribute("qnaPage", qnaPage);
		return "/WEB-INF/ogani-master/admin/qna/qna.jsp";
	}

}
