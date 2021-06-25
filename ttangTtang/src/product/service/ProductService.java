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

	// 일반상품
	public String NorProInsert(NorProRequest norwriteReq) throws Exception {
		Connection conn = null;
		try {
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false);

			productDao.insertNor(conn, norwriteReq);
			conn.commit();
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn);
		}
		return null;
	}

	// 경매상품
	public String AucProInsert(AucProRequest aucwriteReq) throws Exception {
		Connection conn = null;
		try {
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false);

			productDao.insertAuc(conn, aucwriteReq);
			conn.commit();
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn);
		}
		return null;
	}

	// aucPro 상품 불러오기
	public AucPro getAucPro(String ino) throws Exception {
		try (Connection conn = DBConnection.getConnection()) {
			AucPro aucPro = (AucPro) productDao.selectAucPro(conn, ino);
			productDao.viewCountUpdate(conn, ino);
			productDao.LikeCountUpdate(conn, ino);
			return aucPro;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// norPro 상품 불러오기
	public NorPro getNorPro(String ino) throws Exception {
		try (Connection conn = DBConnection.getConnection()) {
			NorPro norPro = (NorPro) productDao.selectNorPro(conn, ino);
			productDao.viewCountUpdate(conn, ino);
			productDao.LikeCountUpdate(conn, ino);
			return norPro;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	// 상품 삭제
	public void getAucDel(int delNo) throws SQLException, Exception {
		try (Connection conn = DBConnection.getConnection()) {
			productDao.deleteAucPro(conn, delNo);
		}
	}

	public void getNorDel(int delNo) throws SQLException, Exception {
		try (Connection conn = DBConnection.getConnection()) {
			productDao.deleteNorPro(conn, delNo);
		}
	}

	// 검색
	public List<Product> getSearchPage(String search) throws Exception {
		try (Connection conn = DBConnection.getConnection()) {
			String[] searchArr = search.trim().split("");

			List<Product> searchProduct = productDao.selectSearchProduct(conn, searchArr);
			return searchProduct;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// 카테고리 검색
	public List<Product> getCategoryPage(String categories) throws Exception {
		try (Connection conn = DBConnection.getConnection()) {
			List<Product> searchProduct = productDao.selectCategoryProduct(conn, categories);
			return searchProduct;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public String aucProductModi(AucProRequest aucProductModi, String ino) throws Exception {
		Connection conn = null;
		try {
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false);

			productDao.updateAuc(conn, aucProductModi, ino);
			conn.commit();
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn);
		}
		return null;

	}

	public String norProductModi(NorProRequest norProductModi, String ino) throws Exception {
		Connection conn = null;
		try {
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false);

			productDao.updateNor(conn, norProductModi, ino);
			conn.commit();
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn);
		}
		return null;

	}

	public String auctionPartInsert(String userId, String aucIno, String oPrice) throws Exception {
		Connection conn = null;
		try {
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false);

			productDao.auctionPartInsert(conn, userId, aucIno, oPrice);
			productDao.updateAucPart(conn, aucIno, oPrice);
			conn.commit();
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn);
		}
		return null;
	}


	public String likeCountUpdate(String userId, String ino) throws Exception {
		Connection conn = null;
		try {
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false);
productDao.aucLikeInsert(conn, userId, ino);
productDao.norLikeInsert(conn, userId, ino);
			productDao.LikeCountUpdate(conn, ino);
			conn.commit();
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn);
		}
		return null;
	}
	

}
