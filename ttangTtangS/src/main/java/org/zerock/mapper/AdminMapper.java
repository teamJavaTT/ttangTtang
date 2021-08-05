package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
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

public interface AdminMapper {
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
	String checkQnaPw(int no) throws Exception;
	List<Qna> selectQnaRead(int no) throws Exception;
	List<QnaColumn> updateQnaModify(QnaColumn qnaColumn) throws Exception;
	List<Qna> deleteQna(int no) throws Exception;
	List<QnaColumn> updateQnaAnswer(QnaColumn qnaColumn) throws Exception;
	List<QnaColumn> updateQnaReAnswer(QnaColumn qnaColumn) throws Exception;
	// ---------------------------------------------------------------------
	List<Faq> selectFaqList(Criteria cri) throws Exception;
	int selectFaqListCount() throws Exception;
	List<FaqColumn> insertFaqWrite(FaqColumn faqColumn) throws Exception;
	List<Faq> selectFaqRead(int no) throws Exception;
	List<FaqColumn> updateFaqModify(FaqColumn faqColumn) throws Exception;
	List<Faq> deleteFaq(int no) throws Exception;
	// ---------------------------------------------------------------------
	List<UserInfo> selectUserInfoMemberList(@Param("pageStart")int pageStart, @Param("pageEnd")int pageEnd, @Param("memChk")int memChk) throws Exception;
	List<UserInfo> selectUserInfoAllList(Criteria cri) throws Exception;
	int selectUserInfoListCount() throws Exception;
	List<UserInfo> selectUserInfoRead(String id) throws Exception;
	// ---------------------------------------------------------------------
	List<BlackList> selectBlackList(Criteria cri) throws Exception;
	int selectBlackListCount() throws Exception;
	List<BlackList> selectBlackListRead(int no) throws Exception;
	// ---------------------------------------------------------------------
	List<Declaration> selectDeclarationList(Criteria cri) throws Exception;
	int selectDeclarationListCount() throws Exception;
	List<Declaration> selectDeclarationRead(int no) throws Exception;
	// ---------------------------------------------------------------------
	List<OutUser> selectOutUserList(Criteria cri) throws Exception;
	int selectOutUserListCount() throws Exception;
	List<OutUser> selectOutUserRead(int no) throws Exception;
}
