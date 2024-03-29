package mypage.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jdbc.DBConnection;
import mypage.dao.SellCheckDao;
import mypage.model.ProductColumn;

public class SellCheckService {
	
	private SellCheckDao sellCheckDao = new SellCheckDao();
	
	// 전체 회원 체크시 이동되는 곳
	public SellCheckPage getSellCheckPage(int pageNo,String userId) throws Exception {
		int size = 10;
		int startNo = (pageNo - 1) * size + 1;
		int endNo = startNo + 9;
		try (Connection conn = DBConnection.getConnection()) {
			int total = sellCheckDao.selectCount(conn);
			List<ProductColumn> productColumn = sellCheckDao.sellCheckSelect(conn, userId, startNo, endNo);
			return new SellCheckPage(total, pageNo, size, productColumn);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	// 정규 회원이랑 탈퇴회원 체크시 이동되는 곳
	public SellCheckPage getSellCheckListPage(int pageNo, String userId, String sellCheck) throws Exception {
		int size = 10;
		int startNo = (pageNo - 1) * size + 1;
		int endNo = startNo + 9;
		String sellChk = sellCheck;
		try (Connection conn = DBConnection.getConnection()) {
			int total = sellCheckDao.selectCount(conn);
			List<ProductColumn> productColumn = sellCheckDao.sellCheckListSelect(conn, userId, sellChk, startNo, endNo);
			return new SellCheckPage(total, pageNo, size, productColumn);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	// 글 목록에 읽어오기 끝
}
