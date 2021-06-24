package mypage.accoundDeclaration.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jdbc.JdbcUtil;

public class AccountDeclarationDao {

	

	public void accoundDeclarationInsert(Connection conn, String userId, String declId, String dText) throws SQLException {
		PreparedStatement pstmt = null;
		// insert 부분 구문
		try {
			pstmt = conn.prepareStatement("insert into declaration values (declaration_seq.nextval, ?, ?, ?,sysdate)");
			pstmt.setString(1, userId);
			pstmt.setString(2, declId);
			pstmt.setString(3, dText);
			pstmt.executeUpdate();
		} finally {
			JdbcUtil.close(pstmt);
		}
	}

}
