package product.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.service.MainPage;
import auth.service.MainService;
import mvc.command.CommandHandler;

public class AucProductDetailHandler implements CommandHandler{
	private MainService mainService = new MainService();
	
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception{
	
	MainPage mainPage = mainService.getMainPage();
		req.setAttribute("mainPage", mainPage);
		return "/WEB-INF/ogani-master/product/aucProductDetail.jsp";
	}
	
	
	
	
}
