package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.domain.Notice;
import org.zerock.domain.Qna;
import org.zerock.domain.QnaPage;
import org.zerock.dto.QnaColumn;
import org.zerock.mapper.AdminMapper;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminMapper adminMapper;

	@Override
	@Transactional
	public List<Notice> selectNoticeList() throws Exception {
		return adminMapper.selectNoticeList();
	}

	@Override
	@Transactional
	public List<Qna> selectQnaList() throws Exception {
		return adminMapper.selectQnaList();
	}
	
	/*
	 * @Override
	 * 
	 * @Transactional public List<QnaPage> pageMaker() throws Exception { return
	 * adminMapper.pageMaker(); }
	 */

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
