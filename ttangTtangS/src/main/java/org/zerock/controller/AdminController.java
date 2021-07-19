package org.zerock.controller;

import java.util.List;

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
import org.zerock.domain.Criteria;
import org.zerock.domain.Notice;
import org.zerock.domain.PageMaker;
import org.zerock.domain.Qna;
import org.zerock.domain.QnaPage;
import org.zerock.dto.QnaColumn;
import org.zerock.service.AdminService;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

	@Inject
	private AdminService adminService;

	// admin 메인
	@RequestMapping(value = "/adminmain")
	public void mainPage(Model model) throws Exception {
	}

	// ---------------------------------------------------------------------
	// Notice 메인
	@RequestMapping(value = "/notice")
	public void noticePage(Model model) throws Exception {
		List<Notice> notice = adminService.selectNoticeList();
		model.addAttribute("Notice", notice);
	}

	// ---------------------------------------------------------------------
	// Qna 메인
	@RequestMapping(value = "/qna", method = RequestMethod.GET)
	public void qnaPage(Criteria cri, Model model, @RequestParam(value = "pageNo", defaultValue = "0") String numVal) throws Exception {
		/*
		 * if(numVal.equals("0")) { numVal = null; } String pageVal = numVal; int pageNo
		 * = 1; if(pageVal != null) { pageNo = Integer.parseInt(pageVal); } int size =
		 * 10; int startNo = (pageNo - 1) * size + 1; int endNo = startNo + 9;
		 */
		/* int total = adminService.selectCount(); */
		List<Qna> qna = adminService.selectQnaList(cri);
		model.addAttribute("qnaPage", qna);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(adminService.selectQnaListCount());
		model.addAttribute("pageMaker", pageMaker);
		 
	}

	// Qna 글쓰기

	@RequestMapping(value = "/qnawrite", method = RequestMethod.GET)
	public void qnaWriteViewPage(Model model) throws Exception {
	}
	
	@RequestMapping(value = "/qnawrite", method = RequestMethod.POST)
	public void qnaWritePage(QnaColumn qnaColumn, Model model, HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		List<QnaColumn> qna = adminService.insertQnaWrite(qnaColumn);
		model.addAttribute("qna", qna);

		res.sendRedirect("/admin/qnasuccess");
	}
	
	// Qna 글작성완료
		@RequestMapping(value = "/qnasuccess", method = RequestMethod.GET)
		public void qnaModifyPage(Model model) throws Exception {
		}

	// Qna 글읽기
	@RequestMapping(value = "/qnaread")
	public void qnaReadPage(Model model, @RequestParam(value = "no", defaultValue = "0") String numVal) throws Exception {
		int no = Integer.parseInt(numVal);
		List<Qna> qna = adminService.selectQnaRead(no);
		model.addAttribute("qna", qna);
	}
	
	// Qna 글수정
	@RequestMapping(value = "/qnamodify", method = RequestMethod.GET)
	public void qnaModifyViewPage(Model model, @RequestParam(value = "no", defaultValue = "0") String numVal) throws Exception {
		int no = Integer.parseInt(numVal);
		List<Qna> qna = adminService.selectQnaRead(no);
		model.addAttribute("qna", qna);
	}
	
	@RequestMapping(value = "/qnamodify", method = RequestMethod.POST)
	public void qnaModifyPage(QnaColumn qnaColumn, Model model, HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		List<QnaColumn> qna = adminService.updateQnaModify(qnaColumn);
		model.addAttribute("qna", qna);

		res.sendRedirect("/admin/qnasuccess");
	}
	
	// Qna 글 삭제
	@RequestMapping(value = "/qnadelete")
	public void qnaDeletePage(Model model, @RequestParam(value = "no", defaultValue = "0") String numVal, HttpServletRequest req, HttpServletResponse res) throws Exception {
		int no = Integer.parseInt(numVal);
		List<Qna> qna = adminService.deleteQna(no);
		model.addAttribute("qna", qna);
		
		res.sendRedirect("/admin/qnadeletesuccess");
	}
	
	// Qna 글삭제완료
	@RequestMapping(value = "/qnadeletesuccess", method = RequestMethod.GET)
	public void qnaDeleteSuccessPage(Model model) throws Exception {
	}
	
	// Qna 댓글달기
	@RequestMapping(value = "/qnaAnswer", method = RequestMethod.POST)
	public void qnaAnswerRePage(QnaColumn qnaColumn, Model model, HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(qnaColumn.getPatext() == "N" || qnaColumn.getPatext().equals("N")) {
			List<QnaColumn> qna = adminService.updateQnaAnswer(qnaColumn);
			model.addAttribute("qna", qna);
		}else {
			List<QnaColumn> qna = adminService.updateQnaReAnswer(qnaColumn);
			model.addAttribute("qna", qna);
		}

		res.sendRedirect("/admin/qnaread?no="+qnaColumn.getQno());
	}
	// ---------------------------------------------------------------------
}
