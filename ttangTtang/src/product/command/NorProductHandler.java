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
import product.service.NorProRequeste;
import product.service.ProductService;

public class NorProductHandler implements CommandHandler {
	private ProductService productService = new ProductService();
	private MainService mainService = new MainService();
	
	
	private static final String FORM_VIEW = "/WEB-INF/ogani-master/product/norProductWrite.jsp";

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
		NorProRequeste norReq=new NorProRequeste();
		HttpSession session = req.getSession(false);
		User user = (User) session.getAttribute("memberUser");
		
		req.setCharacterEncoding("utf-8");
		
		norReq.setProduct_name(user.getUserid());
		norReq.setProduct_name(req.getParameter("product_name"));
		norReq.setCategory(req.getParameter("category"));
		norReq.setPrice(req.getParameter("price"));
		norReq.setDescription(req.getParameter("description"));

		try{
			productService.NorProInsert(norReq);
			res.sendRedirect("/index.do");
		return null;
		}catch(DuplicateIdException e) {
			
		}
		return FORM_VIEW;
		}
		
	}
	
