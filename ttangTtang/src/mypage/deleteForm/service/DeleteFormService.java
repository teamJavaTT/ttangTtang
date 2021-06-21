package mypage.deleteForm.service;

import java.sql.Connection;
import java.sql.SQLException;
import jdbc.DBConnection;
import mypage.deleteForm.dao.DeleteFormDao;

public class DeleteFormService {

	private DeleteFormDao deleteFormDao = new DeleteFormDao();

	public void getDeleteform(String userId, String sText) throws SQLException, Exception {
		try (Connection conn = DBConnection.getConnection()) {
			deleteFormDao.memberUpdate(conn, userId);
			deleteFormDao.secessionInsert(conn, userId, sText);
		}
	}

}