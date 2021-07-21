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
import org.zerock.dto.AccountDeclarationDTO;
import org.zerock.dto.BlockUserDTO;
import org.zerock.service.MemberService;
import org.zerock.service.MypageMainService;

@Controller
@RequestMapping(value = "/mypage")
public class MypageMainController {
	private static final Logger logger = LoggerFactory.getLogger(MypageMainController.class);

	@Inject
	private MypageMainService mypagemainService;
	@Inject
	private MemberService memberService;

	// 메인
	@RequestMapping(value = "/mypageMain")
	public void mypageMainPage(Model model) throws Exception {
	}

	// 신고
	@RequestMapping(value = "/accountDeclaration", method = RequestMethod.GET)
	public void accountDeclarationPageGET(Model model, HttpServletRequest req) throws Exception {

		HttpSession session = req.getSession(false);
		User user = (User) session.getAttribute("memberUser");
		String userid = user.getUserid();

		List<AccountDeclaration> accountDeclaration = mypagemainService.selectAccountDeclaration(userid, "D");
		model.addAttribute("accountDeclaration", accountDeclaration);
	}

	@RequestMapping(value = "/accountDeclaration", method = RequestMethod.POST)
	public String accountDeclarationPagePOST(AccountDeclarationDTO accountDec, Model model, @RequestParam("no") String no, 
			@RequestParam(value = "badid", required = false) String badid, @RequestParam(value = "declId", required = false) String declId, HttpServletRequest req)
			throws Exception {

		HttpSession session = req.getSession(false);
		User user = (User) session.getAttribute("memberUser");
		String userid = user.getUserid();

		if (no == "1" || no.equals("1")) {
			User member = memberService.selectById(badid);
			int countDec = mypagemainService.selectCountDec(userid, badid);
			
			if (member == null) {
				req.setAttribute("idChkOk", 0);
				return "/mypage/accountDeclaration";
			} else if (countDec != 0) { 
				req.setAttribute("idChkOk", 3);
				return "/mypage/accountDeclaration";
			}else {
				if (userid == member.getUserid() || userid.equals(member.getUserid())) {
					req.setAttribute("idChkOk", 2);
				} else {
					req.setAttribute("idChkOk", 1);
				}
				return "/mypage/accountDeclaration";
			}
		} else{
			req.setCharacterEncoding("utf-8");
			accountDec.setUserId(userid);
			
			mypagemainService.insertAccountDeclaration(accountDec);
			
			return "/mypage/accountDeclarationSuccess";
		}

	}

	// 차단
	@RequestMapping(value = "/blockUser", method = RequestMethod.GET)
	public void blockUserPageGET(Model model, HttpServletRequest req) throws Exception {

		HttpSession session = req.getSession(false);
		User user = (User) session.getAttribute("memberUser");
		String userid = user.getUserid();

		List<BlockUser> blockUser = mypagemainService.selectBlockUser(userid, "B");
		model.addAttribute("blockUser", blockUser);
	}


		@RequestMapping(value = "/blockUser", method = RequestMethod.POST)
		public String blockUserPagePOST(BlockUserDTO accountBl, Model model, @RequestParam("no") String no, 
				@RequestParam(value = "blockid", required = false) String blockid, @RequestParam(value = "blockid2", required = false) String blockid2, HttpServletRequest req)
				throws Exception {

			HttpSession session = req.getSession(false);
			User user = (User) session.getAttribute("memberUser");
			String userid = user.getUserid();

			if (no == "1" || no.equals("1")) {
				User member = memberService.selectById(blockid);
				int countBl = mypagemainService.selectCountBl(userid, blockid);
				
				if (member == null) {
					req.setAttribute("idBlockOk", 0);
					return "/mypage/blockUser";
				} else if (countBl != 0) { 
					req.setAttribute("idBlockOk", 3);
					return "/mypage/blockUser";
				}else {
					if (userid == member.getUserid() || userid.equals(member.getUserid())) {
						req.setAttribute("idBlockOk", 2);
					} else {
						req.setAttribute("idBlockOk", 1);
					}
					return "/mypage/blockUser";
				}
			} else{
				req.setCharacterEncoding("utf-8");
				accountBl.setUserId(userid);
				
				mypagemainService.insertBlockUser(accountBl);
				
				return "/mypage/blockSuccess";
			}

		}
	// 신고 및 차단 리스트
	@RequestMapping(value = "/declarationAndBlockList", method = RequestMethod.GET)
	public void declarationAndBlockListPageGET(Model model, HttpServletRequest req) throws Exception {

		HttpSession session = req.getSession(false);
		User user = (User) session.getAttribute("memberUser");
		String userid = user.getUserid();

		List<AccountDeclaration> accountDeclaration = mypagemainService.selectAccountDeclaration(userid, "D");
		model.addAttribute("accountDeclaration", accountDeclaration);
	}

