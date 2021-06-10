package admin.faq.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import admin.faq.dao.AdminDao;
import admin.faq.model.Faq;
import admin.faq.model.Faqcolumn;
import jdbc.DBConnection;
import jdbc.JdbcUtil;

public class FaqService {
	
	private AdminDao adminDao = new AdminDao();
	
	// 글 입력하기
	public Integer faqwrite(Faq writeReq) throws Exception {
		Connection conn = null;
		try {
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false);

			Faqcolumn article = toArticle(writeReq);
			Faqcolumn savedArticle = adminDao.insert(conn, article);
			if (savedArticle == null) {
				throw new RuntimeException("fail to insert article");
			}
			conn.commit();

			return savedArticle.getfno();
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
	private Faqcolumn toArticle(Faq req) {
		Date now = new Date();
				
		return new Faqcolumn(null, req.getftit(), req.getftext(), now);
	}
	// 글 입력하기 끝
	
	// 글 목록에 읽어오기
	public FaqPage getFaqPage(int pageNo) throws Exception {
		int size = 10;
		int startNo = (pageNo - 1) * size + 1;
		int endNo = startNo + 9;
		try (Connection conn = DBConnection.getConnection()) {
			int total = adminDao.selectCount(conn);
			List<Faqcolumn> faqcolumn = adminDao.selectFaq(conn, startNo, endNo);
			return new FaqPage(total, pageNo, size, faqcolumn);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public FaqData getFaqRead(int faqNum) throws Exception {
		try (Connection conn = DBConnection.getConnection()){
			Faqcolumn faqcolumn = adminDao.selectById(conn, faqNum);
			if (faqcolumn == null) {
				throw new ArticleNotFoundException();
			}
			return new FaqData(faqcolumn);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	// 글 목록에 읽어오기 끝

	// 글 삭제
	public void getFaqDelete(int delNo) throws SQLException, Exception {
		try(Connection conn = DBConnection.getConnection()){
			adminDao.deleteFaq(conn, delNo);
		}
	}
	// 글 끝
	
	
	public FaqData getFaqMod(int faqNum) throws Exception {
		try (Connection conn = DBConnection.getConnection()){
			Faqcolumn faqcolumn = adminDao.selectById(conn, faqNum);
			if (faqcolumn == null) {
				throw new ArticleNotFoundException();
			}
			return new FaqData(faqcolumn);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	// 수정
	public Integer faqmod(int delNo, Faq modReq) throws Exception {
		Connection conn = null;
		try {
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false);

			Faqcolumn faq = toFaqMod(delNo, modReq);
			Faqcolumn savedArticle = adminDao.updateFaq(conn, faq);
			if (savedArticle == null) {
				throw new RuntimeException("fail to update");
			}
			conn.commit();

			return savedArticle.getfno();
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
	private Faqcolumn toFaqMod(int delNo, Faq req) {
		Date now = new Date();
		return new Faqcolumn(delNo, req.getftit(), req.getftext(), now);
	}
}
