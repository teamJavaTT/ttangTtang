package product.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.model.Category;
import auth.service.MainService;
import member.service.DuplicateIdException;
import mvc.command.CommandHandler;
import product.service.AucProRequest;
import product.service.ProductService;

public class AucProductHandler implements CommandHandler {
	private ProductService productService = new ProductService();
	private MainService mainService = new MainService();

	private static final String FORM_VIEW = "/WEB-INF/ogani-master/product/aucProductWrite.jsp";

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

	private String processForm(HttpServletRequest req, HttpServletResponse res) throws Exception {
		List<Category> category = mainService.getCategory();
		req.setAttribute("category", category);
		return FORM_VIEW;
	}



	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws Exception {
		AucProRequest aucReq = new AucProRequest();
		req.setCharacterEncoding("utf-8");
		aucReq.setProduct_name(req.getParameter("product_name"));
		aucReq.setProduct_name(req.getParameter("category"));
		aucReq.setMax_price(req.getParameter("max_price"));
		aucReq.setMin_price(req.getParameter("min_price"));
		aucReq.setDescription(req.getParameter("description"));
		aucReq.setImageface(req.getParameter("imageface"));

		
		try{
			productService.AucProInsert(aucReq);
			res.sendRedirect(req.getContextPath()+"/aucProductDetail.jsp");
		return null;
		}catch(DuplicateIdException e) {
			
		}
		return FORM_VIEW;
		}
		
	}
	// 상품 수정,상품 삭제

