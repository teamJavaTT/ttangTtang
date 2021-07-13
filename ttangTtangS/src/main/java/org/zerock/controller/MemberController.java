package org.zerock.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.service.MemberService;


@Controller
@RequestMapping(value = "/member")
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Inject
	private MemberService memberService;
	
	//로그인
	@RequestMapping(value = "/login")
	public void mainPage(Model model) throws Exception {
		
	}
	//회원가입
	@RequestMapping(value = "/join")
	public void joinPage(Model model) throws Exception {
		
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
		
		
		
