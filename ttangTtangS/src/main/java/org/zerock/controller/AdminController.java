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
import org.zerock.domain.BlackList;
import org.zerock.domain.Category;
import org.zerock.domain.Criteria;
import org.zerock.domain.Declaration;
import org.zerock.domain.Faq;
import org.zerock.domain.Notice;
import org.zerock.domain.OutUser;
import org.zerock.domain.PageMaker;
import org.zerock.domain.Qna;
import org.zerock.domain.UserInfo;
import org.zerock.dto.FaqColumn;
import org.zerock.dto.NoticeColumn;
import org.zerock.dto.QnaColumn;
import org.zerock.service.AdminService;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
	@Inject
	private AdminService adminService;

	// Admin 메인
	@RequestMapping(value = "/adminmain")
	public void mainPage(Model model) throws Exception {
		model.addAttribute("category", InitController.category);
	}

	// ---------------------------------------------------------------------
	// Notice 메인
	@RequestMapping(value = "/notice")
	public void noticePage(Criteria cri, Model model, @RequestParam(value = "pageNo", defaultValue = "0") String numVal)
			throws Exception {

		List<Notice> notice = adminService.selectNoticeList(cri);
		model.addAttribute("noticePage", notice);

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(adminService.selectNoticeListCount());
		model.addAttribute("category", InitController.category);
		model.addAttribute("pageMaker", pageMaker);

	}

	// Notice 글쓰기
	@RequestMapping(value = "/noticewrite", method = RequestMethod.GET)
	public void noticeWriteViewPage(Model model) throws Exception {
	}

	@RequestMapping(value = "/noticewrite", method = RequestMethod.POST)
	public String noticeWritePage(NoticeColumn noticeColumn, Model model, HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		noticeColumn.setMtext(noticeColumn.getMtext().replace("\r\n", "<br>"));
		List<NoticeColumn> notice = adminService.insertNoticeWrite(noticeColumn);
		model.addAttribute("notice", notice);

		model.addAttribute("ment", "성공적으로 삭제했습니다.");
		model.addAttribute("href", "/admin/notice");
		return "/successPage";
	}

	// Notice 글읽기
	@RequestMapping(value = "/noticeread")
	public void noticeReadPage(Model model, @RequestParam(value = "no", defaultValue = "0") String numVal)
			throws Exception {
		int no = Integer.parseInt(numVal);
		List<Notice> notice = adminService.selectNoticeRead(no);
		model.addAttribute("category", InitController.category);
		model.addAttribute("notice", notice);
	}

	// Notice 글수정
	@RequestMapping(value = "/noticemodify", method = RequestMethod.GET)
	public void noticeModifyViewPage(Model model, @RequestParam(value = "no", defaultValue = "0") String numVal)
			throws Exception {
		int no = Integer.parseInt(numVal);
		List<Notice> notice = adminService.selectNoticeRead(no);
		model.addAttribute("notice", notice);
	}

	@RequestMapping(value = "/noticemodify", method = RequestMethod.POST)
	public String noticeModifyPage(NoticeColumn noticeColumn, Model model, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		noticeColumn.setMtext(noticeColumn.getMtext().replace("\r\n", "<br>"));
		List<NoticeColumn> notice = adminService.updateNoticeModify(noticeColumn);
		model.addAttribute("notice", notice);
		model.addAttribute("ment", "성공적으로 게시글을 수정했습니다.");
		model.addAttribute("href", "/notice");
		return "/successPage";
	}

	// Notice 글 삭제
	@RequestMapping(value = "/noticedelete")
	public String noticeDeletePage(Model model, @RequestParam(value = "no", defaultValue = "0") String numVal,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		int no = Integer.parseInt(numVal);
		List<Notice> notice = adminService.deleteNotice(no);
		model.addAttribute("notice", notice);

		model.addAttribute("ment", "성공적으로 삭제했습니다.");
		model.addAttribute("href", "/admin/notice");
		return "/successPage";
	}

	// ---------------------------------------------------------------------
	// Qna 메인
	@RequestMapping(value = "/qna", method = RequestMethod.GET)
	public void qnaPage(Criteria cri, Model model, @RequestParam(value = "pageNo", defaultValue = "0") String numVal)
			throws Exception {

		List<Qna> qna = adminService.selectQnaList(cri);
		model.addAttribute("qnaPage", qna);

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(adminService.selectQnaListCount());
		model.addAttribute("category", InitController.category);
		model.addAttribute("pageMaker", pageMaker);

	}

	// Qna 글쓰기
	@RequestMapping(value = "/qnawrite", method = RequestMethod.GET)
	public void qnaWriteViewPage(Model model) throws Exception {
		model.addAttribute("category", InitController.category);
	}

	@RequestMapping(value = "/qnawrite", method = RequestMethod.POST)
	public String qnaWritePage(QnaColumn qnaColumn, Model model, HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		qnaColumn.setQtext(qnaColumn.getQtext().replace("\r\n", "<br>"));
		List<QnaColumn> qna = adminService.insertQnaWrite(qnaColumn);
		model.addAttribute("qna", qna);

		model.addAttribute("ment", "성공적으로 게시글을 작성했습니다.");
		model.addAttribute("href", "/admin/qna");
		return "/successPage";
	}

	// Qna 글읽기
	@RequestMapping(value = "/qnaread", method = RequestMethod.GET)
	public void qnaReadPage(Model model, @RequestParam(value = "no", defaultValue = "0") String numVal)
			throws Exception {
		int no = Integer.parseInt(numVal);
		List<Qna> qna = adminService.selectQnaRead(no);
		model.addAttribute("category", InitController.category);
		model.addAttribute("qna", qna);
	}
	
	@RequestMapping(value = "/qnaread", method = RequestMethod.POST)
	public String qnaPwReadPage(Model model, @RequestParam(value = "no", defaultValue = "0") String numVal, @RequestParam(value="qnaPwd") String pw)
			throws Exception {
		int no = Integer.parseInt(numVal);
		String qnaPw = adminService.checkQnaPw(no);
		if(pw.equals(qnaPw)) {
			List<Qna> qna = adminService.selectQnaRead(no);
			model.addAttribute("category", InitController.category);
			model.addAttribute("qna", qna);
			model.addAttribute("ment", "비밀번호가 일치합니다.");
		}else {
			model.addAttribute("ment", "비밀번호가 틀렸습니다.");
			model.addAttribute("href", "/admin/qna");
		}
		return "/successPage";
	}

	// Qna 글수정
	@RequestMapping(value = "/qnamodify", method = RequestMethod.GET)
	public void qnaModifyViewPage(Model model, @RequestParam(value = "no", defaultValue = "0") String numVal)
			throws Exception {
		int no = Integer.parseInt(numVal);
		List<Qna> qna = adminService.selectQnaRead(no);
		model.addAttribute("category", InitController.category);
		model.addAttribute("qna", qna);
	}

	@RequestMapping(value = "/qnamodify", method = RequestMethod.POST)
	public String qnaModifyPage(QnaColumn qnaColumn, Model model, HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		qnaColumn.setQtext(qnaColumn.getQtext().replace("\r\n", "<br>"));
		List<QnaColumn> qna = adminService.updateQnaModify(qnaColumn);
		model.addAttribute("qna", qna);

		model.addAttribute("ment", "성공적으로 게시글을 수정했습니다.");
		model.addAttribute("href", "/admin/qna");
		return "/successPage";
	}

	// Qna 글 삭제
	@RequestMapping(value = "/qnadelete")
	public String qnaDeletePage(Model model, @RequestParam(value = "no", defaultValue = "0") String numVal,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		int no = Integer.parseInt(numVal);
		List<Qna> qna = adminService.deleteQna(no);
		model.addAttribute("qna", qna);

		model.addAttribute("ment", "성공적으로 삭제했습니다.");
		model.addAttribute("href", "/admin/qna");
		return "/successPage";
	}


	// Qna 댓글달기
	@RequestMapping(value = "/qnaAnswer", method = RequestMethod.POST)
	public void qnaAnswerRePage(QnaColumn qnaColumn, Model model, HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		if (qnaColumn.getPatext() == "N" || qnaColumn.getPatext().equals("N")) {
			qnaColumn.setQstext(qnaColumn.getQstext().replace("\r\n", "<br>"));
			List<QnaColumn> qna = adminService.updateQnaAnswer(qnaColumn);
			model.addAttribute("qna", qna);
		} else {
			List<QnaColumn> qna = adminService.updateQnaReAnswer(qnaColumn);
			model.addAttribute("qna", qna);
		}

		res.sendRedirect("/admin/qnaread?no=" + qnaColumn.getQno());
	}

	// ---------------------------------------------------------------------
	// Faq 메인
	@RequestMapping(value = "/faq")
	public void faqPage(Criteria cri, Model model, @RequestParam(value = "pageNo", defaultValue = "0") String numVal)
			throws Exception {

		List<Faq> faq = adminService.selectFaqList(cri);
		model.addAttribute("faqPage", faq);

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(adminService.selectFaqListCount());
		model.addAttribute("category", InitController.category);
		model.addAttribute("pageMaker", pageMaker);

	}

	// Faq 글쓰기
	@RequestMapping(value = "/faqwrite", method = RequestMethod.GET)
	public void faqWriteViewPage(Model model) throws Exception {
	}

	@RequestMapping(value = "/faqwrite", method = RequestMethod.POST)
	public String faqWritePage(FaqColumn faqColumn, Model model, HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		faqColumn.setFtext(faqColumn.getFtext().replace("\r\n", "<br>"));
		List<FaqColumn> faq = adminService.insertFaqWrite(faqColumn);
		model.addAttribute("faq", faq);

		model.addAttribute("ment", "성공적으로 게시글을 작성했습니다.");
		model.addAttribute("href", "/admin/faq");
		return "/successPage";
	}

	// Faq 글읽기
	@RequestMapping(value = "/faqread")
	public void faqReadPage(Model model, @RequestParam(value = "no", defaultValue = "0") String numVal)
			throws Exception {
		int no = Integer.parseInt(numVal);
		List<Faq> faq = adminService.selectFaqRead(no);
		model.addAttribute("category", InitController.category);
		model.addAttribute("faq", faq);
	}

	// Faq 글수정
	@RequestMapping(value = "/faqmodify", method = RequestMethod.GET)
	public void faqModifyViewPage(Model model, @RequestParam(value = "no", defaultValue = "0") String numVal)
			throws Exception {
		int no = Integer.parseInt(numVal);
		List<Faq> faq = adminService.selectFaqRead(no);
		model.addAttribute("faq", faq);
	}

	@RequestMapping(value = "/faqmodify", method = RequestMethod.POST)
	public String faqModifyPage(FaqColumn faqColumn, Model model, HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		faqColumn.setFtext(faqColumn.getFtext().replace("\r\n", "<br>"));
		List<FaqColumn> faq = adminService.updateFaqModify(faqColumn);
		model.addAttribute("faq", faq);
		model.addAttribute("ment", "성공적으로 게시글을 수정했습니다.");
		model.addAttribute("href", "/admin/faq");
		return "/successPage";
	}

	// Faq 글 삭제
	@RequestMapping(value = "/faqdelete")
	public String faqDeletePage(Model model, @RequestParam(value = "no", defaultValue = "0") String numVal,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		int no = Integer.parseInt(numVal);
		List<Faq> faq = adminService.deleteFaq(no);
		model.addAttribute("faq", faq);

		model.addAttribute("ment", "성공적으로 삭제했습니다.");
		model.addAttribute("href", "/admin/faq");
		return "/successPage";
	}

	// ---------------------------------------------------------------------
	// UserInfo 메인
	@RequestMapping(value = "/userinfo", method = RequestMethod.GET)
	public void userInfoViewPage(Criteria cri, Model model,
			@RequestParam(value = "pageNo", defaultValue = "0") String numVal) throws Exception {

		List<UserInfo> userInfo = adminService.selectUserInfoAllList(cri);
		model.addAttribute("userInfoPage", userInfo);

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(adminService.selectUserInfoListCount());
		model.addAttribute("pageMaker", pageMaker);

	}

	@RequestMapping(value = "/userinfo", method = RequestMethod.POST)
	public void userInfoPage(Criteria cri, Model model,
			@RequestParam(value = "pageNo", defaultValue = "0") String numVal, @RequestParam("check") String check)
			throws Exception {
		int memChk = Integer.parseInt(check);
		if (memChk == 1 || memChk == 2) {
			int pageStart = cri.getPageStart();
			int pageEnd = cri.getPageEnd();
			List<UserInfo> userInfo = adminService.selectUserInfoMemberList(pageStart, pageEnd, memChk);
			model.addAttribute("userInfoPage", userInfo);
		} else {
			List<UserInfo> userInfo = adminService.selectUserInfoAllList(cri);
			model.addAttribute("userInfoPage", userInfo);
		}

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(adminService.selectUserInfoListCount());
		model.addAttribute("pageMaker", pageMaker);
	}

	// UserInfo 글읽기
	@RequestMapping(value = "/userinforead")
	public void userInfoReadPage(Model model, @RequestParam(value = "id", defaultValue = "0") String id)
			throws Exception {
		List<UserInfo> userInfo = adminService.selectUserInfoRead(id);
		model.addAttribute("userInfo", userInfo);
	}

	// ---------------------------------------------------------------------
	// Blacklist 메인
	@RequestMapping(value = "/blacklist")
	public void blacklistPage(Criteria cri, Model model,
			@RequestParam(value = "pageNo", defaultValue = "0") String numVal) throws Exception {

		List<BlackList> blacklist = adminService.selectBlackList(cri);
		model.addAttribute("blacklistPage", blacklist);

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(adminService.selectBlackListCount());
		model.addAttribute("pageMaker", pageMaker);
	}

	// Blacklist 글읽기
	@RequestMapping(value = "/blacklistread")
	public void blacklistReadPage(Model model, @RequestParam(value = "no", defaultValue = "0") String numVal)
			throws Exception {
		int no = Integer.parseInt(numVal);
		List<BlackList> blacklist = adminService.selectBlackListRead(no);
		model.addAttribute("blacklist", blacklist);
	}

	// ---------------------------------------------------------------------
	// Declaration 메인
	@RequestMapping(value = "/declaration")
	public void declarationPage(Criteria cri, Model model,
			@RequestParam(value = "pageNo", defaultValue = "0") String numVal) throws Exception {

		List<Declaration> declaration = adminService.selectDeclarationList(cri);
		model.addAttribute("declarationPage", declaration);

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(adminService.selectDeclarationListCount());
		model.addAttribute("pageMaker", pageMaker);
	}

	// Declaration 글읽기
	@RequestMapping(value = "/declarationread")
	public void declarationReadPage(Model model, @RequestParam(value = "no", defaultValue = "0") String numVal)
			throws Exception {
		int no = Integer.parseInt(numVal);
		List<Declaration> declaration = adminService.selectDeclarationRead(no);
		model.addAttribute("declaration", declaration);
	}

	// ---------------------------------------------------------------------
	// OutUser 메인
	@RequestMapping(value = "/outuser")
	public void outuserPage(Criteria cri, Model model,
			@RequestParam(value = "pageNo", defaultValue = "0") String numVal) throws Exception {

		List<OutUser> outuser = adminService.selectOutUserList(cri);
		model.addAttribute("outuserPage", outuser);

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(adminService.selectOutUserListCount());
		model.addAttribute("pageMaker", pageMaker);
	}

	// Declaration 글읽기
	@RequestMapping(value = "/outuserread")
	public void outuserReadPage(Model model, @RequestParam(value = "no", defaultValue = "0") String numVal)
			throws Exception {
		int no = Integer.parseInt(numVal);
		List<OutUser> outuser = adminService.selectOutUserRead(no);
		model.addAttribute("outuser", outuser);
	}
}
