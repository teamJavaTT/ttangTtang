package product.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import auth.model.Product;
import jdbc.DBConnection;
import jdbc.JdbcUtil;
import product.dao.ProductDao;
import product.model.AucPro;
import product.model.NorPro;

public class ProductService {
	
	private ProductDao productDao = new ProductDao();
	
	//일반상품
	public String NorProInsert (NorProRequeste norwriteReq) throws Exception{
		Connection conn = null;
		try{
			conn= DBConnection.getConnection();
			conn.setAutoCommit(false);
			
			NorPro norProduct = toNorProWrite(norwriteReq);
			NorPro savedNorProduct = productDao.insertNor(conn, norProduct);
			if (savedNorProduct == null) {
				throw new RuntimeException("실패");
			}
			conn.commit();
			
		
		}catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn);
		}
		return null;
	}
	private NorPro toNorProWrite(NorProRequeste norwriteReq) {
		return null;
	}

	//경매상품 
	public String AucProInsert(AucProRequest aucwriteReq) throws Exception{
		Connection conn = null;
		try{
			conn= DBConnection.getConnection();
			conn.setAutoCommit(false);
			
	
			AucPro savedAucProduct = productDao.insertAuc(conn , aucwriteReq);
			if (savedAucProduct == null) {
				throw new RuntimeException("실패");
			}
			conn.commit();
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn);
		}
		return null;
	}
	
	
	
	//검색
	public List<Product> getSearchPage(String search) throws Exception {
		try (Connection conn = DBConnection.getConnection()) {
			String[] searchArr = search.trim().split("");

			List<Product> searchProduct = productDao.selectSearchProduct(conn, searchArr);
			return searchProduct;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	//카테고리 검색
	public List<Product> getCategoryPage(String categories) throws Exception {
		try (Connection conn = DBConnection.getConnection()) {
			List<Product> searchProduct = productDao.selectCategoryProduct(conn, categories);
			return searchProduct;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}


}


