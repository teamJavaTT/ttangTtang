package admin.faq.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.faq.service.FaqService;
import mvc.command.CommandHandler;

public class FaqdeleteHandler implements CommandHandler {
	
	private FaqService faqService = new FaqService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String requestNo = req.getParameter("no");
		int delNo = Integer.parseInt(requestNo);
		
		faqService.getFaqDelete(delNo);
		return "/WEB-INF/ogani-master/admin/faq/faqdeletesuccess.jsp";
	}

}
