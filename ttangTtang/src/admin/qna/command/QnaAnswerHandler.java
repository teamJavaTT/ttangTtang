package admin.qna.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import admin.qna.service.QnaService;
import admin.qna.model.Qna;
import admin.qna.service.ArticleNotFoundException;
import admin.qna.service.QnaData;

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
		
		if (!errors.isEmpty()) {
			return "qnaread.do?no="+requestNo;
		}

		qnaService.qnaAnswerUpdate(ansNo, answerContent);
		
		return "qnaread.do?no="+requestNo;
	}
}
	