package org.zerock.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.domain.Category;
import org.zerock.domain.ProductDetail;
import org.zerock.domain.User;
import org.zerock.dto.Product;
import org.zerock.service.MainService;
import org.zerock.service.MemberService;
import org.zerock.service.ProductService;



@Controller

@RequestMapping(value = "/product/*")
public class ProductController {
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	@Inject
	private ProductService productService;
	@Inject
	private MainService mainService;
	@Inject
	private MemberService memberService;
	
  @Resource(name = "uploadPath")
	  private String uploadPath;

	  //사진 등록
	  @RequestMapping(value = "/uploadForm", method = RequestMethod.GET)
	  public void uploadForm() {
	  }
	  @RequestMapping(value = "/uploadForm", method = RequestMethod.POST)
	  public String uploadForm(MultipartFile file, Model model) throws Exception {
	  logger.info("originalName: " + file.getOriginalFilename());
	  logger.info("size: " + file.getSize());
	  logger.info("contentType: " + file.getContentType());
	  String savedName = uploadFile(file.getOriginalFilename(), file.getBytes());
	  model.addAttribute("savedName", savedName);
	  return "uploadResult";
	  }
	  private String uploadFile(String originalName, byte[] fileData) throws Exception {
	  UUID uid = UUID.randomUUID();
	  String savedName = uid.toString() + "_" + originalName;
	  File target = new File(uploadPath, savedName);
	  FileCopyUtils.copy(fileData, target);
	  return savedName;
	  }
	  
	// 상품등록
	@RequestMapping(value = "/productWrite", method = RequestMethod.GET)
	private String productWriteGet(Model model,HttpServletRequest req) throws Exception {
		HttpSession session = req.getSession(false);
		User user = (User) session.getAttribute("memberUser");
		ArrayList<String> address = memberService.address(user.getUserid());
		List<Category> category = mainService.selectCategory();
	
		model.addAttribute("category", category);
		model.addAttribute("address", address);
		return "product/productWrite";

	}
	@RequestMapping(value = "/productWrite", method = RequestMethod.POST)
	private String productWrite(Model model,Product product,HttpServletRequest req) throws Exception {
		HttpSession session = req.getSession(false);
		User user = (User) session.getAttribute("memberUser");
		product.setTotalTime(Integer.parseInt(product.getEndDay())+Integer.parseInt(product.getEndTime()));
		ArrayList<String> address = memberService.address(user.getUserid());
		List<Category> category = mainService.selectCategory();
		model.addAttribute("category", category);
		model.addAttribute("address", address);
		String userid = user.getUserid();
		product.setUserid(userid);
		productService.insertProduct(product);
		return "/product/producSuccess";
		
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
	@RequestMapping(value = "/productModify", method = RequestMethod.GET)
	public void productModifyView(Model model, @RequestParam("ino") int ino) throws Exception {
		ProductDetail productModify = productService.selectProduct(ino);
		List<Category> category = mainService.selectCategory();
		productModify.setCname(productService.selectCname(productModify.getCcode()));
		model.addAttribute("category", category);
		model.addAttribute("norPro", productModify);
	}

	/*
	 * @RequestMapping(value = "/productModify", method = RequestMethod.POST) public
	 * void productModify(Model model, Product product, HttpServletRequest req,
	 * HttpServletResponse res) throws Exception { Product productModify =
	 * productService.productModify(product); model.addAttribute("NorPro",
	 * productModify);
	 * 
	 * res.sendRedirect("/product/productDetail"); }
	 */

}