	@RequestMapping(value = "/declarationAndBlockList", method = RequestMethod.POST)
	public void declarationAndBlockListPagePOST(Model model, @RequestParam("sellChk") String sellChk,
			HttpServletRequest req) throws Exception {

		HttpSession session = req.getSession(false);
		User user = (User) session.getAttribute("memberUser");
		String userid = user.getUserid();

		if (sellChk.equals("D")) {
			List<AccountDeclaration> accountDeclaration = mypagemainService.selectAccountDeclaration(userid, sellChk);
			model.addAttribute("accountDeclaration", accountDeclaration);
		} else {
			List<BlockUser> blockUser = mypagemainService.selectBlockUser(userid, sellChk);
			model.addAttribute("blockUser", blockUser);
		}

	}

	// 관심 상품
	@RequestMapping(value = "/likeProduct")
	public void likeProductPage(Model model, HttpServletRequest req) throws Exception {

		HttpSession session = req.getSession(false);
		User user = (User) session.getAttribute("memberUser");
		String userid = user.getUserid();

		List<Product> likeProduct = mypagemainService.selectLikeProduct(userid);
		model.addAttribute("likeProduct", likeProduct);
	}

	// 판매 내역
	@RequestMapping(value = "/sellcheck", method = RequestMethod.GET)
	public void sellcheckPageGET(Model model, HttpServletRequest req) throws Exception {

		HttpSession session = req.getSession(false);
		User user = (User) session.getAttribute("memberUser");
		String userid = user.getUserid();

		List<Product> sellList = mypagemainService.selectSellList(userid, "A");
		model.addAttribute("sellList", sellList);
	}

	@RequestMapping(value = "/sellcheck", method = RequestMethod.POST)
	public void sellcheckPagePOST(Model model, @RequestParam("sellChk") String sellchk, HttpServletRequest req)
			throws Exception {

		HttpSession session = req.getSession(false);
		User user = (User) session.getAttribute("memberUser");
		String userid = user.getUserid();

		if (sellchk == null)
			sellchk = "A";
		if (sellchk.equals("Y") || sellchk.equals("N")) {
			List<Product> sellList = mypagemainService.selectSellList(userid, sellchk);
			model.addAttribute("sellList", sellList);
		} else {
			List<Product> sellList = mypagemainService.selectSellList(userid, sellchk);
			model.addAttribute("sellList", sellList);
		}

	}

	// 회원 탈퇴
	@RequestMapping(value = "/deleteForm")
	public void deleteFormPage(Model model, HttpServletRequest req) throws Exception {

		HttpSession session = req.getSession(false);
		User user = (User) session.getAttribute("memberUser");
		String userid = user.getUserid();

		List<Secession> deleteForm = mypagemainService.selectDeleteForm();
		model.addAttribute("deleteForm", deleteForm);
	}

	// 고객 센터
	@RequestMapping(value = "/adminmain")
	public String adminmainPage(Model model) throws Exception {
		return "admin/adminmain";
	}

}
