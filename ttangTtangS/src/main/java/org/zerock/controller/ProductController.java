package org.zerock.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.domain.Category;
import org.zerock.domain.ProductDetail;
import org.zerock.service.MainService;
import org.zerock.service.ProductService;

@Controller

@RequestMapping(value = "product")
public class ProductController {

	@Inject
	private ProductService productService;
	private MainService mainService;
//	private MemberService memberService = new MemberService();

	// 상품등록
	@RequestMapping(value = "/productWrite", method = RequestMethod.GET)
	public String productWriteGet(Model model) throws Exception {
		List<Category> category = mainService.selectCategory();
		model.addAttribute("category", category);
		// model.addAttribute("product",product);

		return "product/productWrite";

	}
	/*
	 * @RequestMapping(value = "/productWrite", method = RequestMethod.POST) public
	 * String productWriteAucPost( MultipartFile uploadFile,
	 * MultipartHttpServletRequest mtfRequest, Model model, HttpSession session,
	 * HttpServletRequest req) throws Exception { List<AucProduct> aucProduct =
	 * productService.insertAucProduct(); User user = (User)
	 * session.getAttribute("memberUser");
	 * model.addAttribute("aucproduct",aucProduct);
	 * 
	 * int endDay = Integer.parseInt(req.getParameter("endDay")); int endTime =
	 * Integer.parseInt(req.getParameter("endTime"));
	 * 
	 * model.setUserId(user.getUserid());
	 * model.setCategory(req.getParameter("categoryAuc"));
	 * model.setProductName(req.getParameter("productNameAuc"));
	 * model.setUad(req.getParameter("uadAuc"));
	 * model.setMinPrice(req.getParameter("minPrice"));
	 * model.setMaxPrice(req.getParameter("maxPrice"));
	 * model.setPriceText(req.getParameter("priceTextAuc").replace("\r\n", "<br>"));
	 * model.setImageFace("/ttangTtang/file/" + imageName);
	 * model.setAuctionTime(Integer.toString(endDay + endTime));
	 * 
	 * 
	 * return "product/productDetail";
	 * 
	 * }
	 * 
	 * @RequestMapping(value = "/productWrite", method = RequestMethod.POST) public
	 * String productWriteNorPost( MultipartFile uploadFile,
	 * MultipartHttpServletRequest mtfRequest, Model model, HttpSession session,
	 * HttpServletRequest req) throws Exception { List<NorProduct> norProduct =
	 * productService.insertNorProduct(); User user = (User)
	 * session.getAttribute("memberUser"); String id=user.getUserid();
	 * 
	 * model.addAttribute("norProduct",norProduct);
	 * 
	 * return "product/productDetail";
	 * 
	 * }
	 */

	// 상세페이지
	@RequestMapping(value = "/productDetail",method = RequestMethod.GET)
	public String productDetail(Model model,@RequestParam(value = "ino",required=true,defaultValue = "0") int ino)		throws Exception {
		ProductDetail productDetail = productService.selectProduct(ino);
		productDetail.setCname(productService.selectCname(productDetail.getCcode()));
		model.addAttribute("allPro", productDetail);
		return "product/productDetail";
	}

	// 상품수정
	@RequestMapping(value = "/productModify", method = RequestMethod.GET)
	public void productModifyView(Model model,@RequestParam(value = "ino",required=true,defaultValue = "0") int ino) throws Exception {
		ProductDetail productDetail = productService.selectProduct(ino);
		List<Category> category = mainService.selectCategory();
		model.addAttribute("category", category);
		model.addAttribute("NorPro", productDetail);	
	}
	@RequestMapping(value = "/productModify", method = RequestMethod.POST)
		public void productModifyPage(Model model, ProductDetail productDetail , HttpServletRequest req, HttpServletResponse res)throws Exception{
	ProductDetail productModify =  productService.productModify(productDetail);	
model.addAttribute("NorPro",productModify);

res.sendRedirect("/product/productDetail");
	}



}
