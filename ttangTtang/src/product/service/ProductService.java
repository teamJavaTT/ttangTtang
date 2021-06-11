package product.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.DBConnection;
import jdbc.JdbcUtil;
import product.dao.AucProDao;
import product.dao.NorProDao;
import product.model.AucPro;
import product.model.NorPro;

public class ProductService {
	
	//일반상품
	private NorProDao norproDao = new NorProDao();
	
	public String NorPro (NorProRequeste norwriteReq) throws Exception{
		Connection conn = null;
		try{
			conn= DBConnection.getConnection();
			conn.setAutoCommit(false);
			
			NorPro norProduct = toNorProWrite(norwriteReq);
			NorPro savedNorProduct = NorProDao.insert(conn , norProduct);
			if (savedNorProduct == null) {
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

	
	
	
	private NorPro toNorProWrite(NorProRequeste norwriteReq) {
		return null;
	}












//경매상품 
	
	private AucProDao aucproDao = new AucProDao();

	public String AucPro (AucProRequest aucwriteReq) throws Exception{
		Connection conn = null;
		try{
			conn= DBConnection.getConnection();
			conn.setAutoCommit(false);
			
			AucPro aucProduct =toAucProWrite(aucwriteReq);
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

	private AucPro toAucProWrite(AucProRequest aucwriteReq) {
		
		return null;
	}


}


