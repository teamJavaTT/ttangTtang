package mypage.blockUser.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jdbc.JdbcUtil;

public class BlockUserDao {

	

	public void blockUserInsert(Connection conn, String userId, String blockid2, String bText) throws SQLException {
		PreparedStatement pstmt = null;
		// insert 부분 구문
		try {
			pstmt = conn.prepareStatement("insert into block values (bno_seq.nextval, ?, ?, ?,sysdate)");
			pstmt.setString(1, userId);
			pstmt.setString(2, blockid2);
			pstmt.setString(3, bText);
			pstmt.executeUpdate();
		} finally {
			JdbcUtil.close(pstmt);
		}
	}

}
