package mypage.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.DBConnection;
import member.service.LoginFailException;
import member.service.User;
import mypage.dao.DeleteFromDao;
import mypage.model.DeleteFrom;

public class DeleteFromService {

	private DeleteFromDao deleteFromDao = new DeleteFromDao();

	public String DeteleFrom(String userid, String userpassword) throws Exception {
		Connection conn = null;

		try {
			conn = DBConnection.getConnection();
			// DAO 객체를 생성 시 Connection 전달
			DeleteFromDao deleteFromDao = new DeleteFromDao();
			String upw = deleteFromDao.DeteleFrom(conn, userid, userpassword);
			return upw;
		}

		finally {
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
			;

		}

	}
	public void getOutuserDelete(int delNo) throws SQLException, Exception {
		try(Connection conn = DBConnection.getConnection()){
			deleteFromDao.outuserDelete(conn, delNo);
		}
	}
	
	public User delete(String id, String password) throws Exception {
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

}
