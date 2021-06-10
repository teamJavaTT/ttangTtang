package admin.faq.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import admin.faq.service.FaqService;
import admin.faq.model.Faq;
import admin.faq.service.ArticleNotFoundException;
import admin.faq.service.FaqData;

public class FaqmodifyHandler implements CommandHandler {
	private static final String FORM_VIEW = "/WEB-INF/ogani-master/admin/notice/noticemodify.jsp";
	private FaqService faqService = new FaqService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		if (req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, res);
		} else if (req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, res);
		} else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}
	
	// 데이터를 가져오는것
	private String processForm(HttpServletRequest req, HttpServletResponse res) throws Exception{
		String noVal = req.getParameter("no");
		int faqNum = Integer.parseInt(noVal);
		try {
			FaqData faqData = faqService.getFaqMod(faqNum);
			req.setAttribute("faqData", faqData);
			return "/WEB-INF/ogani-master/admin/notice/noticemodify.jsp";
		} catch (ArticleNotFoundException e) {
			req.getServletContext().log("no article", e);
			res.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
	}
	
	
	// 데이터를 보내는 것
	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws Exception {
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);
		String requestNo = req.getParameter("no");
		int delNo = Integer.parseInt(requestNo);
		Faq modReq = new Faq(req.getParameter("title"), req.getParameter("content"));
		
		if (!errors.isEmpty()) {
			return FORM_VIEW;
		}

		int faqModno = faqService.faqmod(delNo, modReq);
		req.setAttribute("faqModno", faqModno);

		return "/WEB-INF/ogani-master/admin/notice/noticesuccess.jsp";
	}
}
