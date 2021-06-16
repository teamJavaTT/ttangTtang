package product.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import product.model.NorPro;
import product.service.ProductService;

public class NorProductDetailHandler implements CommandHandler{
	private ProductService productService = new ProductService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception{
	
		List<NorPro> norPro = productService.getNorPro();
		req.setAttribute("norPro",norPro);
		return "/WEB-INF/ogani-master/product/norProductDetail.jsp";
		
		
	}

}
