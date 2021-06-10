package admin.faq.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.faq.service.ArticleNotFoundException;
import admin.faq.service.FaqData;
import admin.faq.service.FaqService;
import mvc.command.CommandHandler;

public class FaqreadHandler implements CommandHandler {
	
private FaqService faqService = new FaqService();
	

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) 
			throws Exception {
		String noVal = req.getParameter("no");
		int faqNum = Integer.parseInt(noVal);
		try {
			FaqData faqData = faqService.getFaqRead(faqNum);
			req.setAttribute("faqData", faqData);
			return "/WEB-INF/ogani-master/admin/faq/faqread.jsp";
		} catch (ArticleNotFoundException e) {
			req.getServletContext().log("no article", e);
			res.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
	}
}
