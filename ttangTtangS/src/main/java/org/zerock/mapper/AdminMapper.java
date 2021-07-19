package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.Criteria;
import org.zerock.domain.Notice;
import org.zerock.domain.Qna;
import org.zerock.dto.QnaColumn;

public interface AdminMapper {
	List<Notice> selectNoticeList() throws Exception;
	// ---------------------------------------------------------------------
	List<Qna> selectQnaList(Criteria cri) throws Exception;
	int selectQnaListCount() throws Exception;
	/* List<QnaPage> pageMaker() throws Exception; */
	List<QnaColumn> insertQnaWrite(QnaColumn qnaColumn) throws Exception;
	List<Qna> selectQnaRead(int no) throws Exception;
	List<QnaColumn> updateQnaModify(QnaColumn qnaColumn) throws Exception;
	List<Qna> deleteQna(int no) throws Exception;
	List<QnaColumn> updateQnaAnswer(QnaColumn qnaColumn) throws Exception;
	List<QnaColumn> updateQnaReAnswer(QnaColumn qnaColumn) throws Exception;
	// ---------------------------------------------------------------------
}
