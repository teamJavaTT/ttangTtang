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
	public Integer qnaWrite(Qna writeReq) throws Exception {
		Connection conn = null;
		try {
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false);

			Qnacolumn article = toColumn(writeReq);
			Qnacolumn savedArticle = adminDao.qnaInsert(conn, article);
			if (savedArticle == null) {
				throw new RuntimeException("fail to insert article");
			}
			conn.commit();

			return savedArticle.getQno();
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
	private Qnacolumn toColumn(Qna req) {
		Date now = new Date();
				
		return new Qnacolumn(null, req.getUserId(), req.getQtit(), req.getQtext(), now, "N", null, null); //null에 아이디 추가
	}
	// 글 입력하기 끝
	
	// 글 목록에 읽어오기
	public QnaPage getQnaPage(int pageNo) throws Exception {
		int size = 5;
		int startNo = (pageNo - 1) * size + 1;
		int endNo = startNo + 4;
		try (Connection conn = DBConnection.getConnection()) {
			int total = adminDao.selectCount(conn);
			List<Qnacolumn> qnacolumn = adminDao.qnaSelect(conn, startNo, endNo);
			return new QnaPage(total, pageNo, size, qnacolumn);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public QnaData getQnaRead(int qnaNum) throws Exception {
		try (Connection conn = DBConnection.getConnection()){
			Qnacolumn qnacolumn = adminDao.qnaReadSelect(conn, qnaNum);
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
			adminDao.qnaDelete(conn, delNo);
		}
	}
	// 글 끝
	
	// 수정
	public QnaData getQnaMod(int qnaNum) throws Exception {
		try (Connection conn = DBConnection.getConnection()){
			Qnacolumn qnacolumn = adminDao.qnaReadSelect(conn, qnaNum);
			if (qnacolumn == null) {
				throw new ArticleNotFoundException();
			}
			return new QnaData(qnacolumn);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Integer qnaMod(int delNo, Qna modReq) throws Exception {
		Connection conn = null;
		try {
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false);

			Qnacolumn qnacolumn = toQnaMod(delNo, modReq);
			Qnacolumn savedArticle = adminDao.qnaUpdate(conn, qnacolumn);
			if (savedArticle == null) {
				throw new RuntimeException("fail to update");
			}
			conn.commit();

			return savedArticle.getQno();
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
		return new Qnacolumn(delNo, null, req.getQtit(), req.getQtext(), now, "N", null, null);
	}
	
	//댓글
	public Integer qnaAnswerUpdate(int delNo, String answerContent) throws Exception {
		Connection conn = null;
		try {
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false);

			adminDao.qnaAnswerUpdate(conn, delNo, answerContent);
			conn.commit();

			return null;
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
}
