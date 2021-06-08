package product.service;

import java.sql.Connection;

import jdbc.DBConnection;
import product.dao.AucProDao;

public class AucProService {

	private AucProDao aucproDao = new AucProDao();

	public AucPro (AucProRequest aucReq) throws Exception{
		Connection conn = null;
		try{
			conn= DBConnection.getConnection();
			conn.setAutoCommit(false);
			
		
		}
	}

}
