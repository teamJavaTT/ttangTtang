package admin.faq.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import admin.faq.service.FaqService;
import admin.faq.model.Faq;

public class FaqwriteHandler implements CommandHandler {
	private static final String FORM_VIEW = "/WEB-INF/ogani-master/admin/faq/faqwrite.jsp";
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

	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		return FORM_VIEW;
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws Exception {
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);
		Faq writeReq = new Faq(req.getParameter("title"), req.getParameter("content"));
		
		if (!errors.isEmpty()) {
			return FORM_VIEW;
		}

		int newArticleNo = faqService.faqwrite(writeReq);
		req.setAttribute("newArticleNo", newArticleNo);

		return "/WEB-INF/ogani-master/admin/faq/faqsuccess.jsp";
	}
}
