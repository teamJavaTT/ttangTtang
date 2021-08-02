package org.zerock.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.domain.Category;
import org.zerock.domain.ProductDetail;
import org.zerock.domain.User;
import org.zerock.dto.LikeProduct;
import org.zerock.dto.Product;
import org.zerock.service.MemberService;
import org.zerock.service.ProductService;

@Controller

@RequestMapping(value = "/product/*")
public class ProductController {
	@Inject
	private ProductService productService;

	@Inject
	private MemberService memberService;

	List<Category> category = InitController.category;

	// 상품등록
	@RequestMapping(value = "/productWrite", method = RequestMethod.GET)
	private String productWriteGet(Model model, Product product, HttpServletRequest req) throws Exception {
		HttpSession session = req.getSession(false);
		User user = (User) session.getAttribute("memberUser");

		ArrayList<String> address = memberService.address(user.getUserid());
		address.add(user.getAddress1());
		address.add(user.getAddress2());
		address.add(user.getAddress3());

		model.addAttribute("category", category);
		model.addAttribute("address", address);
		return "product/productWrite";

	}

	@RequestMapping(value = "/productWrite", method = RequestMethod.POST)
	private String productWritePost(Model model, Product product, HttpServletRequest req) throws Exception {
		HttpSession session = req.getSession(false);
		User user = (User) session.getAttribute("memberUser");
		product.setTotalTime(Integer.parseInt(product.getEndDay()) + Integer.parseInt(product.getEndTime()));
		product.setUserid(user.getUserid());
		productService.insertProduct(product);
		return "/product/productSuccess";
	}

	// 상세페이지
	@RequestMapping(value = "/productDetail", method = RequestMethod.GET)
	public String productDetail(Model model, @RequestParam(value = "ino", required = true, defaultValue = "0") int ino,
			HttpServletRequest req) throws Exception {
		HttpSession session = req.getSession(false);
		User user = (User) session.getAttribute("memberUser");
		ProductDetail productDetail = productService.selectProduct(ino);
		productDetail.setCname(productService.selectCname(productDetail.getCcode()));

		int iNo=0;
		if(user != null) iNo= productService.likeProductUser(user.getUserid(), ino);
		else iNo = 0;

		String ibo = Integer.toString(ino);
		List<Product> productUser = productService.productUser(productDetail.getUserid(), ibo);
		
		model.addAttribute("iNo", iNo);
		
		model.addAttribute("allPro", productDetail);
		model.addAttribute("user", user);
		model.addAttribute("productUser", productUser);
		productService.viewCountUpdate(ino);
		return "product/productDetail";
	}

	// 상품수정
	@RequestMapping(value = "/productModify", method = RequestMethod.GET)
	public String productModifyGet(Model model, @RequestParam("ino") int ino, HttpServletRequest req) throws Exception {
		HttpSession session = req.getSession(false);
		User user = (User) session.getAttribute("memberUser");
		ProductDetail productModify = productService.selectProduct(ino);
		productModify.setCname(productService.selectCname(productModify.getCcode()));
		ArrayList<String> address = memberService.address(user.getUserid());
		address.add(user.getAddress1());
		address.add(user.getAddress2());
		address.add(user.getAddress3());
		model.addAttribute("address", address);
		model.addAttribute("category", category);
		model.addAttribute("allPro", productModify);
		return "/product/productModify";
	}

	@RequestMapping(value = "/productModify", method = RequestMethod.POST)
	public String productModifyPost(Product product, @RequestParam("ino") int ino, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		HttpSession session = req.getSession(false);
		User user = (User) session.getAttribute("memberUser");
		product.setUserid(user.getUserid());
		product.setIno(Integer.toString(ino));
		productService.productModify(product);

		return "/product/modifySuccess";
	}

	// 글삭제
	@RequestMapping(value = "/productDelete")
	public void productDelete(Model model, @RequestParam(value = "ino", required = true, defaultValue = "0") int ino,
			HttpServletResponse res) throws Exception {

		model.addAttribute("category", category);
		productService.productDelete(ino);
		productService.likeDelete(ino);
		productService.aucProductTabDelete(ino);

		res.sendRedirect("/product/productDeleteSuccess");
	}

//글삭제 완료 
	@RequestMapping(value = "/productDeleteSuccess", method = RequestMethod.GET)
	public void productDeleteSuccessPage(Model model) throws Exception {
	}

// 찜하기

	@RequestMapping(value = "/likeCountInsert")
	public String likeProductCountInsert(Model model, LikeProduct likeProduct, HttpServletRequest req,
			HttpServletResponse res, @RequestParam(value = "ino", required = true, defaultValue = "0") int ino)
			throws Exception {
		HttpSession session = req.getSession(false);
		User user = (User) session.getAttribute("memberUser");
		String userid = user.getUserid();
		String aucChk = req.getParameter("aucChk");

		int iNo = productService.likeProductUser(userid, ino);
		if (iNo == 0) {
			productService.likeProductCountInsert(userid, ino);
			productService.likeCountUpdate(userid, ino);
		} else {
			productService.likeCountDelete(userid, ino);
			productService.likeCountSubtract(user.getUserid(), ino);
		}
		int likeCount = productService.likeProductCount(user.getUserid());
		model.addAttribute("likeCount", likeCount);
		res.sendRedirect("productDetail?ino=" + ino + "&aucChk=" + aucChk);
		return null;

	}
}
