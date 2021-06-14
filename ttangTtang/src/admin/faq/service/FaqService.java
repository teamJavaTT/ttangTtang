package admin.faq.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import admin.faq.dao.FaqDao;
import admin.faq.model.Faq;
import admin.faq.model.Faqcolumn;
import jdbc.DBConnection;
import jdbc.JdbcUtil;

public class FaqService {
	
	private FaqDao faqDao = new FaqDao();
	
	// 글 입력하기
	public Integer faqWrite(Faq writeReq) throws Exception {
		Connection conn = null;
		try {
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false);

			Faqcolumn faqColumn = toColumn(writeReq);
			Faqcolumn savedArticle = faqDao.faqInsert(conn, faqColumn);
			if (savedArticle == null) {
				throw new RuntimeException("fail to insert article");
			}
			conn.commit();

			return savedArticle.getFno();
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
	private Faqcolumn toColumn(Faq req) {
		Date now = new Date();
				
		return new Faqcolumn(null, req.getFtit(), req.getFtext(), now);
	}
	// 글 입력하기 끝
	
	// 글 목록에 읽어오기
	public FaqPage getFaqPage(int pageNo) throws Exception {
		int size = 10;
		int startNo = (pageNo - 1) * size + 1;
		int endNo = startNo + 9;
		try (Connection conn = DBConnection.getConnection()) {
			int total = faqDao.selectCount(conn);
			List<Faqcolumn> faqColumn = faqDao.faqSelect(conn, startNo, endNo);
			return new FaqPage(total, pageNo, size, faqColumn);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public FaqData getFaqRead(int faqNum) throws Exception {
		try (Connection conn = DBConnection.getConnection()){
			Faqcolumn faqColumn = faqDao.faqReadSelect(conn, faqNum);
			if (faqColumn == null) {
				throw new ArticleNotFoundException();
			}
			return new FaqData(faqColumn);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	// 글 목록에 읽어오기 끝

	// 글 삭제
	public void getFaqDelete(int delNo) throws SQLException, Exception {
		try(Connection conn = DBConnection.getConnection()){
			faqDao.faqDelete(conn, delNo);
		}
	}
	// 글 끝
	
	// 수정
	public Integer faqMod(int delNo, Faq modReq) throws Exception {
		Connection conn = null;
		try {
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false);

			Faqcolumn faq = toFaqMod(delNo, modReq);
			Faqcolumn savedArticle = faqDao.updateFaq(conn, faq);
			if (savedArticle == null) {
				throw new RuntimeException("fail to update");
			}
			conn.commit();

			return savedArticle.getFno();
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
		return new Faqcolumn(delNo, req.getFtit(), req.getFtext(), now);
	}
}
