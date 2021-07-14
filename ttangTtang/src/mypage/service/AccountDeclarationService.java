package mypage.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.DBConnection;
import mypage.dao.AccountDeclarationDao;

public class AccountDeclarationService {

	private AccountDeclarationDao accountDeclarationDao = new AccountDeclarationDao();

	public void getAccountDeclaration(String userId, String declId, String dText) throws SQLException, Exception {
		try (Connection conn = DBConnection.getConnection()) {
			
			accountDeclarationDao.accoundDeclarationInsert(conn, userId, declId, dText);
			
		}
	}

}