package mypage.likeProduct.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import auth.model.Product;
import member.model.Member;
import member.service.MemberService;
import member.service.User;
import mvc.command.CommandHandler;
import mypage.likeProduct.service.LikeProductService;

public class LikeProductHandler implements CommandHandler {

	private static final String FORM_VIEW = "/WEB-INF/ogani-master/mypage/likeProduct.jsp";
	private LikeProductService likeProductService = new LikeProductService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		

		req.setCharacterEncoding("utf-8");
		HttpSession session = req.getSession(false);
		User user = (User) session.getAttribute("memberUser");
		List<Product> likeProduct = likeProductService.likeProduct(user.getUserid());
		req.setAttribute("likeProduct", likeProduct);

			return FORM_VIEW;
		
	}

}
