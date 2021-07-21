package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.domain.Criteria;
import org.zerock.domain.Notice;
import org.zerock.domain.Qna;
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
}
