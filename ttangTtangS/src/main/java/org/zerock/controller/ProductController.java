package org.zerock.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.zerock.domain.Category;
import org.zerock.domain.Product;
import org.zerock.service.MainService;
import org.zerock.service.ProductService;

@Controller

@RequestMapping(value = "product")
public class ProductController {

	@Inject
	// private ProductService productService;
	private MainService mainService;
//	private MemberService memberService = new MemberService();

	// 상품등록
	@RequestMapping(value = "/productWrite", method = RequestMethod.GET)
	public String productWrite(Model model) throws Exception {
		List<Category> category = mainService.selectCategory();
		// List<Product> product = productService.selectProduct();
		model.addAttribute("category", category);
		// model.addAttribute("product",product);
		
		return "product/productWrite";

	}

	// 상세페이지
	@RequestMapping(value = "/productDetail", method = RequestMethod.GET)
	public void productDetail(Model model) throws Exception {

	}

	// 상품수정
	@RequestMapping(value = "/productModify", method = RequestMethod.GET)
	public void productModify(Model model) throws Exception {

	}

}
