package admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import admin.model.Notice;
import admin.model.Noticecolumn;
import auth.model.Category;
import auth.model.Product;
import jdbc.JdbcUtil;

public class AdminDao {
	public Noticecolumn insert(Connection conn, Noticecolumn article) throws SQLException {
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		// insert 부분 구문
		try {
			pstmt = conn.prepareStatement("insert into Notice values (notice_seq.NEXTVAL,?,?,sysdate)");
			
			pstmt.setString(1, article.getmtit());
			pstmt.setString(2, article.getmtext());
			/* pstmt.setTimestamp(4, toTimestamp(article.getmdate())); */
			int insertedCount = pstmt.executeUpdate();

			if (insertedCount > 0) {
				stmt = conn.createStatement();
				rs = stmt.executeQuery("select max(mno) from Notice");
				if (rs.next()) {
					Integer newNo = rs.getInt(1);
					return new Noticecolumn(newNo,
							article.getmtit(),
							article.getmtext(),
							article.getmdate());
				}
			}
			return null;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
			JdbcUtil.close(pstmt);
		}
	}
	// insert 부분 구문끝
	// select 부분 시작
	
	public int selectCount(Connection conn) throws SQLException{
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select count(*) from notice");
			if(rs.next()) {
				return rs.getInt(1);
			}
			return 0;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
		
	}
	
	
	public List<Noticecolumn> selectNotice(Connection conn, int startNo, int endNo) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select * from(select  row_number() over (order by mno desc) num, A.* from notice A order by mno desc) where num between ? and ?");
			pstmt.setInt(1, startNo);
			pstmt.setInt(2, endNo);
			rs = pstmt.executeQuery();
			List<Noticecolumn> result = new ArrayList<>();
			while (rs.next()) {
				result.add(convertNotice(rs));
			}
			return result;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
	/*
	 * public List<Noticecolumn> selectNotice(Connection conn) throws SQLException {
	 * PreparedStatement pstmt = null; ResultSet rs = null; try { pstmt =
	 * conn.prepareStatement("select * from notice order by mno"); rs =
	 * pstmt.executeQuery(); List<Noticecolumn> result = new ArrayList<>(); while
	 * (rs.next()) { result.add(convertNotice(rs)); } return result; } finally {
	 * JdbcUtil.close(rs); JdbcUtil.close(pstmt); } }
	 */	
	private Noticecolumn convertNotice(ResultSet rs) throws SQLException {
		return new Noticecolumn(rs.getInt("mno"), rs.getString("mtit"), rs.getString("mtext"), rs.getDate("mdate"));
	}
	// select 부분 끝
	
	public void increaseReadCount(Connection conn, int no) throws SQLException {
		try (PreparedStatement pstmt = 
				conn.prepareStatement(
						"update article set read_cnt = read_cnt + 1 where article_no = ?")) {
			pstmt.setInt(1, no);
			pstmt.executeUpdate();
		}
	}
	
	public int update(Connection conn, int no, String title) throws SQLException {
		try (PreparedStatement pstmt = 
				conn.prepareStatement(
						"update article set title = ?, moddate = now() where article_no = ?")) {
			pstmt.setString(1, title);
			pstmt.setInt(2, no);
			return pstmt.executeUpdate();
		}
	}
	public int delete(Connection conn, int no) throws SQLException {
		try (PreparedStatement pstmt = 
				conn.prepareStatement(
						"delete from article where article_no = ?")) {
			pstmt.setInt(1, no);
			return pstmt.executeUpdate();
		}
	}
}
