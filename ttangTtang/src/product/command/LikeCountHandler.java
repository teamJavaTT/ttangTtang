package product.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.service.User;
import mvc.command.CommandHandler;
import product.service.ProductService;

public class LikeCountHandler implements CommandHandler {
	private ProductService productService = new ProductService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		req.setCharacterEncoding("utf-8");
		HttpSession session = req.getSession(false);
		User user = (User) session.getAttribute("memberUser");
		String ino = req.getParameter("ino");


		productService.getAucPro(ino);
		productService.getNorPro(ino);
		productService.likeCountUpdate(user.getUserid(), ino);
		return  "productDetail.do?ino="+req.getParameter("ino")+"&aucChk="+req.getParameter("aucChk");

	}
}