package org.zerock.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.domain.Category;
import org.zerock.domain.Product;
import org.zerock.domain.ProductToday;
import org.zerock.service.MainService;


@Controller
public class MainController {
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);

	@Inject
	private MainService mainService;
	
	List<Category> category = InitController.category;
	
	@RequestMapping(value = "/")
	public String mainPage(Model model) throws Exception {
		List<Product> product = mainService.selectProduct();
		List<ProductToday> productToday = mainService.selectProductToday();
		//mainService.auctionEnd();
		model.addAttribute("category", category);
		model.addAttribute("product", product);
		model.addAttribute("productToday", productToday);		
		
		return "index";
	}
	
	@RequestMapping(value = "/categories/{ccode}")
	public String categoryProduct(Model model, @PathVariable("ccode") String ccode) throws Exception {
		List<Product> categoryProduct = mainService.selectCategoryProduct(ccode);
		
		model.addAttribute("category", category);
		model.addAttribute("categoryProduct", categoryProduct);
		
		return "product/categories";
	}

	@RequestMapping(value = "/search")
	public String searchProduct(Model model, @RequestParam("searchName") String search) throws Exception {
		List<Product> searchProduct = mainService.selectSearchProduct(search);
		
		model.addAttribute("category", category);
		model.addAttribute("searchProduct", searchProduct);
		
		return "product/searchProduct";
	}
}
