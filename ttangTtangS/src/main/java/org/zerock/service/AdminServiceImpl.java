package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.domain.BlackList;
import org.zerock.domain.Criteria;
import org.zerock.domain.Declaration;
import org.zerock.domain.Faq;
import org.zerock.domain.Notice;
import org.zerock.domain.OutUser;
import org.zerock.domain.Qna;
import org.zerock.domain.UserInfo;
import org.zerock.dto.FaqColumn;
import org.zerock.dto.NoticeColumn;
import org.zerock.dto.QnaColumn;
import org.zerock.mapper.AdminMapper;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminMapper adminMapper;

	@Override
	@Transactional
	// 목록 + 페이징
	public List<Notice> selectNoticeList(Criteria cri) throws Exception {
		return adminMapper.selectNoticeList(cri);
	}
	
	@Override
	@Transactional
	// 게시물 총 갯수
	public int selectNoticeListCount() throws Exception{
		return adminMapper.selectNoticeListCount();
	}
	
	@Override
	@Transactional
	public List<NoticeColumn> insertNoticeWrite(NoticeColumn noticeColumn) throws Exception {
		return adminMapper.insertNoticeWrite(noticeColumn);
	}

	@Override
	@Transactional
	public List<Notice> selectNoticeRead(int no) throws Exception {
		return adminMapper.selectNoticeRead(no);
	}
	
	@Override
	@Transactional
	public List<NoticeColumn> updateNoticeModify(NoticeColumn noticeColumn) throws Exception {
		return adminMapper.updateNoticeModify(noticeColumn);
	}
	
	@Override
	@Transactional
	public List<Notice> deleteNotice(int no) throws Exception {
		return adminMapper.deleteNotice(no);
	}

	// ---------------------------------------------------------------------
	@Override
	@Transactional
	// 목록 + 페이징
	public List<Qna> selectQnaList(Criteria cri) throws Exception {
		return adminMapper.selectQnaList(cri);
	}
	
	@Override
	@Transactional
	// 게시물 총 갯수
	public int selectQnaListCount() throws Exception{
		return adminMapper.selectQnaListCount();
	}
	
	@Override
	@Transactional
	public List<QnaColumn> insertQnaWrite(QnaColumn qnaColumn) throws Exception {
		return adminMapper.insertQnaWrite(qnaColumn);
	}

	@Override
	@Transactional
	public List<Qna> selectQnaRead(int no) throws Exception {
		return adminMapper.selectQnaRead(no);
	}
	
	@Override
	@Transactional
	public List<QnaColumn> updateQnaModify(QnaColumn qnaColumn) throws Exception {
		return adminMapper.updateQnaModify(qnaColumn);
	}

	@Override
	@Transactional
	public List<Qna> deleteQna(int no) throws Exception {
		return adminMapper.deleteQna(no);
	}
	
	@Override
	@Transactional
	public List<QnaColumn> updateQnaAnswer(QnaColumn qnaColumn) throws Exception{
		return adminMapper.updateQnaAnswer(qnaColumn);
	}
	@Override
	@Transactional
	public List<QnaColumn> updateQnaReAnswer(QnaColumn qnaColumn) throws Exception{
		return adminMapper.updateQnaReAnswer(qnaColumn);
	}
	
	// ---------------------------------------------------------------------
	@Override
	@Transactional
	// 목록 + 페이징
	public List<Faq> selectFaqList(Criteria cri) throws Exception {
		return adminMapper.selectFaqList(cri);
	}
	
	@Override
	@Transactional
	// 게시물 총 갯수
	public int selectFaqListCount() throws Exception{
		return adminMapper.selectFaqListCount();
	}
	
	@Override
	@Transactional
	public List<FaqColumn> insertFaqWrite(FaqColumn faqColumn) throws Exception {
		return adminMapper.insertFaqWrite(faqColumn);
	}

	@Override
	@Transactional
	public List<Faq> selectFaqRead(int no) throws Exception {
		return adminMapper.selectFaqRead(no);
	}
	
	@Override
	@Transactional
	public List<FaqColumn> updateFaqModify(FaqColumn faqColumn) throws Exception {
		return adminMapper.updateFaqModify(faqColumn);
	}
	
	@Override
	@Transactional
	public List<Faq> deleteFaq(int no) throws Exception {
		return adminMapper.deleteFaq(no);
	}
	
	// ---------------------------------------------------------------------
	
	@Override
	@Transactional
	public List<UserInfo> selectUserInfoMemberList(int pageStart, int pageEnd, int memChk) throws Exception{
		List<UserInfo> userinfo = adminMapper.selectUserInfoMemberList(pageStart, pageEnd, memChk);
		return userinfo;
	}
	
	@Override
	@Transactional
	public List<UserInfo> selectUserInfoAllList(Criteria cri) throws Exception{
		return adminMapper.selectUserInfoAllList(cri);
	}
	
	@Override
	@Transactional
	// 게시물 총 갯수
	public int selectUserInfoListCount() throws Exception{
		return adminMapper.selectUserInfoListCount();
	}
	
	@Override
	@Transactional
	public List<UserInfo> selectUserInfoRead(String id) throws Exception {
		return adminMapper.selectUserInfoRead(id);
	}
	
	// ---------------------------------------------------------------------
	
	@Override
	@Transactional
	// 목록 + 페이징
	public List<BlackList> selectBlackList(Criteria cri) throws Exception {
		return adminMapper.selectBlackList(cri);
	}
	
	@Override
	@Transactional
	// 게시물 총 갯수
	public int selectBlackListCount() throws Exception{
		return adminMapper.selectBlackListCount();
	}
	
	@Override
	@Transactional
	public List<BlackList> selectBlackListRead(int no) throws Exception {
		return adminMapper.selectBlackListRead(no);
	}
	
	// ---------------------------------------------------------------------
	
	@Override
	@Transactional
	// 목록 + 페이징
	public List<Declaration> selectDeclarationList(Criteria cri) throws Exception {
		return adminMapper.selectDeclarationList(cri);
	}
	
	@Override
	@Transactional
	// 게시물 총 갯수
	public int selectDeclarationListCount() throws Exception{
		return adminMapper.selectDeclarationListCount();
	}
	
	@Override
	@Transactional
	public List<Declaration> selectDeclarationRead(int no) throws Exception {
		return adminMapper.selectDeclarationRead(no);
	}
	
	// ---------------------------------------------------------------------
	
	@Override
	@Transactional
	// 목록 + 페이징
	public List<OutUser> selectOutUserList(Criteria cri) throws Exception {
		return adminMapper.selectOutUserList(cri);
	}
	
	@Override
	@Transactional
	// 게시물 총 갯수
	public int selectOutUserListCount() throws Exception{
		return adminMapper.selectOutUserListCount();
	}
	
	@Override
	@Transactional
	public List<OutUser> selectOutUserRead(int no) throws Exception {
		return adminMapper.selectOutUserRead(no);
	}
}
