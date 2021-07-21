package org.zerock.service;

import java.util.List;

import org.zerock.domain.Criteria;
import org.zerock.domain.Notice;
import org.zerock.domain.Qna;
import org.zerock.dto.NoticeColumn;
import org.zerock.dto.QnaColumn;

public interface AdminService {
	List<Notice> selectNoticeList(Criteria cri) throws Exception;
	int selectNoticeListCount() throws Exception;
	List<NoticeColumn> insertNoticeWrite(NoticeColumn noticeColumn) throws Exception;
	List<Notice> selectNoticeRead(int no) throws Exception;
	List<NoticeColumn> updateNoticeModify(NoticeColumn noticeColumn) throws Exception;
	List<Notice> deleteNotice(int no) throws Exception;
	// ---------------------------------------------------------------------
	List<Qna> selectQnaList(Criteria cri) throws Exception;
	int selectQnaListCount() throws Exception;
	List<QnaColumn> insertQnaWrite(QnaColumn qnaColumn) throws Exception;
	List<Qna> selectQnaRead(int no) throws Exception;
	List<QnaColumn> updateQnaModify(QnaColumn qnaColumn) throws Exception;
	List<Qna> deleteQna(int no) throws Exception;
	List<QnaColumn> updateQnaAnswer(QnaColumn qnaColumn) throws Exception;
	List<QnaColumn> updateQnaReAnswer(QnaColumn qnaColumn) throws Exception;
	// ---------------------------------------------------------------------
}