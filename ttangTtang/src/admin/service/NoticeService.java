package admin.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import admin.dao.AdminDao;
import admin.model.Notice;
import admin.model.Noticecolumn;
import jdbc.DBConnection;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;

public class NoticeService {
	
	private static AdminDao adminDao = new AdminDao();

	public static Integer noticewrite(Notice writeReq) throws Exception {
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

	private static Noticecolumn toArticle(Notice req) {
		Date now = new Date();
		return new Noticecolumn(null, req.getmtit(), req.getmtext(), now);
	}

}
