package product.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import product.model.AucPro;
import product.service.ProductService;

public class AucProductDetailHandler implements CommandHandler{
	private ProductService productService = new ProductService();
	
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception{
	

	List<AucPro> aucPro = productService.getAucPro();
		req.setAttribute("aucPro", aucPro);
		return "/WEB-INF/ogani-master/product/aucProductDetail.jsp";
	}
	
	
	
	
}