package org.zerock.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.domain.AccountDeclaration;
import org.zerock.domain.BlockUser;
import org.zerock.domain.LikeProduct;
import org.zerock.service.MypageMainService;

@Controller
@RequestMapping(value = "/mypage")
public class MypageMainController {
	private static final Logger logger = LoggerFactory.getLogger(MypageMainController.class);

	@Inject
	private MypageMainService mypagemainService;

	// ����
	@RequestMapping(value = "/mypageMain")
	public void mainPage(Model model) throws Exception {
	}

	// �Ű�
	@RequestMapping(value = "/accountDeclaration")
	public void mainPage1(Model model) throws Exception {

		List<AccountDeclaration> accountDeclaration = mypagemainService.selectAccountDeclaration();
		model.addAttribute("accountDeclaration", accountDeclaration);
	}

	// ����
	@RequestMapping(value = "/blockUser")
	public void mainPage2(Model model) throws Exception {

		List<BlockUser> blockUser = mypagemainService.selectBlockUser();
		model.addAttribute("blockUser", blockUser);
	}

	// �Ű� �� ���� ����Ʈ
	@RequestMapping(value = "/declarationAndBlockList")
	public void mainPage3(Model model) throws Exception {
		List<AccountDeclaration> accountDeclaration = mypagemainService.selectAccountDeclaration();
		List<BlockUser> blockUser = mypagemainService.selectBlockUser();
		model.addAttribute("accountDeclaration", accountDeclaration);
		model.addAttribute("blockUser", blockUser);
		
	}

	// ���ɻ�ǰ
		@RequestMapping(value = "/likeProduct")
		public void mainPage4(Model model) throws Exception {

			List<LikeProduct> likeProduct = mypagemainService.selectLikeProduct();
			model.addAttribute("likeProduct", likeProduct);
		}
}
