package org.zerock.controller;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.domain.Member;
import org.zerock.domain.User;
import org.zerock.service.LoginFailException;
import org.zerock.service.MemberService;
import org.zerock.service.PasswordFailException;


@Controller
@RequestMapping(value = "/member")
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	private static final String Member = null;

	@Inject
	private MemberService memberService;
	
	//로그인
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void loginGet(Model model) throws Exception {
		
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPost(Model model, @RequestParam("userid") String userid, @RequestParam("upw") String upw) throws Exception {
		Map<String, Boolean> errors = new HashMap<>();
		model.addAttribute("errors", errors);
		
		try {
			User user = memberService.selectById(userid, upw);
		} catch (LoginFailException e) {
			errors.put("idNotMatch", Boolean.TRUE);
			return "/member/login";
		} catch (PasswordFailException e) {
			errors.put("pwdNotMatch", Boolean.TRUE);
			return "/member/login";
		}
		return "/index";
	}
	
	//회원가입
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public void joinGet(Model model) {
		
	}
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String joinPost(Member member,Model model) throws Exception {
		memberService.insertMemberJoin(member);
		return "/member/joinSuccess";
	}
	
	//아이디 찾기
	@RequestMapping(value = "/idfind")
	public void idFindPage(Model model) throws Exception {
		
	}
	
	//비밀번호 찾기
	@RequestMapping(value = "/passwordfind")
	public void passwordFindPage(Model model) throws Exception {
		
	}
	
	
}
		
		
		
