package admin.faq.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.faq.service.FaqPage;
import admin.faq.service.FaqService;
import mvc.command.CommandHandler;

public class FaqlistHandler implements CommandHandler {
	
	private FaqService faqService = new FaqService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String pageVal = req.getParameter("pageNo");
		int pageNo = 1;
		if(pageVal != null) {
			pageNo = Integer.parseInt(pageVal);
		}
		FaqPage faqPage = faqService.getFaqPage(pageNo);
		req.setAttribute("faqPage", faqPage);
		return "/WEB-INF/ogani-master/admin/faq/faq.jsp";
	}

}
