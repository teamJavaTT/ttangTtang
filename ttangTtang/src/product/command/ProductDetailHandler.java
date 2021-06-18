package product.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.model.Category;
import auth.service.MainService;
import mvc.command.CommandHandler;
import product.model.AucPro;
import product.model.NorPro;
import product.service.ProductService;

public class ProductDetailHandler implements CommandHandler{
	private ProductService productService = new ProductService();
	private MainService mainService = new MainService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception{
	String pageVal = req.getParameter("ino");
    int ino =1;
	if (pageVal!=null) {
		ino = Integer.parseInt(pageVal);
	}
	List<Category> category = mainService.getCategory();
	List<AucPro> aucPro = productService.getAucPro(ino);
		req.setAttribute("category", category);
		req.setAttribute("aucPro", aucPro);
		return "/WEB-INF/ogani-master/product/aucProductDetail.jsp";
	}
	
	
	  
	


public String processNor(HttpServletRequest req, HttpServletResponse res) throws Exception{
	String pageVal = req.getParameter("ino");
    int ino =1;
	if (pageVal!=null) {
		ino = Integer.parseInt(pageVal);
	}
	List<Category> category = mainService.getCategory();
	List<NorPro> norPro = productService.getNorPro(ino);
	req.setAttribute("category",category);
	req.setAttribute("norPro",norPro);
	return "/WEB-INF/ogani-master/product/norProductDetail.jsp";
	
	
}

}
