package product.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import admin.model.Noticecolumn;
import jdbc.DBConnection;
import jdbc.JdbcUtil;

//public class ProductService {
//	private ProductDao productDao = new ProductDao();
//
//	public ProductPage getProductPage() throws Exception {
//		Connection conn = null;
//		try {
//			conn = DBConnection.getConnection();
//			conn.setAutoCommit(false);
//
//			Noticecolumn article = toArticle(writeReq);
//			Noticecolumn savedArticle = adminDao.insert(conn, article);
//			if (savedArticle == null) {
//				throw new RuntimeException("fail to insert article");
//			}
//			conn.commit();
//
//			return savedArticle.getmno();
//		} catch (SQLException e) {
//			JdbcUtil.rollback(conn);
//			throw new RuntimeException(e);
//		} catch (RuntimeException e) {
//			JdbcUtil.rollback(conn);
//			throw e; 
//		} finally {
//			JdbcUtil.close(conn);
//		}
//	}
//}
