package mypage.service;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.DBConnection;
import jdbc.JdbcUtil;
import mypage.dao.DeleteFormDao;
import mypage.model.DeleteFromcolumn;

public class DeleteFormService {

	private DeleteFormDao deleteFormDao = new DeleteFormDao();

	
	public void getDeleteform(int delmember) throws SQLException, Exception {
		try(Connection conn = DBConnection.getConnection()){
			deleteFormDao.Delete(conn, delmember);
		}
	}
}
	/*public Integer delete(String id, String password) throws Exception {
		try (Connection conn = DBConnection.getConnection()) {
			DeleteFrom deleteFrom = deleteFromDao.selectById(conn, id);
			if (deleteFrom == null) {
				throw new LoginFailException();
			}
			if (!deleteFrom.matchPassword(password)) {
				throw new LoginFailException();
			}
			return new User(deleteFrom.getUserid(), deleteFrom.getUserpassword());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	
	
	
		
		/*
		 * // 삭제 public int noticeDelete(Connection conn, int delNo) throws SQLException
		 * { try (PreparedStatement pstmt =
		 * conn.prepareStatement("delete from notice where mno = ?")) { pstmt.setInt(1,
		 * delNo); return pstmt.executeUpdate(); } }
		 */
	
	
//	public String DeteleFrom(String userid, String userpassword) throws Exception {
//		Connection conn = null;
//
//		try {
//			conn = DBConnection.getConnection();
//			// DAO 객체를 생성 시 Connection 전달
//			DeleteFromDao deleteFromDao = new DeleteFromDao();
//			String upw = deleteFromDao.DeteleFrom(conn, userid, userpassword);
//			return upw;
//		}
//
//		finally {
//			if (conn != null)
//				try {
//					conn.close();
//				} catch (SQLException ex) {
//				}
//			;
//
//		}
//
//	}
//	public void getOutuserDelete(int delNo) throws SQLException, Exception {
//		try(Connection conn = DBConnection.getConnection()){
//			deleteFromDao.outuserDelete(conn, delNo);
//		}
//	}
//	
	


