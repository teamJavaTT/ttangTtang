package product.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.service.User;
import mvc.command.CommandHandler;
import product.service.ProductService;

public class ProductDeleteHandler implements CommandHandler {
	private ProductService productService = new ProductService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String requestNo = req.getParameter("ino");
		int delNo = Integer.parseInt(requestNo);
		req.setCharacterEncoding("utf-8");
		HttpSession session = req.getSession(false);
		User user = (User) session.getAttribute("memberUser");
		
		String ino = req.getParameter("ino");
	
		

		productService.aucProductTabDelete( user.getUserid(),ino);
		productService.getAucDel(delNo, user.getUserid(), ino);
		productService.getNorDel(delNo,user.getUserid(),ino);

	
		

			return "/WEB-INF/ogani-master/product/productDeleteSuccess.jsp";
		}
	}
