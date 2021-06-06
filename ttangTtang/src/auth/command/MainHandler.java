package auth.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import auth.service.MainService;
import auth.service.MainPage;

public class MainHandler implements CommandHandler {
	
	private MainService mainService = new MainService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		MainPage mainPage = mainService.getMainPage();
		req.setAttribute("mainPage", mainPage);
		return "/WEB-INF/ogani-master/index.jsp";
	}

}
