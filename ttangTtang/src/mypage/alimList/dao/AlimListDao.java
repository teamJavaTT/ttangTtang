package mypage.alimList.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.JdbcUtil;
import member.model.Alim;

public class AlimListDao {
	public ArrayList<Alim> alimSelect(Connection conn, String userid) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select * from alim where userid = ? and alimchk='N' order by lno desc");
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			ArrayList<Alim> result = new ArrayList<>();
			while (rs.next()) {
				result.add(convertAlim(rs));
			}
			return result;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
	public ArrayList<Alim> alimAllSelect(Connection conn, String userid) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select * from alim where userid = ? order by lno desc");
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			ArrayList<Alim> result = new ArrayList<>();
			while (rs.next()) {
				result.add(convertAlim(rs));
			}
			return result;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
	private Alim convertAlim(ResultSet rs) throws SQLException {
		return new Alim(rs.getString("lno"), rs.getString("userid"), rs.getString("ltext"), rs.getString("ldate"),rs.getString("alimchk"));
	}
	
	public void alimChkUpdate(Connection conn, String userid) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("update alim set alimchk = 'Y' where alimchk = 'N' and userid = ?");
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
}
