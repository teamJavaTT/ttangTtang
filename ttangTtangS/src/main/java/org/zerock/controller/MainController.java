package org.zerock.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.domain.Category;
import org.zerock.domain.Product;
import org.zerock.domain.ProductToday;
import org.zerock.domain.User;
import org.zerock.service.MainService;
import org.zerock.service.ProductService;

@Controller
public class MainController {
	@Inject
	private MainService mainService;
	@Inject
	private ProductService productService;

	List<Category> category = InitController.category;
	
	@RequestMapping(value = "/")
	public String mainPage(Model model, HttpServletRequest req) throws Exception {
		List<Product> product = mainService.selectProduct();
		List<ProductToday> productToday = mainService.selectProductToday();
		
		ArrayList<?> likeproduct = likeProductIno(req);
		model.addAttribute("likeproduct", likeproduct);
		model.addAttribute("category", category);
		model.addAttribute("product", product);
		model.addAttribute("productToday", productToday);

		return "index";
	}

	@RequestMapping(value = "/categories/{ccode}")
	public String categoryProduct(Model model, HttpServletRequest req, @PathVariable("ccode") String ccode) throws Exception {
		List<Product> categoryProduct = mainService.selectCategoryProduct(ccode);
		ArrayList<?> likeproduct = likeProductIno(req);
		model.addAttribute("chkCcode", ccode);
		model.addAttribute("likeproduct", likeproduct);
		model.addAttribute("category", category);
		model.addAttribute("categoryProduct", categoryProduct);

		return "product/categories";
	}

	@RequestMapping(value = "/search")
	public String searchProduct(Model model, HttpServletRequest req, @RequestParam("searchName") String search) throws Exception {
		List<Product> searchProduct = mainService.selectSearchProduct(search);
		ArrayList<?> likeproduct = likeProductIno(req);
		model.addAttribute("likeproduct", likeproduct);
		model.addAttribute("category", category);
		model.addAttribute("searchProduct", searchProduct);

		return "product/searchProduct";
	}

	public ArrayList<?> likeProductIno(HttpServletRequest req) throws Exception {
		HttpSession session = req.getSession(false);
		ArrayList<?> likeproduct = null;
		if (session != null) {
			User user = (User) session.getAttribute("memberUser");
			if (user != null) {
				String userid = user.getUserid();
				likeproduct = mainService.selectLikeproduct(userid);
			}
		}
		return likeproduct;
	}
	
	// 찜하기
	@RequestMapping(value = "/likeCountInsert", method = RequestMethod.POST)
	public String likeProductCountInsert(Model model, HttpServletRequest req, HttpServletResponse res,
			@RequestParam(value = "ino", required = true, defaultValue = "0") int ino) throws Exception {
		java.io.PrintWriter pw = res.getWriter();
		HttpSession session = req.getSession(false);
		User user = (User) session.getAttribute("memberUser");
		String userid = user.getUserid();

		int iNo = productService.likeProductUser(userid, ino);
		if (iNo == 0) {
			productService.likeProductCountInsert(userid, ino);
			productService.likeCountUpdate(userid, ino);
		} else {
			productService.likeCountDelete(userid, ino);
			productService.likeCountSubtract(user.getUserid(), ino);
		}
		pw.print(iNo);
		return null;
	}
}
