package org.zerock.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	List<Category> category = MainController.category;

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
		ArrayList<String> address = memberService.address(user.getUserid());

		model.addAttribute("category", category);
		model.addAttribute("address", address);
		String userid = user.getUserid();
		product.setUserid(userid);
		productService.insertProduct(product);
		return "/product/productSuccess";
	}

	// 상세페이지
	@RequestMapping(value = "/productDetail", method = RequestMethod.GET)
	public String productDetail(Model model,@RequestParam(value = "ino", required = true, defaultValue = "0") int ino,HttpServletRequest req)
			throws Exception {
		HttpSession session = req.getSession(false);
		User user = (User) session.getAttribute("memberUser");
		ProductDetail productDetail = productService.selectProduct(ino);
		productDetail.setCname(productService.selectCname(productDetail.getCcode()));
		int ibo = 0;
		if(user != null) 
			ibo = productService.likeProductUser(user.getUserid(), ino);
		else 
			ibo = 0;
		Map<String, Integer> iNo = new HashMap<>(ibo);
		 
		model.addAttribute("iNo", iNo);
		model.addAttribute("allPro", productDetail);
		productService.viewCountUpdate(ino);
		return "product/productDetail";
	}

	// 상품수정
	@RequestMapping(value = "/productModify", method = RequestMethod.GET)
	public String productModifyGet(Model model, @RequestParam("ino") int ino) throws Exception {
		ProductDetail productModify = productService.selectProduct(ino);
		productModify.setCname(productService.selectCname(productModify.getCcode()));
		model.addAttribute("category", category);
		model.addAttribute("allPro", productModify);
		return "/product/productModify";
	}

	@RequestMapping(value = "/productModify", method = RequestMethod.POST)
	public String productModifyPost(Model model, Product product, HttpServletRequest req, HttpServletResponse res)
			throws Exception {
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
	@RequestMapping(value = "/likeCount")
	public int likeProductCount(Model model,@RequestParam(value = "userId", required = false) String userId) throws Exception {
	
		int iNoCount = productService.likeProductCount(userId);
		return iNoCount;
	}
//
//	@RequestMapping(value = "/likeCount")
//	public String likeService(Model model, @RequestParam(value = "ino", required = true, defaultValue = "0") String num,
//			HttpServletRequest req, HttpServletResponse res) throws Exception {
//		HttpSession session = req.getSession(false);
//		User user = (User) session.getAttribute("memberUser");
//		int ino = Integer.parseInt(num);
//		int iNo = productService.likeProductUser(user.getUserid(), ino);
//		String aucChk = req.getParameter("aucChk");
//		if (iNo == 0) {
//			productService.likeCountUpdate(user.getUserid(), ino);
//		} else {
//			productService.likeCountSubtract(user.getUserid(), ino);
//		}
//		String likeCount = productService.likeProductCount(user.getUserid());
//		req.getSession().setAttribute("likeCount", likeCount);
//		res.sendRedirect("productDetail?ino=" + ino + "&aucChk=" + aucChk);
//		return null;
//	}
}