package admin.declaration.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import admin.declaration.model.Declarationcolumn;
import jdbc.JdbcUtil;

public class DeclarationDao {
	
	// select 부분 시작
	
	public int selectCount(Connection conn) throws SQLException{
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select count(*) from declaration");
			if(rs.next()) {
				return rs.getInt(1);
			}
			return 0;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
		
	}
	
	public List<Declarationcolumn> declarationSelect(Connection conn, int startNo, int endNo) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select * from(select  row_number() over (order by dno desc) num, A.* from declaration A order by dno desc) where num between ? and ?");
			pstmt.setInt(1, startNo);
			pstmt.setInt(2, endNo);
			rs = pstmt.executeQuery();
			List<Declarationcolumn> result = new ArrayList<>();
			while (rs.next()) {
				result.add(declarationConvert(rs));
			}
			return result;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
	public Declarationcolumn declarationReadSelect(Connection conn, int no) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"select * from declaration where dNo = ?");
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			Declarationcolumn declarationColumn = null;
			if (rs.next()) {
				declarationColumn = declarationConvert(rs);
			}
			return declarationColumn;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
	private Declarationcolumn declarationConvert(ResultSet rs) throws SQLException {
		return new Declarationcolumn(rs.getInt("dNo"), rs.getString("userId"), rs.getString("duId"), rs.getString("dText"), rs.getDate("dDate"));
	}
	// select 부분 끝
	
	//업데이트
	/*
	 * public Declarationcolumn useridUpdate(Connection conn, Declarationcolumn notice)
	 * throws SQLException { PreparedStatement pstmt = null; Statement stmt = null;
	 * ResultSet rs = null; try { pstmt =
	 * conn.prepareStatement("update declaration set ftit = ?, ftext = ? where fno = ?"
	 * ); pstmt.setString(1, notice.getFtit()); pstmt.setString(2,
	 * notice.getFtext()); pstmt.setInt(3, notice.getFno()); int insertedCount =
	 * pstmt.executeUpdate();
	 * 
	 * if (insertedCount > 0) { stmt = conn.createStatement(); rs =
	 * stmt.executeQuery("select max(fno) from Declaration"); if (rs.next()) { Integer
	 * newNo = rs.getInt(1); return new Declarationcolumn(newNo, notice.getFtit(),
	 * notice.getFtext(), notice.getFdate()); } } return null; }finally {
	 * JdbcUtil.close(rs); JdbcUtil.close(stmt); JdbcUtil.close(pstmt); } }
	 */
	
	// 삭제
	public int declarationDelete(Connection conn, int delNo) throws SQLException {
		try (PreparedStatement pstmt = 
				conn.prepareStatement(
						"delete from declaration where dno = ?")) {
			pstmt.setInt(1, delNo);
			return pstmt.executeUpdate();
		}
	}
}
