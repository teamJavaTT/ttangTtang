package mypage.declarationAndBlockList.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jdbc.DBConnection;
import mypage.declarationAndBlockList.dao.DeclarationAndBlockListDao;
import mypage.declarationAndBlockList.model.DeclarationColumn;

public class DeclarationAndBlockListService {

	private DeclarationAndBlockListDao listDao = new DeclarationAndBlockListDao();

	// 전체 회원 체크시 이동되는 곳
	public ListPage getListPage(int pageNo) throws Exception {
		int size = 10;
		int startNo = (pageNo - 1) * size + 1;
		int endNo = startNo + 9;
		try (Connection conn = DBConnection.getConnection()) {
			int total = listDao.selectCount(conn);
			List<DeclarationColumn> productColumn = listDao.listCheckSelect(conn, null, null, startNo, endNo);
			return new ListPage(total, pageNo, size, productColumn);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// 정규 회원이랑 탈퇴회원 체크시 이동되는 곳
	public ListPage getCheckListPage(int pageNo, String sellCheck) throws Exception {
		int size = 10;
		int startNo = (pageNo - 1) * size + 1;
		int endNo = startNo + 9;
		String sellChk = sellCheck;
		try (Connection conn = DBConnection.getConnection()) {
			int total = listDao.selectCount(conn);
			List<DeclarationColumn> productColumn = listDao.CheckSelect(conn, sellChk, startNo, endNo);
			return new ListPage(total, pageNo, size, productColumn);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
