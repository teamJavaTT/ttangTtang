package product.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import auth.model.Category;
import auth.service.MainService;
import member.service.DuplicateIdException;
import member.service.User;
import mvc.command.CommandHandler;
import product.model.AucPro;
import product.model.NorPro;
import product.service.AucProRequest;
import product.service.NorProRequest;
import product.service.ProductService;

public class ProductModifyHandler implements CommandHandler {
	private static final String FORM_VIEW = "/WEB-INF/ogani-master/product/productModify.jsp";
	private ProductService productService = new ProductService();
	private MainService mainService = new MainService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {

		if (req.getMethod().equalsIgnoreCase("GET")) {
			
			return processForm(req, res);
		} else if (req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, res);
		} else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}

	}



	// 데이터 가져오기
	private String processForm(HttpServletRequest req, HttpServletResponse res) throws Exception {

		String ino = req.getParameter("ino");

		String aucChk = req.getParameter("aucChk");
		List<Category> category = mainService.getCategory();
		req.setAttribute("category", category);
		
		if (aucChk.equals("Y") || aucChk == "Y") {
			AucPro aucModi = productService.getAucPro(ino);
			req.setAttribute("aucPro", aucModi);
		} else {
			NorPro norModi = productService.getNorPro(ino);
			req.setAttribute("norPro", norModi);
		}
		return FORM_VIEW;
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws Exception {

		req.setCharacterEncoding("utf-8");
		NorProRequest norReq = new NorProRequest();
		AucProRequest aucReq = new AucProRequest();
		HttpSession session = req.getSession(false);
		User user = (User) session.getAttribute("memberUser");
		req.setCharacterEncoding("utf-8");
		String ino = req.getParameter("ino");

		String aucChk = req.getParameter("aucChk");
		if (aucChk.equals("Y") || aucChk == "Y") {
			String imageName = "";
			if (req.getParameter("imagefaceNameAuc") == null || req.getParameter("imagefaceNameAuc").isEmpty()) {
				imageName = "noimage.jpg";
			} else {
				imageName = req.getParameter("imagefaceNameAuc");
			}

			int endDay = Integer.parseInt(req.getParameter("endDay"));
			int endTime = Integer.parseInt(req.getParameter("endTime"));
			aucReq.setIno(req.getParameter("ino"));
			aucReq.setUserId(user.getUserid());
			aucReq.setCategory(req.getParameter("categoryAuc"));
			aucReq.setProductName(req.getParameter("productNameAuc"));
			aucReq.setMinPrice(req.getParameter("minPrice"));
			aucReq.setMaxPrice(req.getParameter("maxPrice"));
			aucReq.setPriceText(req.getParameter("priceTextAuc").replace("\r\n", "<br>"));
			aucReq.setImageFace("/ttangTtang/file/" + imageName);
			aucReq.setAuctionTime(Integer.toString(endDay + endTime));

			try {
				String aucModi = productService.aucProductModi(aucReq,ino);
				req.setAttribute("aucModi", aucModi);
				return "productDetail.do?ino="+req.getParameter("ino")+"&aucChk=Y";
			} catch (DuplicateIdException e) {

			}
		} else {
			String imageName = "";
			if (req.getParameter("imagefaceNameNor") == null || req.getParameter("imagefaceNameNor").isEmpty()) {
				imageName = "noimage.jpg";
			} else {
				imageName = req.getParameter("imagefaceNameNor");
			}
			norReq.setIno(req.getParameter("ino"));
			norReq.setUserId(user.getUserid());
			norReq.setCategory(req.getParameter("categoryNor"));
			norReq.setProductName(req.getParameter("productNameNor"));
			norReq.setPrice(req.getParameter("price"));
			norReq.setPriceText(req.getParameter("priceTextNor").replace("\r\n", "<br>"));
			norReq.setImageFace("/ttangTtang/file/" + imageName);

			try {
				String norModi = productService.norProductModi(norReq,ino);
				req.setAttribute("norModi", norModi);
		
			} catch (DuplicateIdException e) {

			}
				}
		return "productDetail.do?ino="+req.getParameter("ino")+"&aucChk="+req.getParameter("aucChk");
				
	}
}

