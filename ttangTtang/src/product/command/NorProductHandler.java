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
import product.service.NorProRequest;
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
		NorProRequest norReq=new NorProRequest();
		HttpSession session = req.getSession(false);
		User user = (User) session.getAttribute("memberUser");
		
		req.setCharacterEncoding("utf-8");
		
		String imageName = "";
		if(req.getParameter("imagefaceNameNor") == null || req.getParameter("imagefaceNameNor").isEmpty()) {
			imageName = "noimage.jpg";
		}else {
			imageName = req.getParameter("imagefaceNameNor");
		}
		
		norReq.setUserId(user.getUserid());
		norReq.setCategory(req.getParameter("categoryNor"));
		norReq.setProductName(req.getParameter("productNameNor"));
		norReq.setPrice(req.getParameter("price"));
		norReq.setPriceText(req.getParameter("priceTextNor").replace("\r\n","<br>"));
		norReq.setImageFace("/ttangTtang/file/"+imageName);
		
		try{
			productService.NorProInsert(norReq);
			res.sendRedirect("index.do");
		return null;
		}catch(DuplicateIdException e) {
			
		}
		return FORM_VIEW;
		}
		
	}
	
