package admin.userinfo.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import admin.userinfo.dao.UserInfoDao;
import admin.userinfo.model.Userinfocolumn;
import jdbc.DBConnection;

public class UserinfoService {
	
	private UserInfoDao userinfoDao = new UserInfoDao();
	
	// 전체 회원 체크시 이동되는 곳
	public UserinfoPage getUserinfoPage(int pageNo) throws Exception {
		int size = 10;
		int startNo = (pageNo - 1) * size + 1;
		int endNo = startNo + 9;
		try (Connection conn = DBConnection.getConnection()) {
			int total = userinfoDao.selectCount(conn);
			List<Userinfocolumn> userinfoColumn = userinfoDao.userinfoSelect(conn, startNo, endNo);
			return new UserinfoPage(total, pageNo, size, userinfoColumn);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	// 정규 회원이랑 탈퇴회원 체크시 이동되는 곳
	public UserinfoPage getUserinfoMemberChkPage(int pageNo, int memberChk) throws Exception {
		int size = 10;
		int startNo = (pageNo - 1) * size + 1;
		int endNo = startNo + 9;
		int memChk = memberChk;
		try (Connection conn = DBConnection.getConnection()) {
			int total = userinfoDao.selectCount(conn);
			List<Userinfocolumn> userinfoColumn = userinfoDao.userinfoMemberChkSelect(conn, memChk, startNo, endNo);
			return new UserinfoPage(total, pageNo, size, userinfoColumn);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	// 글 목록에 읽어오기 끝

	// 회원정보 읽어오는 곳
	public UserinfoData getUserinfoRead(String userinfoNum) throws Exception {
		try (Connection conn = DBConnection.getConnection()){
			Userinfocolumn userinfoColumn = userinfoDao.userinfoReadSelect(conn, userinfoNum);
			return new UserinfoData(userinfoColumn);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	

	// 글 삭제
	public void getUserinfoDelete(int delNo) throws SQLException, Exception {
		try(Connection conn = DBConnection.getConnection()){
			userinfoDao.userinfoDelete(conn, delNo);
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
	 * savedArticle = userinfoDao.userinfoUpdate(conn, userinfo); if (savedArticle ==
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
