package admin.declaration.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import admin.declaration.dao.DeclarationDao;
import admin.declaration.model.Declarationcolumn;
import jdbc.DBConnection;

public class DeclarationService {
	
	private DeclarationDao declarationDao = new DeclarationDao();
	
	// 글 목록에 읽어오기
	public DeclarationPage getDeclarationPage(int pageNo) throws Exception {
		int size = 10;
		int startNo = (pageNo - 1) * size + 1;
		int endNo = startNo + 9;
		try (Connection conn = DBConnection.getConnection()) {
			int total = declarationDao.selectCount(conn);
			List<Declarationcolumn> declarationColumn = declarationDao.declarationSelect(conn, startNo, endNo);
			return new DeclarationPage(total, pageNo, size, declarationColumn);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public DeclarationData getDeclarationRead(int declarationNum) throws Exception {
		try (Connection conn = DBConnection.getConnection()){
			Declarationcolumn declarationColumn = declarationDao.declarationReadSelect(conn, declarationNum);
			return new DeclarationData(declarationColumn);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	// 글 목록에 읽어오기 끝

	// 글 삭제
	public void getDeclarationDelete(int delNo) throws SQLException, Exception {
		try(Connection conn = DBConnection.getConnection()){
			declarationDao.declarationDelete(conn, delNo);
		}
	}
	// 글 끝
}
