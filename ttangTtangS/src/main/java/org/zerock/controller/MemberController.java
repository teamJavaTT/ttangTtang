package org.zerock.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.domain.Alim;
import org.zerock.domain.User;
import org.zerock.dto.Member;
import org.zerock.service.LoginFailException;
import org.zerock.service.MemberService;
import org.zerock.service.PasswordFailException;

import AES256.AES256Util;

@Controller
@RequestMapping(value = "/member")
public class MemberController {

	@Inject
	private MemberService memberService;

	// 로그인
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void loginGet(Model model, HttpServletRequest req) throws Exception {
		HttpSession session = req.getSession(false);

		if (session.getAttribute("memberUser") == null) {
			String referrer = req.getHeader("Referer");
			if(referrer == "http://localhost:8081/member/join" || referrer.equals("http://localhost:8081/member/join")) {
				referrer = "http://localhost:8081/";
			}
			req.getSession().setAttribute("prevPage", referrer);
			req.setAttribute("login", false);
		} else {
			req.setAttribute("login", true);
		}
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPost(Model model, HttpServletRequest req, HttpServletResponse res,
			@RequestParam("userid") String userid, @RequestParam("upw") String upw) throws Exception {
		AES256Util aes256Util = new AES256Util();
		Map<String, Boolean> errors = new HashMap<>();
		model.addAttribute("errors", errors);
		HttpSession session = req.getSession(false);
		try {
			String upwd = aes256Util.encrypt(upw);
			User user = memberService.memberLogin(userid, upwd);
			req.getSession().setAttribute("memberUser", user);
			
			int likeCount = memberService.likeProductCount(user.getUserid());
			ArrayList<Alim> alimList = memberService.alimSelect(user.getUserid());
			req.getSession().setAttribute("likeCount", likeCount);
			req.getSession().setAttribute("alim", alimList);
		} catch (LoginFailException e) {
			errors.put("idNotMatch", Boolean.TRUE);
			req.setAttribute("login", false);
			return "/member/login";
		} catch (PasswordFailException e) {
			errors.put("pwdNotMatch", Boolean.TRUE);
			req.setAttribute("login", false);
			return "/member/login";
		}
		String redirectUrl = (String) session.getAttribute("prevPage");
		session.removeAttribute("prevPage");
		res.sendRedirect(redirectUrl);
		return null;
	}

	// 로그아웃
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public void logout(Model model, HttpServletRequest req, HttpServletResponse res) throws Exception {
		HttpSession session = req.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		String referrer = req.getHeader("Referer");
		res.sendRedirect(referrer);
	}

	// 회원가입
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public void joinGet(Model model) {

	}

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String joinPost(Member member, Model model) throws Exception {
		AES256Util aes256Util = new AES256Util();
		member.setUpw(aes256Util.encrypt(member.getUpw()));
		memberService.insertMemberJoin(member);
		model.addAttribute("ment", "TTang TTang Market 회원가입 성공!");
		model.addAttribute("href", "/member/login");
		return "/successPage";
	}

	// 아이디 찾기
	@RequestMapping(value = "/idfind", method = RequestMethod.GET)
	public void idFindPage(Model model) {

	}

	@RequestMapping(value = "/idfind", method = RequestMethod.POST)
	public String idFindPage(@RequestParam("uname") String uname, @RequestParam("uemail") String uemail, Model model)
			throws Exception {
		String selectIdFind = memberService.selectIdFind(uname, uemail);
		model.addAttribute("selectIdFind", selectIdFind);

		return "/member/idfind";
	}

	// 비밀번호찾기
	@RequestMapping(value = "/passwordfind", method = RequestMethod.GET)
	public void passwordFindPage(Model model) throws Exception {

	}

	@RequestMapping(value = "/passwordfind", method = RequestMethod.POST)
	public String passwordFindPage(@RequestParam(value = "userid", required = false) String userid,
			@RequestParam(value = "uname", required = false) String uname,
			@RequestParam(value = "uemail", required = false) String uemail,
			@RequestParam(value = "upw", required = false) String upw,
			@RequestParam(value = "upw2", required = false) String upw2, @RequestParam("findChange") String findChange,
			Model model, HttpServletRequest req) throws Exception {
		AES256Util aes256Util = new AES256Util();
		req.setCharacterEncoding("utf-8");

		if (findChange == "find" || findChange.equals("find")) {
			String selectPasswordFind = memberService.selectPasswordFind(userid, uname, uemail);
			if (selectPasswordFind != null) {
				model.addAttribute("userExist", "Y");
			} else {
				model.addAttribute("userExist", "N");
			}
			return "/member/passwordfind";
		} else {
			if (upw == upw2 || upw.equals(upw2)) {
				String encodeUpw = aes256Util.encrypt(upw);
				memberService.updatePassword(encodeUpw, userid);
				model.addAttribute("ment", "TTang TTang Market 비밀번호 변경 성공!");
				model.addAttribute("href", "/member/login");
				return "/successPage";
			} else {
				model.addAttribute("userExist", "Y");
				model.addAttribute("upwSame", "N");
				return "/member/passwordfind";
			}
		}
	}

	// 회원 정보 수정
	@RequestMapping(value = "/memberEdit", method = RequestMethod.GET)
	public String updateMemberPage(Model model, HttpServletRequest req) throws Exception {
		HttpSession session = req.getSession(false);
		User user = (User) session.getAttribute("memberUser");

		User member = memberService.selectById(user.getUserid());
		model.addAttribute("member", member);
		return "/member/memberEdit";

	}

	@RequestMapping(value = "/memberEdit", method = RequestMethod.POST)
	public String memberEditPage(Member member, Model model, HttpServletRequest req) throws Exception {
		AES256Util aes256Util = new AES256Util();

		HttpSession session = req.getSession(false);
		User user = (User) session.getAttribute("memberUser");
		member.setUserid(user.getUserid());

		if (member.getUpw() == null || member.getUpw() == "") {
			member.setUpw("");
		} else {
			member.setUpw(aes256Util.encrypt(member.getUpw()));
		}
		memberService.updateMember(member);

		model.addAttribute("ment", "TTang TTang Market 회원수정 성공!");
		model.addAttribute("href", "/mypage/mypageMain");
		return "/successPage";
	}

	// 아이디 중복 확인
	@RequestMapping(value = "/idCheck")
	public String idCheckPage(@RequestParam(value = "userid", required = false) String userid, Model model, HttpServletResponse res) throws Exception {
		java.io.PrintWriter pw = res.getWriter();
		if (userid == null || userid == "") {
			model.addAttribute("idCheck", null);
			pw.print("null");
			return null;
		}

		int idCheck = memberService.idCheck(userid);
		model.addAttribute("idCheck", idCheck);
        pw.print(idCheck);
		return null;
	}
}
