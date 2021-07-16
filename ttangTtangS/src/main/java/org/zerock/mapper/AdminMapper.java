package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.Notice;
import org.zerock.domain.Qna;
import org.zerock.domain.QnaPage;
import org.zerock.dto.QnaColumn;

public interface AdminMapper {
	List<Notice> selectNoticeList() throws Exception;
	// ---------------------------------------------------------------------
	List<QnaPage> selectQnaList(int startNo, int endNo) throws Exception;

	/* List<QnaPage> pageMaker() throws Exception; */
	List<QnaColumn> insertQnaWrite(QnaColumn qnaColumn) throws Exception;
	List<Qna> selectQnaRead(int no) throws Exception;
	List<QnaColumn> updateQnaModify(QnaColumn qnaColumn) throws Exception;
	List<Qna> deleteQna(int no) throws Exception;
	List<QnaColumn> updateQnaAnswer(QnaColumn qnaColumn) throws Exception;
	List<QnaColumn> updateQnaReAnswer(QnaColumn qnaColumn) throws Exception;
	// ---------------------------------------------------------------------
}
