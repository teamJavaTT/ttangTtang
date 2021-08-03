package org.zerock.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.domain.AccountDeclaration;
import org.zerock.domain.Alim;
import org.zerock.domain.BlockUser;
import org.zerock.domain.Category;
import org.zerock.domain.Criteria;
import org.zerock.domain.PageMaker;
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

	List<Category> category = InitController.category;
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

	}

	@RequestMapping(value = "/accountDeclaration", method = RequestMethod.POST)
	public String accountDeclarationPagePOST(AccountDeclarationDTO accountDec, Model model,
			@RequestParam("no") String no, @RequestParam(value = "badid", required = false) String badid,
			@RequestParam(value = "declId", required = false) String declId, HttpServletRequest req) throws Exception {

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
			} else {
				if (userid == member.getUserid() || userid.equals(member.getUserid())) {
					req.setAttribute("idChkOk", 2);
				} else {
					req.setAttribute("idChkOk", 1);
				}
				return "/mypage/accountDeclaration";
			}
		} else {
			req.setCharacterEncoding("utf-8");
			accountDec.setUserId(userid);

			mypagemainService.insertAccountDeclaration(accountDec);

			model.addAttribute("ment", "신고되었습니다.");
			model.addAttribute("href", "/mypage/mypageMain");
			return "/successPage";
		}

	}

	// 차단
	@RequestMapping(value = "/blockUser", method = RequestMethod.GET)
	public void blockUserPageGET(Model model, HttpServletRequest req) throws Exception {

	}

	@RequestMapping(value = "/blockUser", method = RequestMethod.POST)
	public String blockUserPagePOST(BlockUserDTO accountBl, Model model, @RequestParam("no") String no,
			@RequestParam(value = "blockid", required = false) String blockid,
			@RequestParam(value = "blockid2", required = false) String blockid2, HttpServletRequest req)
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
			} else {
				if (userid == member.getUserid() || userid.equals(member.getUserid())) {
					req.setAttribute("idBlockOk", 2);
				} else {
					req.setAttribute("idBlockOk", 1);
				}
				return "/mypage/blockUser";
			}
		} else {
			req.setCharacterEncoding("utf-8");
			accountBl.setUserId(userid);

			mypagemainService.insertBlockUser(accountBl);

			model.addAttribute("ment", "차단되었습니다.");
			model.addAttribute("href", "/mypage/mypageMain");
			return "/successPage";
		}

	}
	// 신고 및 차단 리스트

	@RequestMapping(value = "/declarationAndBlockList")
	public void declarationAndBlockListPagePOST(Criteria cri, Model model,
			@RequestParam(value = "blockChk", required = false) String blockChk, HttpServletRequest req)
			throws Exception {

		HttpSession session = req.getSession(false);
		User user = (User) session.getAttribute("memberUser");
		String userid = user.getUserid();
		String tblName ;
		int pageStart = cri.getPageStart();
		int pageEnd = cri.getPageEnd();

		if (blockChk == null || blockChk == "") {
			blockChk = "D";
		}
		if (blockChk.equals("D")) {
			tblName = "declaration";
			List<AccountDeclaration> accountDeclaration = mypagemainService.selectAccountDeclaration(userid, pageStart, pageEnd);
			model.addAttribute("accountDeclaration", accountDeclaration);
		} else {
			tblName = "block";
			List<BlockUser> blockUser = mypagemainService.selectBlockUser(userid, pageStart, pageEnd);
			model.addAttribute("blockUser", blockUser);
		}

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(mypagemainService.selectDclrBlckListCount(userid, tblName));
		model.addAttribute("pageMaker", pageMaker);

	}

	// 관심 상품
	@RequestMapping(value = "/likeProduct")
	public void likeProductPage(Criteria cri, Model model, HttpServletRequest req,
			@RequestParam(value = "pageNo", defaultValue = "0") String numVal) throws Exception {

		HttpSession session = req.getSession(false);
		User user = (User) session.getAttribute("memberUser");
		String userid = user.getUserid();

		int pageStart = cri.getPageStart();
		int pageEnd = cri.getPageEnd();

		List<Product> likeProduct = mypagemainService.selectLikeProduct(userid, pageStart, pageEnd);
		model.addAttribute("likeProduct", likeProduct);

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(mypagemainService.selectLikeProductListCount(userid));
		model.addAttribute("pageMaker", pageMaker);
	}

	// 판매내역
	@RequestMapping(value = "/sellcheck")
	public void sellcheckPagePOST(Criteria cri, Model model,
			@RequestParam(value = "sellChk", required = false) String sellchk, HttpServletRequest req,
			@RequestParam(value = "pageNo", defaultValue = "0") String numVal) throws Exception {

		HttpSession session = req.getSession(false);
		User user = (User) session.getAttribute("memberUser");
		String userid = user.getUserid();
		
		int pageStart = cri.getPageStart();
		int pageEnd = cri.getPageEnd();

		if (sellchk == null || sellchk == "")
			sellchk = "A";
		if (sellchk.equals("Y") || sellchk.equals("N")) {
			List<Product> sellList = mypagemainService.selectSellList(userid, sellchk, pageStart, pageEnd);
			model.addAttribute("sellList", sellList);
		} else {
			List<Product> sellList = mypagemainService.selectSellList(userid, sellchk, pageStart, pageEnd);
			model.addAttribute("sellList", sellList);
		}

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(mypagemainService.selectSellListCount(userid, sellchk));

		model.addAttribute("category", category);
		model.addAttribute("pageMaker", pageMaker);
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

	// 알림내역
	@RequestMapping(value = "/alimList")
	public void alimList(Model model, HttpServletRequest req) throws Exception {
		HttpSession session = req.getSession(false);
		User user = (User) session.getAttribute("memberUser");
		List<Alim> alimAll = mypagemainService.alimAllSelect(user.getUserid());
		model.addAttribute("alimAll", alimAll);
		mypagemainService.alimChkUpdate(user.getUserid());
		model.addAttribute("alim", null);

	}

}
