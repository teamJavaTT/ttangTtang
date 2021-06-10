package admin.faq.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import admin.faq.model.Faqcolumn;
import jdbc.JdbcUtil;

public class AdminDao {
	public Faqcolumn insert(Connection conn, Faqcolumn article) throws SQLException {
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		// insert 부분 구문
		try {
			pstmt = conn.prepareStatement("insert into Faq values (faq_seq.NEXTVAL,?,?,sysdate)");
			
			pstmt.setString(1, article.getftit());
			pstmt.setString(2, article.getftext());
			int insertedCount = pstmt.executeUpdate();

			if (insertedCount > 0) {
				stmt = conn.createStatement();
				rs = stmt.executeQuery("select max(fno) from Faq");
				if (rs.next()) {
					Integer newNo = rs.getInt(1);
					return new Faqcolumn(newNo, article.getftit(), article.getftext(), article.getfdate());
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
			rs = stmt.executeQuery("select count(*) from faq");
			if(rs.next()) {
				return rs.getInt(1);
			}
			return 0;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
		
	}
	
	
	public List<Faqcolumn> selectFaq(Connection conn, int startNo, int endNo) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select * from(select  row_number() over (order by fno desc) num, A.* from faq A order by fno desc) where num between ? and ?");
			pstmt.setInt(1, startNo);
			pstmt.setInt(2, endNo);
			rs = pstmt.executeQuery();
			List<Faqcolumn> result = new ArrayList<>();
			while (rs.next()) {
				result.add(convertFaq(rs));
			}
			return result;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
	public Faqcolumn selectById(Connection conn, int no) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"select * from faq where fno = ?");
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			Faqcolumn faqcolumn = null;
			if (rs.next()) {
				faqcolumn = convertFaq(rs);
			}
			return faqcolumn;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	private Faqcolumn convertFaq(ResultSet rs) throws SQLException {
		return new Faqcolumn(rs.getInt("fno"), rs.getString("ftit"), rs.getString("ftext"), rs.getDate("fdate"));
	}
	// select 부분 끝
	
	//업데이트
	public Faqcolumn updateFaq(Connection conn, Faqcolumn notice) throws SQLException {
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("update faq set ftit = ?, ftext = ? where fno = ?");
			pstmt.setString(1, notice.getftit());
			pstmt.setString(2, notice.getftext());
			pstmt.setInt(3, notice.getfno());
			int insertedCount = pstmt.executeUpdate();

			if (insertedCount > 0) {
				stmt = conn.createStatement();
				rs = stmt.executeQuery("select max(fno) from Faq");
				if (rs.next()) {
					Integer newNo = rs.getInt(1);
					return new Faqcolumn(newNo, notice.getftit(), notice.getftext(), notice.getfdate());
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
	public int deleteFaq(Connection conn, int delNo) throws SQLException {
		try (PreparedStatement pstmt = 
				conn.prepareStatement(
						"delete from faq where mno = ?")) {
			pstmt.setInt(1, delNo);
			return pstmt.executeUpdate();
		}
	}
}
