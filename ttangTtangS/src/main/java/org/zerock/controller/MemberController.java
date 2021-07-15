package org.zerock.controller;

import java.util.HashMap;
import java.util.Map;

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
	
	//�α���
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void loginGet(Model model, HttpServletRequest req) throws Exception {
		HttpSession session = req.getSession(false);
		User user = (User) session.getAttribute("memberUser");
		
		if(user == null) {
			req.setAttribute("login", false);
		}else {
			req.setAttribute("login", true);
		}		
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPost(Model model, HttpServletRequest req, @RequestParam("userid") String userid, @RequestParam("upw") String upw) throws Exception {
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
		return "/index";
	}
	
	//ȸ������
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
	
	//���̵� ã��
	@RequestMapping(value = "/idfind")
	public void idFindPage(Model model) throws Exception {
		
	}
	
	//��й�ȣ ã��
	@RequestMapping(value = "/passwordfind")
	public void passwordFindPage(Model model) throws Exception {
		
	}
	
	
}
		
		
		
