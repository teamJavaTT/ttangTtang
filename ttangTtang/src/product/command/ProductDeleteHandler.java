package product.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import product.service.ProductService;

public class ProductDeleteHandler implements CommandHandler {
	private ProductService productService = new ProductService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String requestNo = req.getParameter("ino");
		int delNo = Integer.parseInt(requestNo);
		
		productService.getAucDel(delNo);
		productService.getNorDel(delNo);

	
		

			return "/WEB-INF/ogani-master/product/productDeleteSuccess.jsp";
		}
	}
