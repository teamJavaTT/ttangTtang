package mypage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jdbc.JdbcUtil;
import mypage.model.DeleteFormcolumn;

public class DeleteFormDao {

	
	
/*	public DeleteFromcolumn Delete(Connection conn, String delid) throws SQLException {
		try (PreparedStatement pstmt = conn.prepareStatement("delete from member where mid = ?")) {
			pstmt.setString(1, delid);
			return pstmt.executeUpdate();
		}
	}
*/
	
	
	//업데이트
		public DeleteFormcolumn memberUpdate(Connection conn, String userId) throws SQLException {
			PreparedStatement pstmt = null;
			Statement stmt = null;
			ResultSet rs = null;
			try {
				pstmt = conn.prepareStatement("update member set memberChk = 2 where userid = ?");
				pstmt.setString(1, userId);
				
				
				rs = pstmt.executeQuery();
				DeleteFormcolumn deleteFromcolumn = null;
				if (rs.next()) {
					deleteFromcolumn = memberConvert(rs);
				}
				return deleteFromcolumn;
			} finally {
				JdbcUtil.close(rs);
				JdbcUtil.close(pstmt);
			}
		}
		private DeleteFormcolumn memberConvert(ResultSet rs) throws SQLException {
			return new DeleteFormcolumn(rs.getString("userId"), rs.getString("uEmail"), rs.getString("uName"), rs.getString("phone"), rs.getString("sex"), rs.getDate("dateTime"), rs.getInt("memberChk"));
		}
}
	
	

	
	
