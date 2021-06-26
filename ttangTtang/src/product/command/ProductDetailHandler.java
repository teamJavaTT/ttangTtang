package product.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import auth.model.Category;
import auth.service.MainService;
import member.service.User;
import mvc.command.CommandHandler;
import mypage.likeProduct.service.LikeProductService;
import product.model.AucPro;
import product.model.NorPro;
import product.service.ProductService;

public class ProductDetailHandler implements CommandHandler {
	private ProductService productService = new ProductService();
	private MainService mainService = new MainService();
	private LikeProductService likeProductService = new LikeProductService();
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {

		req.setCharacterEncoding("utf-8");
		HttpSession session = req.getSession(false);
		User user = (User) session.getAttribute("memberUser");

		List<Category> category = mainService.getCategory();
		String aucChk = req.getParameter("aucChk");
		String ino = req.getParameter("ino");
		int iNo = 0;
		
		if(user != null) {
			iNo = likeProductService.likeProductUser(user.getUserid(), ino);
		}
		else {
			iNo = 0;
		}
		
		if (aucChk.equals("Y") || aucChk == "Y") {
			AucPro aucPro = productService.getAucPro(ino);
			req.setAttribute("iNo", iNo);
			req.setAttribute("user", user);
			req.setAttribute("category", category);
			req.setAttribute("allPro", aucPro);
		} else {
			NorPro norPro = productService.getNorPro(ino);
			req.setAttribute("iNo", iNo);
			req.setAttribute("user", user);
			req.setAttribute("category", category);
			req.setAttribute("allPro", norPro);
		}
		return "/WEB-INF/ogani-master/product/productDetail.jsp";
	}
}
