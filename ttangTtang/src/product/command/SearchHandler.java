package product.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import product.service.ProductService;

import auth.service.MainService;
import auth.model.Category;
import auth.model.Product;

public class SearchHandler implements CommandHandler {
	private ProductService productService = new ProductService();
	private MainService mainService = new MainService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String search = req.getParameter("searchProduct");
		List<Product> searchProduct = productService.getSearchPage(search);
		List<Category> category = mainService.getCategory();
		req.setAttribute("searchProduct", searchProduct);
		req.setAttribute("category", category);
		return "/WEB-INF/ogani-master/product/searchProduct.jsp";
	}

}
