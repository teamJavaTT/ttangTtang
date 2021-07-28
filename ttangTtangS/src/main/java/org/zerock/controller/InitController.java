package org.zerock.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.zerock.domain.Category;
import org.zerock.service.InitService;


@Controller
public class InitController {
	@Inject
	private InitService initService;
	
	public static List<Category> category = null;
	@PostConstruct
	public final List<Category> initCategory() throws Exception {
		category = initService.selectCategory();
		return category;
	}
	
	@PostConstruct
	public final void initAuctionEnd() throws Exception {
		initService.auctionEnd();
	}
	
}
