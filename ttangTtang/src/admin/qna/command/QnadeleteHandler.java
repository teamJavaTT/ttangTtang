package admin.qna.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.qna.service.QnaService;
import mvc.command.CommandHandler;

public class QnadeleteHandler implements CommandHandler {
	
	private QnaService qnaService = new QnaService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String requestNo = req.getParameter("no");
		int delNo = Integer.parseInt(requestNo);
		
		qnaService.getQnaDelete(delNo);
		return "/WEB-INF/ogani-master/admin/qna/qnadeletesuccess.jsp";
	}

}
