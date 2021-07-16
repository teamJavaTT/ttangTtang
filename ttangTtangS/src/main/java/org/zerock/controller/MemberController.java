package org.zerock.controller;

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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.domain.User;
import org.zerock.dto.Member;
import org.zerock.service.LoginFailException;
import org.zerock.service.MemberService;
import org.zerock.service.PasswordFailException;

import AES256.AES256Util;


@Controller
@RequestMapping(value = "/member")
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	private static final String Member = null;

	@Inject
	private MemberService memberService;
	
	//로그인
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void loginGet(Model model, HttpServletRequest req) throws Exception {
		HttpSession session = req.getSession(false);

		if(session.getAttribute("memberUser") == null) {
			req.setAttribute("login", false);
		}else {
			req.setAttribute("login", true);
		}		
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPost(Model model, HttpServletRequest req, HttpServletResponse res, @RequestParam("userid") String userid, @RequestParam("upw") String upw) throws Exception {
		AES256Util aes256Util = new AES256Util();
		Map<String, Boolean> errors = new HashMap<>();
		model.addAttribute("errors", errors);
		
		try {
			String upwd = aes256Util.encrypt(upw);
			User user = memberService.selectById(userid, upwd);
			req.getSession().setAttribute("memberUser", user);
		} catch (LoginFailException e) {
			errors.put("idNotMatch", Boolean.TRUE);
			return "/member/login";
		} catch (PasswordFailException e) {
			errors.put("pwdNotMatch", Boolean.TRUE);
			return "/member/login";
		}
		res.sendRedirect("/");
		return null;
	}
	
	//로그아웃
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public void logout(Model model, HttpServletRequest req, HttpServletResponse res) throws Exception {
		HttpSession session = req.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		res.sendRedirect("/");
	}
	
	//회원가입
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public void joinGet(Model model) {
		
	}
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String joinPost(Member member,Model model) throws Exception {
		AES256Util aes256Util = new AES256Util();
		member.setUpw(aes256Util.encrypt(member.getUpw()));
		memberService.insertMemberJoin(member);
		return "/member/joinSuccess";
	}
	
	// 아이디 찾기
	@RequestMapping(value = "/idfind", method = RequestMethod.GET)
	public void idFindPage(Model model) {

	}
	@RequestMapping(value = "/idfind", method = RequestMethod.POST)
	public String idFindPage(@RequestParam("uname") String uname, @RequestParam("uemail") String uemail, Model model)
			throws Exception {
		String selectIdFind = memberService.selectIdFind(uname, uemail);		
		model.addAttribute("selectIdFind",selectIdFind);

			return "/member/idfind";
	}
	/*
	 * @RequestMapping(value = "/idfind", method = RequestMethod.POST) public String
	 * idFindPage(@PathVariable("uname") String uname, @PathVariable("uemail")
	 * String uemail, Model model) throws Exception { Member selectIdFind =
	 * memberService.selectIdFind(uname, uemail);
	 * model.addAttribute("selectIdFind",selectIdFind);
	 * 
	 * return "/member/idfind"; }
	 */

	
	//비밀번호찾기
	@RequestMapping(value = "/passwordfind")
	public void passwordFindPage(Model model) throws Exception {
		
	}
	
	
}
		
		
		
