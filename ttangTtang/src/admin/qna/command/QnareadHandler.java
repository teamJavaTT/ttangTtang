package admin.qna.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		QnaData qnaData = qnaService.getQnaRead(qnaNum);
		req.setAttribute("qnaData", qnaData);
		return "/WEB-INF/ogani-master/admin/qna/qnaread.jsp";
		
	}
}
