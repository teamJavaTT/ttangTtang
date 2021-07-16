package org.zerock.service;

import java.util.List;

import org.zerock.domain.Notice;
import org.zerock.domain.Qna;
import org.zerock.domain.QnaPage;
import org.zerock.dto.QnaColumn;

public interface AdminService {
	List<Notice> selectNoticeList() throws Exception;
	// ---------------------------------------------------------------------
	List<Qna> selectQnaList() throws Exception;

	/* List<QnaPage> pageMaker() throws Exception; */
	List<QnaColumn> insertQnaWrite(QnaColumn qnaColumn) throws Exception;
	List<Qna> selectQnaRead(int no) throws Exception;
	List<QnaColumn> updateQnaModify(QnaColumn qnaColumn) throws Exception;
	List<Qna> deleteQna(int no) throws Exception;
	List<QnaColumn> updateQnaAnswer(QnaColumn qnaColumn) throws Exception;
	List<QnaColumn> updateQnaReAnswer(QnaColumn qnaColumn) throws Exception;
	// ---------------------------------------------------------------------
}
