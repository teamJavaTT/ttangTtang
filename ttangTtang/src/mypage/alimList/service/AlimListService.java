package mypage.alimList.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.DBConnection;
import member.model.Alim;
import mypage.alimList.dao.AlimListDao;

public class AlimListService {

	private AlimListDao alimListDao = new AlimListDao();

	public ArrayList<Alim> alimSelect(String userid) throws Exception {
		try (Connection conn = DBConnection.getConnection()) {
			ArrayList<Alim> alimList = alimListDao.alimSelect(conn, userid);
			return alimList;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public ArrayList<Alim> alimAll(String userid) throws Exception {
		try (Connection conn = DBConnection.getConnection()) {
			ArrayList<Alim> alimAll = alimListDao.alimAllSelect(conn, userid);
			return alimAll;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
		
	public void alimChkUpdate(String userid) throws Exception {
		try (Connection conn = DBConnection.getConnection()) {
			alimListDao.alimChkUpdate(conn, userid);
		}	
	}
}