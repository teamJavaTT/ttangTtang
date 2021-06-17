package mypage.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.DBConnection;
import member.dao.MemberDao;
import mypage.dao.DeleteFromDao;

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
}
