package admin.notice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import admin.notice.model.Noticecolumn;
import jdbc.JdbcUtil;

public class AdminDao {
	public Noticecolumn noticeInsert(Connection conn, Noticecolumn notice) throws SQLException {
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		// insert 부분 구문
		try {
			pstmt = conn.prepareStatement("insert into Notice values (notice_seq.NEXTVAL,?,?,sysdate)");
			
			pstmt.setString(1, notice.getMtit());
			pstmt.setString(2, notice.getMtext());
			/* pstmt.setTimestamp(4, toTimestamp(article.getmdate())); */
			int insertedCount = pstmt.executeUpdate();

			if (insertedCount > 0) {
				stmt = conn.createStatement();
				rs = stmt.executeQuery("select max(mno) from Notice");
				if (rs.next()) {
					Integer newNo = rs.getInt(1);
					return new Noticecolumn(newNo, notice.getMtit(), notice.getMtext(), notice.getMdate());
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
	
	public List<Noticecolumn> noticeSelect(Connection conn, int startNo, int endNo) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select * from(select  row_number() over (order by mno desc) num, A.* from notice A order by mno desc) where num between ? and ?");
			pstmt.setInt(1, startNo);
			pstmt.setInt(2, endNo);
			rs = pstmt.executeQuery();
			List<Noticecolumn> result = new ArrayList<>();
			while (rs.next()) {
				result.add(noticeConvert(rs));
			}
			return result;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
	public Noticecolumn noticeReadSelect(Connection conn, int no) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"select * from notice where mno = ?");
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			Noticecolumn noticeColumn = null;
			if (rs.next()) {
				noticeColumn = noticeConvert(rs);
			}
			return noticeColumn;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	private Noticecolumn noticeConvert(ResultSet rs) throws SQLException {
		return new Noticecolumn(rs.getInt("mno"), rs.getString("mtit"), rs.getString("mtext"), rs.getDate("mdate"));
	}
	// select 부분 끝
	
	//업데이트
	public Noticecolumn noticeUpdate(Connection conn, Noticecolumn notice) throws SQLException {
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("update notice set mtit = ?, mtext = ? where mno = ?");
			pstmt.setString(1, notice.getMtit());
			pstmt.setString(2, notice.getMtext());
			pstmt.setInt(3, notice.getMno());
			int insertedCount = pstmt.executeUpdate();

			if (insertedCount > 0) {
				stmt = conn.createStatement();
				rs = stmt.executeQuery("select max(mno) from Notice");
				if (rs.next()) {
					Integer newNo = rs.getInt(1);
					return new Noticecolumn(newNo, notice.getMtit(), notice.getMtext(), notice.getMdate());
				}
			}
		return null;
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
			JdbcUtil.close(pstmt);
		}
	}
	
	// 삭제
	public int noticeDelete(Connection conn, int delNo) throws SQLException {
		try (PreparedStatement pstmt = conn.prepareStatement("delete from notice where mno = ?")) {
			pstmt.setInt(1, delNo);
			return pstmt.executeUpdate();
		}
	}
}
