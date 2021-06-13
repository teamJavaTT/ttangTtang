package admin.userinfo.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import admin.userinfo.dao.AdminDao;
import admin.userinfo.model.Userinfocolumn;
import jdbc.DBConnection;

public class UserinfoService {
	
	private AdminDao adminDao = new AdminDao();
	
	// 글 목록에 읽어오기
	public UserinfoPage getUserinfoPage(int pageNo) throws Exception {
		int size = 10;
		int startNo = (pageNo - 1) * size + 1;
		int endNo = startNo + 9;
		try (Connection conn = DBConnection.getConnection()) {
			int total = adminDao.selectCount(conn);
			List<Userinfocolumn> userinfoColumn = adminDao.userinfoSelect(conn, startNo, endNo);
			return new UserinfoPage(total, pageNo, size, userinfoColumn);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public UserinfoData getUserinfoRead(String userinfoNum) throws Exception {
		try (Connection conn = DBConnection.getConnection()){
			Userinfocolumn userinfoColumn = adminDao.userinfoReadSelect(conn, userinfoNum);
			if (userinfoColumn == null) {
				throw new ArticleNotFoundException();
			}
			return new UserinfoData(userinfoColumn);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	// 글 목록에 읽어오기 끝

	// 글 삭제
	public void getUserinfoDelete(int delNo) throws SQLException, Exception {
		try(Connection conn = DBConnection.getConnection()){
			adminDao.userinfoDelete(conn, delNo);
		}
	}
	// 글 끝
	
	// 수정
	/*
	 * public Integer userinfoMod(int delNo, Userinfo modReq) throws Exception {
	 * Connection conn = null; try { conn = DBConnection.getConnection();
	 * conn.setAutoCommit(false);
	 * 
	 * Userinfocolumn userinfo = toUserinfoMod(delNo, modReq); Userinfocolumn
	 * savedArticle = adminDao.userinfoUpdate(conn, userinfo); if (savedArticle ==
	 * null) { throw new RuntimeException("fail to update"); } conn.commit();
	 * 
	 * return savedArticle.getFno(); } catch (SQLException e) {
	 * JdbcUtil.rollback(conn); throw new RuntimeException(e); } catch
	 * (RuntimeException e) { JdbcUtil.rollback(conn); throw e; } finally {
	 * JdbcUtil.close(conn); } } // 수정 끝 private Userinfocolumn toUserinfoMod(int
	 * delNo, Userinfo req) { Date now = new Date(); return new
	 * Userinfocolumn(delNo, req.getFtit(), req.getFtext(), now); }
	 */
}
