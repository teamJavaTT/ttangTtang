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
	
	//�α���
	@RequestMapping(value = "/login")
	public void mainPage(Model model) throws Exception {
		
	}
	//ȸ������
	@RequestMapping(value = "/join")
	public void joinPage(Model model) throws Exception {
		
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
		
		
		
