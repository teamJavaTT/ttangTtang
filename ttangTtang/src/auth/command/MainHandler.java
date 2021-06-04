package auth.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import auth.service.MainService;
import auth.service.ArticlePage;

public class MainHandler implements CommandHandler {
	
	private MainService mainService = new MainService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ArticlePage articlePage = mainService.getMainPage();
		req.setAttribute("articlePage", articlePage);
		return "/WEB-INF/ogani-master/index.jsp";
	}

}
