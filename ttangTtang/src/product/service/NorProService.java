package product.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.DBConnection;
import jdbc.JdbcUtil;
import product.dao.NorProDao;
import product.model.NorPro;

public class NorProService {

	private NorProDao norproDao = new NorProDao();

	public String NorPro (NorProRequest writeReq) throws Exception{
		Connection conn = null;
		try{
			conn= DBConnection.getConnection();
			conn.setAutoCommit(false);
			
			NorPro norProduct =toNorProWrite(writeReq);
			NorPro savedNorProduct = NorProDao.insert(conn , norProduct);
			if (savednorProduct == null) {
				throw new RuntimeException("fail to insert article");
			}
			conn.commit();
			
		return savedNorProduct.getProduct_name();
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

	private NorPro toNorProWrite(NorProRequest writeReq) {
		
		return null;
	}


	}

