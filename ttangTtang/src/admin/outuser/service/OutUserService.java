package admin.outuser.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import admin.outuser.dao.OutUserDao;
import admin.outuser.model.OutUsercolumn;
import jdbc.DBConnection;

public class OutUserService {
	
	private OutUserDao outuserDao = new OutUserDao();
	
	// 글 목록에 읽어오기
	public OutUserPage getOutUserPage(int pageNo) throws Exception {
		int size = 10;
		int startNo = (pageNo - 1) * size + 1;
		int endNo = startNo + 9;
		try (Connection conn = DBConnection.getConnection()) {
			int total = outuserDao.selectCount(conn);
			List<OutUsercolumn> outuserColumn = outuserDao.outuserSelect(conn, startNo, endNo);
			return new OutUserPage(total, pageNo, size, outuserColumn);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public OutUserData getOutUserRead(int outuserNum) throws Exception {
		try (Connection conn = DBConnection.getConnection()){
			OutUsercolumn outuserColumn = outuserDao.outuserReadSelect(conn, outuserNum);
			if (outuserColumn == null) {
				throw new ArticleNotFoundException();
			}
			return new OutUserData(outuserColumn);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	// 글 목록에 읽어오기 끝

	// 글 삭제
	public void getOutUserDelete(int delNo) throws SQLException, Exception {
		try(Connection conn = DBConnection.getConnection()){
			outuserDao.outuserDelete(conn, delNo);
		}
	}
	// 글 끝
}
