package org.zerock.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.domain.Category;
import org.zerock.domain.Product;
import org.zerock.domain.ProductToday;
import org.zerock.service.MainService;


@Controller
@RequestMapping(value = "/ttangTtang")
public class MainController {
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);

	@Inject
	private MainService mainService;
	
	@RequestMapping(value = "/index")
	public void mainPage(Model model) throws Exception {
		List<Category> category = mainService.selectCategory();
		List<Product> product = mainService.selectProduct();
		List<ProductToday> productToday = mainService.selectProductToday();
		//mainService.auctionEnd();
		model.addAttribute("category", category);
		model.addAttribute("product", product);
		model.addAttribute("productToday", productToday);		
	}

}
