package admin.notice.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import admin.notice.dao.NoticeDao;
import admin.notice.model.Notice;
import admin.notice.model.Noticecolumn;
import jdbc.DBConnection;
import jdbc.JdbcUtil;

public class NoticeService {
	
	private NoticeDao noticeDao = new NoticeDao();
	
	// 글 입력하기
	public Integer noticeWrite(Notice writeReq) throws Exception {
		Connection conn = null;
		try {
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false);

			Noticecolumn noticeColumn = toColumn(writeReq);
			Noticecolumn savedArticle = noticeDao.noticeInsert(conn, noticeColumn);
			if (savedArticle == null) {
				throw new RuntimeException("fail to insert article");
			}
			conn.commit();

			return savedArticle.getMno();
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
	private Noticecolumn toColumn(Notice req) {
		Date now = new Date();
				
		return new Noticecolumn(null, req.getMtit(), req.getMtext(), now);
	}
	// 글 입력하기 끝
	
	// 글 목록에 읽어오기
	public NoticePage getNoticePage(int pageNo) throws Exception {
		int size = 10;
		int startNo = (pageNo - 1) * size + 1;
		int endNo = startNo + 9;
		try (Connection conn = DBConnection.getConnection()) {
			int total = noticeDao.selectCount(conn);
			List<Noticecolumn> noticeColumn = noticeDao.noticeSelect(conn, startNo, endNo);
			return new NoticePage(total, pageNo, size, noticeColumn);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public NoticeData getNoticeRead(int noticeNum) throws Exception {
		try (Connection conn = DBConnection.getConnection()){
			Noticecolumn noticeColumn = noticeDao.noticeReadSelect(conn, noticeNum);
			return new NoticeData(noticeColumn);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	// 글 목록에 읽어오기 끝

	// 글 삭제
	public void getNoticeDelete(int delNo) throws SQLException, Exception {
		try(Connection conn = DBConnection.getConnection()){
			noticeDao.noticeDelete(conn, delNo);
		}
	}
	// 글 끝
	
	// 수정
	
	public Integer noticeMod(int delNo, Notice modReq) throws Exception {
		Connection conn = null;
		try {
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false);

			Noticecolumn notice = toNoticeMod(delNo, modReq);
			Noticecolumn savedArticle = noticeDao.noticeUpdate(conn, notice);
			if (savedArticle == null) {
				throw new RuntimeException("fail to update");
			}
			conn.commit();

			return savedArticle.getMno();
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
	private Noticecolumn toNoticeMod(int delNo, Notice req) {
		Date now = new Date();
		return new Noticecolumn(delNo, req.getMtit(), req.getMtext(), now);
	}
}
