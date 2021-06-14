package admin.blacklist.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import admin.blacklist.dao.BlacklistDao;
import admin.blacklist.model.Blacklistcolumn;
import jdbc.DBConnection;

public class BlacklistService {
	
	private BlacklistDao blacklistDao = new BlacklistDao();
	
	// 글 목록에 읽어오기
	public BlacklistPage getBlacklistPage(int pageNo) throws Exception {
		int size = 10;
		int startNo = (pageNo - 1) * size + 1;
		int endNo = startNo + 9;
		try (Connection conn = DBConnection.getConnection()) {
			int total = blacklistDao.selectCount(conn);
			List<Blacklistcolumn> blacklistColumn = blacklistDao.blacklistSelect(conn, startNo, endNo);
			return new BlacklistPage(total, pageNo, size, blacklistColumn);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public BlacklistData getBlacklistRead(int blacklistNum) throws Exception {
		try (Connection conn = DBConnection.getConnection()){
			Blacklistcolumn blacklistColumn = blacklistDao.blacklistReadSelect(conn, blacklistNum);
			if (blacklistColumn == null) {
				throw new ArticleNotFoundException();
			}
			return new BlacklistData(blacklistColumn);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	// 글 목록에 읽어오기 끝

	// 글 삭제
	public void getBlacklistDelete(int delNo) throws SQLException, Exception {
		try(Connection conn = DBConnection.getConnection()){
			blacklistDao.blacklistDelete(conn, delNo);
		}
	}
	// 글 끝
}
