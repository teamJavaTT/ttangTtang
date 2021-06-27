package auth.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import auth.service.MainService;
import auth.model.Category;
import auth.service.MainPage;

public class MainHandler implements CommandHandler {
	
	private MainService mainService = new MainService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		MainPage mainPage = mainService.getMainPage();
		List<Category> category = mainService.getCategory();
		mainService.auctionEnd();
		req.setAttribute("mainPage", mainPage);
		req.setAttribute("category", category);
		return "/WEB-INF/ogani-master/index.jsp";
	}

}
