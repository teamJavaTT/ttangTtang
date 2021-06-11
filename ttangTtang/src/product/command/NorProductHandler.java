package product.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.service.MainPage;
import auth.service.MainService;
import mvc.command.CommandHandler;
import product.service.NorProRequeste;
import product.service.ProductService;

public class NorProductHandler implements CommandHandler {
	private ProductService norproService = new ProductService();
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
		MainPage mainPage = mainService.getMainPage();
		req.setAttribute("mainPage", mainPage);
		return FORM_VIEW;
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws Exception {
		NorProRequeste norReq=new NorProRequeste();
		norReq.setProduct_name(req.getParameter("product_name"));
		norReq.setCategory(req.getParameter("category"));
		norReq.setPrice(req.getParameter("price"));
		norReq.setDescription(req.getParameter("description"));

		return FORM_VIEW;
		
	}
	
	
}