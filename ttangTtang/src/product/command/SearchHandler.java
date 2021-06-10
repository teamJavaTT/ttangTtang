package product.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import product.service.SearchService;

import auth.service.MainService;
import auth.model.Category;
import auth.model.Product;

public class SearchHandler implements CommandHandler {
	
	private SearchService searchService = new SearchService();
	private MainService mainService = new MainService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String search = req.getParameter("searchProduct");
		List<Product> searchProduct = searchService.getSearchPage(search);
		List<Category> category = mainService.getCategory();
		req.setAttribute("searchProduct", searchProduct);
		req.setAttribute("category", category);
		return "/WEB-INF/ogani-master/product/searchProduct.jsp";
	}

}
