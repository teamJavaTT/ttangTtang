package product.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import product.service.ProductPage;
import product.service.ProductService;

public class norProductHandler implements  CommandHandler {

	private norProductService norproductService = new norProductService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ProductPage productPage = productService.getProductPage();
		req.setAttribute("ProductPage", productPage);
		return "/WEB-INF/ogani-master/product/shop-grid.jsp";
	}



	
	
	

}

