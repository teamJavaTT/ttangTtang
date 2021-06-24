package product.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.service.User;
import mvc.command.CommandHandler;
import product.service.ProductService;

public class AuctionPartHandler implements CommandHandler {
	private ProductService productService = new ProductService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		HttpSession session = req.getSession(false);
		User user = (User) session.getAttribute("memberUser");
		
		String aucIno = req.getParameter("aucIno");
		String oPrice = req.getParameter("oPrice");
		
		productService.auctionPartInsert(user.getUserid(), aucIno, oPrice);
		req.setAttribute("aucOk", 1);
		return "productDetail.do?ino="+aucIno+"&aucChk=Y";
	}

}
