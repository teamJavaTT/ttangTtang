package product.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.service.User;
import mvc.command.CommandHandler;
import mypage.likeProduct.service.LikeProductService;
import product.service.ProductService;

public class LikeCountHandler implements CommandHandler {
	private ProductService productService = new ProductService();
	private LikeProductService likeProductService = new LikeProductService();
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		req.setCharacterEncoding("utf-8");
		HttpSession session = req.getSession(false);
		User user = (User) session.getAttribute("memberUser");
		String ino = req.getParameter("ino");
		String aucChk = req.getParameter("aucChk");

		int iNo = likeProductService.likeProductUser(user.getUserid(), ino);
		
		if(iNo == 0) {
			productService.likeCountUpdate(user.getUserid(), ino);
		}else {
			productService.likeCountSubtract(user.getUserid(), ino);
		}
		res.sendRedirect("productDetail.do?ino="+ino+"&aucChk="+aucChk);
		return null;
	}
}