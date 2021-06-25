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

public class ProductDetailHandler implements CommandHandler {
	private ProductService productService = new ProductService();
	private MainService mainService = new MainService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {

		req.setCharacterEncoding("utf-8");
		List<Category> category = mainService.getCategory();
		String aucChk = req.getParameter("aucChk");
		String ino = req.getParameter("ino");
	
		if (aucChk.equals("Y") || aucChk == "Y") {

			AucPro aucPro = productService.getAucPro(ino);
			req.setAttribute("category", category);
			req.setAttribute("allPro", aucPro);
			return "/WEB-INF/ogani-master/product/productDetail.jsp";

		} else {

			NorPro norPro = productService.getNorPro(ino);
			req.setAttribute("category", category);
			req.setAttribute("allPro", norPro);
			return "/WEB-INF/ogani-master/product/productDetail.jsp";
		}
	}

}
