package admin.notice.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import admin.notice.service.NoticeData;
import admin.notice.dao.AdminDao;
import admin.notice.model.Notice;
import admin.notice.model.Noticecolumn;
import jdbc.DBConnection;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;

public class NoticeService {
	
	private AdminDao adminDao = new AdminDao();
	
	// 글 입력하기
	public Integer noticewrite(Notice writeReq) throws Exception {
		Connection conn = null;
		try {
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false);

			Noticecolumn article = toArticle(writeReq);
			Noticecolumn savedArticle = adminDao.insert(conn, article);
			if (savedArticle == null) {
				throw new RuntimeException("fail to insert article");
			}
			conn.commit();

			return savedArticle.getmno();
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

	private Noticecolumn toArticle(Notice req) {
		Date now = new Date();
		return new Noticecolumn(null, req.getmtit(), req.getmtext(), now);
	}
	// 글 입력하기 끝
	
	// 글 목록에 읽어오기
	public NoticePage getNoticePage(int pageNo) throws Exception {
		int size = 10;
		int startNo = (pageNo - 1) * size + 1;
		int endNo = startNo + 9;
		try (Connection conn = DBConnection.getConnection()) {
			int total = adminDao.selectCount(conn);
			List<Noticecolumn> noticecolumn = adminDao.selectNotice(conn, startNo, endNo);
			return new NoticePage(total, pageNo, size, noticecolumn);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	// 글 목록에 읽어오기 끝

	public NoticeData getNoticeRead(int noticeNum) throws Exception {
		try (Connection conn = DBConnection.getConnection()){
			Noticecolumn noticecolumn = adminDao.selectById(conn, noticeNum);
			if (noticecolumn == null) {
				throw new ArticleNotFoundException();
			}
			return new NoticeData(noticecolumn);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void getNoticeDelete(int delNo) throws SQLException, Exception {
		try(Connection conn = DBConnection.getConnection()){
			adminDao.deleteNotice(conn, delNo);
		}
	}
}
