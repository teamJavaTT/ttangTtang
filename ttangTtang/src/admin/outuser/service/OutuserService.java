package admin.outuser.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import admin.outuser.dao.OutuserDao;
import admin.outuser.model.Outusercolumn;
import jdbc.DBConnection;

public class OutuserService {
	
	private OutuserDao outuserDao = new OutuserDao();
	
	// 글 목록에 읽어오기
	public OutuserPage getOutuserPage(int pageNo) throws Exception {
		int size = 10;
		int startNo = (pageNo - 1) * size + 1;
		int endNo = startNo + 9;
		try (Connection conn = DBConnection.getConnection()) {
			int total = outuserDao.selectCount(conn);
			List<Outusercolumn> outuserColumn = outuserDao.outuserSelect(conn, startNo, endNo);
			return new OutuserPage(total, pageNo, size, outuserColumn);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public OutuserData getOutuserRead(String outuserNum) throws Exception {
		try (Connection conn = DBConnection.getConnection()){
			Outusercolumn outuserColumn = outuserDao.outuserReadSelect(conn, outuserNum);
			if (outuserColumn == null) {
				throw new ArticleNotFoundException();
			}
			return new OutuserData(outuserColumn);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	// 글 목록에 읽어오기 끝

	// 글 삭제
	public void getOutuserDelete(int delNo) throws SQLException, Exception {
		try(Connection conn = DBConnection.getConnection()){
			outuserDao.outuserDelete(conn, delNo);
		}
	}
	// 글 끝
	
	// 수정
	/*
	 * public Integer outuserMod(int delNo, Outuser modReq) throws Exception {
	 * Connection conn = null; try { conn = DBConnection.getConnection();
	 * conn.setAutoCommit(false);
	 * 
	 * Outusercolumn outuser = toOutuserMod(delNo, modReq); Outusercolumn
	 * savedArticle = outuserDao.outuserUpdate(conn, outuser); if (savedArticle ==
	 * null) { throw new RuntimeException("fail to update"); } conn.commit();
	 * 
	 * return savedArticle.getFno(); } catch (SQLException e) {
	 * JdbcUtil.rollback(conn); throw new RuntimeException(e); } catch
	 * (RuntimeException e) { JdbcUtil.rollback(conn); throw e; } finally {
	 * JdbcUtil.close(conn); } } // 수정 끝 private Outusercolumn toOutuserMod(int
	 * delNo, Outuser req) { Date now = new Date(); return new
	 * Outusercolumn(delNo, req.getFtit(), req.getFtext(), now); }
	 */
}
