package org.zerock.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
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

	@Resource(name = "uploadPath")
	private String uploadPath;// "c:\\zzz\\upload"

	// 사진 등록

//	  @RequestMapping(value = "/uploadForm", method = RequestMethod.GET) public
//	  void uploadForm() { }
//	  
//	  @RequestMapping(value = "/uploadForm", method = RequestMethod.POST) public
//	  String uploadForm(MultipartFile file, Model model) throws Exception {
//	  
//	  String savedName = uploadFile(file.getOriginalFilename(), file.getBytes());
//	  model.addAttribute("savedName", savedName); return "uploadResult"; } private
//	  String uploadFile(String originalName, byte[] fileData) throws Exception {
//	  UUID uid = UUID.randomUUID(); String savedName = uid.toString() + "_" +
//	  originalName; File target = new File(uploadPath, savedName);
//	  FileCopyUtils.copy(fileData, target); return savedName; }
//	 
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
	private String productWritePost(Model model, Product product, HttpServletRequest req, MultipartFile file)
			throws Exception {
		HttpSession session = req.getSession(false);
		User user = (User) session.getAttribute("memberUser");
		product.setTotalTime(Integer.parseInt(product.getEndDay()) + Integer.parseInt(product.getEndTime()));
		ArrayList<String> address = memberService.address(user.getUserid());

		System.out.println("originalName: " + file.getOriginalFilename());
		System.out.println("size: " + file.getSize());
		System.out.println("contentType: " + file.getContentType());

		model.addAttribute("category", category);
		model.addAttribute("address", address);
		String userid = user.getUserid();
		product.setUserid(userid);
		productService.insertProduct(product);
		return "/product/productSuccess";
	}

	// 상세페이지
	@RequestMapping(value = "/productDetail", method = RequestMethod.GET)
	public String productDetail(Model model, @RequestParam(value = "ino", required = true, defaultValue = "0") int ino)
			throws Exception {
		ProductDetail productDetail = productService.selectProduct(ino);
		productDetail.setCname(productService.selectCname(productDetail.getCcode()));
		model.addAttribute("allPro", productDetail);
		return "product/productDetail";
	}

	// 상품수정
//	@RequestMapping(value = "/productModify", method = RequestMethod.GET)
//	public void productModifyView(Model model, @RequestParam("ino") int ino) throws Exception {
//		ProductDetail productModify = productService.selectProduct(ino);
//		productModify.setCname(productService.selectCname(productModify.getCcode()));
//		model.addAttribute("category", category);
//		model.addAttribute("norPro", productModify);
//	}

//	@RequestMapping(value = "/productModify", method = RequestMethod.POST)
//	public void productModify(Model model, Product product, HttpServletRequest req, HttpServletResponse res)
//			throws Exception {
//		Product productModify = productService.productModify(product);
//		model.addAttribute("NorPro", productModify);
//
//		res.sendRedirect("/product/productDetail");
//	}

	// 글삭제
	@RequestMapping(value = "/productDelete")
	public void productDelete(Model model, @RequestParam(value = "ino", required = true, defaultValue = "0") int ino, HttpServletResponse res) throws Exception {
		
	productService.productDelete(ino);
	productService.likeDelete(ino);
  productService.aucProductTabDelete(ino);


		res.sendRedirect("/product/productDeleteSuccess");
	}
//글삭제 완료 
@RequestMapping(value = "/productDeleteSuccess", method = RequestMethod.GET)
public void productDeleteSuccessPage(Model model) throws Exception {
}

}