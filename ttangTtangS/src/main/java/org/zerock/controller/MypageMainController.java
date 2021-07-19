package org.zerock.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.domain.AccountDeclaration;
import org.zerock.domain.BlockUser;
import org.zerock.domain.Product;
import org.zerock.domain.Secession;
import org.zerock.domain.User;
import org.zerock.service.MypageMainService;

@Controller
@RequestMapping(value = "/mypage")
public class MypageMainController {
	private static final Logger logger = LoggerFactory.getLogger(MypageMainController.class);

	@Inject
	private MypageMainService mypagemainService;

	// 메인
	@RequestMapping(value = "/mypageMain")
	public void mypageMainPage(Model model) throws Exception {
	}

	// 신고
	@RequestMapping(value = "/accountDeclaration")
	public void accountDeclarationPage(Model model) throws Exception {

		List<AccountDeclaration> accountDeclaration = mypagemainService.selectAccountDeclaration();
		model.addAttribute("accountDeclaration", accountDeclaration);
	}

	// 차단
	@RequestMapping(value = "/blockUser")
	public void blockUserPage(Model model) throws Exception {

		List<BlockUser> blockUser = mypagemainService.selectBlockUser();
		model.addAttribute("blockUser", blockUser);
	}

	// 신고 및 차단 리스트
	@RequestMapping(value = "/declarationAndBlockList")
	public void declarationAndBlockListPage(Model model) throws Exception {

		List<AccountDeclaration> accountDeclaration = mypagemainService.selectAccountDeclaration();
		List<BlockUser> blockUser = mypagemainService.selectBlockUser();
		model.addAttribute("accountDeclaration", accountDeclaration);
		model.addAttribute("blockUser", blockUser);

	}

	// 관심상품
	@RequestMapping(value = "/likeProduct")
	public void likeProductPage(Model model, HttpServletRequest req) throws Exception {
		
		HttpSession session = req.getSession(false);
		User user = (User) session.getAttribute("memberUser");
		String userid = user.getUserid();
		
		List<Product> likeProduct = mypagemainService.selectLikeProduct(userid);
		model.addAttribute("likeProduct", likeProduct);
	}

	// 판매내역
	@RequestMapping(value = "/sellcheck", method = RequestMethod.GET)
	public void sellcheckPageGET(Model model, HttpServletRequest req) throws Exception {

		HttpSession session = req.getSession(false);
		User user = (User) session.getAttribute("memberUser");
		String userid = user.getUserid();
		
		List<Product> sellList = mypagemainService.selectSellList(userid, "A");
		model.addAttribute("sellList", sellList);
	}
	@RequestMapping(value = "/sellcheck", method = RequestMethod.POST)
	public void sellcheckPagePOST(Model model, @RequestParam("sellChk") String sellchk, HttpServletRequest req) throws Exception {

		HttpSession session = req.getSession(false);
		User user = (User) session.getAttribute("memberUser");
		String userid = user.getUserid();
		
		// List<Product> sellList = mypagemainService.selectSellList(userid);
		// model.addAttribute("sellList", sellList);
		if(sellchk == null) sellchk = "A";
		if (sellchk.equals("Y") || sellchk.equals("N")) {
			List<Product> sellList = mypagemainService.selectSellList(userid, sellchk);
			model.addAttribute("sellList", sellList);
		} else {
			List<Product> sellList = mypagemainService.selectSellList(userid, sellchk);
			model.addAttribute("sellList", sellList);
		}

	}

	// 회원탈퇴
	@RequestMapping(value = "/deleteForm")
	public void deleteFormPage(Model model) throws Exception {

		List<Secession> deleteForm = mypagemainService.selectDeleteForm();
		model.addAttribute("deleteForm", deleteForm);
	}

	// 회원정보 수정
	/*
	 * @RequestMapping(value = "/memberEdit") public String memberEditPage(Model
	 * model) throws Exception { return "member/memberEdit"; }
	 */

	// 고객센터
	@RequestMapping(value = "/adminmain")
	public String adminmainPage(Model model) throws Exception {
		return "admin/adminmain";
	}

}
