package admin.qna.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import admin.qna.service.QnaService;

public class QnaAnswerHandler implements CommandHandler {
	private QnaService qnaService = new QnaService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		req.setCharacterEncoding("utf-8");
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);
		String requestNo = req.getParameter("qno");
		int ansNo = Integer.parseInt(requestNo);
		String answerContent = req.getParameter("answerContent");
		String answerPatext = req.getParameter("patext");

		qnaService.qnaAnswerUpdate(ansNo, answerContent, answerPatext);
		
		return "qnaread.do?no="+requestNo;
	}
}
	