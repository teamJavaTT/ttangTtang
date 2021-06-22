package mypage.blockUser.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.DBConnection;
import mypage.blockUser.dao.BlockUserDao;

public class BlockUserService {

	private BlockUserDao blockUserDao = new BlockUserDao();

	public void getBlockUser(String userId, String bId, String bText) throws SQLException, Exception {
		try (Connection conn = DBConnection.getConnection()) {
			
			blockUserDao.blockUserInsert(conn, userId, bId, bText);
			conn.commit();
		}
	}

}