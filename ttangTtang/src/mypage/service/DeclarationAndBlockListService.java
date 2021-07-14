package mypage.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jdbc.DBConnection;
import mypage.dao.DeclarationAndBlockListDao;
import mypage.model.BlockColumn;
import mypage.model.DeclarationColumn;

public class DeclarationAndBlockListService {

	private DeclarationAndBlockListDao listDao = new DeclarationAndBlockListDao();

	// 신고
	public DeclarationListPage getDeclarationPage(String userId, int pageNo) throws Exception {
		int size = 10;
		int startNo = (pageNo - 1) * size + 1;
		int endNo = startNo + 9;
		try (Connection conn = DBConnection.getConnection()) {
			int total = listDao.selectCount(conn);
			List<DeclarationColumn> declarationColumn = listDao.declarationListCheckSelect(conn, userId, startNo, endNo);
			return new DeclarationListPage(total, pageNo, size, declarationColumn);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// 차단
	public BlockListPage getBlockPage(String userId, int pageNo) throws Exception {
		int size = 10;
		int startNo = (pageNo - 1) * size + 1;
		int endNo = startNo + 9;
		try (Connection conn = DBConnection.getConnection()) {
			int total = listDao.selectCount(conn);
			List<BlockColumn> blockColumn = listDao.blockListCheckSelect(conn, userId, startNo, endNo);
			return new BlockListPage(total, pageNo, size, blockColumn);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
