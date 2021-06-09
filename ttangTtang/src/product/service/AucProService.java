package product.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.DBConnection;
import jdbc.JdbcUtil;
import product.dao.AucProDao;
import product.model.AucPro;

public class AucProService {

	private AucProDao aucproDao = new AucProDao();

	public String AucPro (AucProRequest writeReq) throws Exception{
		Connection conn = null;
		try{
			conn= DBConnection.getConnection();
			conn.setAutoCommit(false);
			
			AucPro aucProduct =toAucProWrite(writeReq);
			AucPro savedAucProduct = AucProDao.insert(conn , aucProduct);
			if (savedAucProduct == null) {
				throw new RuntimeException("fail to insert article");
			}
			conn.commit();
			
		return savedAucProduct.getProduct_name();
		}catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} catch (RuntimeException e) {
			JdbcUtil.rollback(conn);
			throw e; 
		} finally {
			JdbcUtil.close(conn);
		}
	}

	private AucPro toAucProWrite(AucProRequest writeReq) {
		
		return null;
	}


	}

