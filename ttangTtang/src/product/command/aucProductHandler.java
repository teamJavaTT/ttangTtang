package product.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import product.service.AucProRequest;
import product.service.AucProService;

public class aucProductHandler implements CommandHandler {
	private AucProService aucproService = new AucProService();
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

	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		return FORM_VIEW;
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws Exception {
	AucProRequest aucReq= new AucProRequest();
	aucReq.setProduct_name(req.getParameter("product_name"));
	aucReq.setProduct_name(req.getParameter("category"));
	aucReq.setMax_price(req.getParameter("max_price"));
	aucReq.setMin_price(req.getParameter("min_price"));
	aucReq.setDescription(req.getParameter("description"));

	return FORM_VIEW;
		
	}
	//상품 수정,상품 삭제 
	
}