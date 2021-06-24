package mypage.deleteForm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jdbc.JdbcUtil;

public class DeleteFormDao {

	// 업데이트
	public void memberUpdate(Connection conn, String userId) throws SQLException {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement("update member set memberChk = 2 where userid = ?");
			pstmt.setString(1, userId);
			pstmt.executeQuery();
		} finally {
			JdbcUtil.close(pstmt);
		}
	}

	public void secessionInsert(Connection conn, String userId, String sText) throws SQLException {
		PreparedStatement pstmt = null;
		// insert 부분 구문
		try {
			pstmt = conn.prepareStatement("insert into secession values (secession_seq.NEXTVAL,?,?,sysdate, sysdate+7)");
			pstmt.setString(1, userId);
			pstmt.setString(2, sText);
			pstmt.executeUpdate();
		} finally {
			JdbcUtil.close(pstmt);
		}
	}

}
