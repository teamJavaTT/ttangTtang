package admin.qna.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import admin.qna.dao.AdminDao;
import admin.qna.model.Qna;
import admin.qna.model.Qnacolumn;
import jdbc.DBConnection;
import jdbc.JdbcUtil;

public class QnaService {
	
	private AdminDao adminDao = new AdminDao();
	
	// 글 입력하기
	public Integer qnawrite(Qna writeReq) throws Exception {
		Connection conn = null;
		try {
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false);

			Qnacolumn article = toArticle(writeReq);
			Qnacolumn savedArticle = adminDao.insert(conn, article);
			if (savedArticle == null) {
				throw new RuntimeException("fail to insert article");
			}
			conn.commit();

			return savedArticle.getqno();
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} catch (RuntimeException e) {
			JdbcUtil.rollback(conn);
			throw e; 
		} finally {
			JdbcUtil.close(conn);
		}
	}
	private Qnacolumn toArticle(Qna req) {
		Date now = new Date();
				
		return new Qnacolumn(null, null, req.getqtit(), req.getqtext(), now); //null에 아이디 추가
	}
	// 글 입력하기 끝
	
	// 글 목록에 읽어오기
	public QnaPage getQnaPage(int pageNo) throws Exception {
		int size = 5;
		int startNo = (pageNo - 1) * size + 1;
		int endNo = startNo + 4;
		try (Connection conn = DBConnection.getConnection()) {
			int total = adminDao.selectCount(conn);
			List<Qnacolumn> noticecolumn = adminDao.selectQna(conn, startNo, endNo);
			return new QnaPage(total, pageNo, size, noticecolumn);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public QnaData getNoticeRead(int qnaNum) throws Exception {
		try (Connection conn = DBConnection.getConnection()){
			Qnacolumn qnacolumn = adminDao.selectById(conn, qnaNum);
			if (qnacolumn == null) {
				throw new ArticleNotFoundException();
			}
			return new QnaData(qnacolumn);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	// 글 목록에 읽어오기 끝

	// 글 삭제
	public void getQnaDelete(int delNo) throws SQLException, Exception {
		try(Connection conn = DBConnection.getConnection()){
			adminDao.deleteQna(conn, delNo);
		}
	}
	// 글 끝
	
	// 수정
	public QnaData getQnaMod(int qnaNum) throws Exception {
		try (Connection conn = DBConnection.getConnection()){
			Qnacolumn qnacolumn = adminDao.selectById(conn, qnaNum);
			if (qnacolumn == null) {
				throw new ArticleNotFoundException();
			}
			return new QnaData(qnacolumn);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Integer qnamod(int delNo, Qna modReq) throws Exception {
		Connection conn = null;
		try {
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false);

			Qnacolumn qnacolumn = toQnaMod(delNo, modReq);
			Qnacolumn savedArticle = adminDao.updateQna(conn, qnacolumn);
			if (savedArticle == null) {
				throw new RuntimeException("fail to update");
			}
			conn.commit();

			return savedArticle.getqno();
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} catch (RuntimeException e) {
			JdbcUtil.rollback(conn);
			throw e; 
		} finally {
			JdbcUtil.close(conn);
		}
	}
	// 수정 끝
	private Qnacolumn toQnaMod(int delNo, Qna req) {
		Date now = new Date();
		return new Qnacolumn(delNo, null, req.getqtit(), req.getqtext(), now);
	}
}