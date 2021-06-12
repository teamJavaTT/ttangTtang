package admin.userproduct.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import admin.userproduct.dao.AdminDao;
import admin.userproduct.model.UserProduct;
import admin.userproduct.model.UserProductcolumn;
import jdbc.DBConnection;
import jdbc.JdbcUtil;

public class UserProductService {
	
	private AdminDao adminDao = new AdminDao();
	
	// 글 입력하기
	/*
	 * public Integer userproductwrite(UserProduct writeReq) throws Exception {
	 * Connection conn = null; try { conn = DBConnection.getConnection();
	 * conn.setAutoCommit(false);
	 * 
	 * UserProductcolumn article = toArticle(writeReq); UserProductcolumn
	 * savedArticle = adminDao.insert(conn, article); if (savedArticle == null) {
	 * throw new RuntimeException("fail to insert article"); } conn.commit();
	 * 
	 * return savedArticle.getqno(); } catch (SQLException e) {
	 * JdbcUtil.rollback(conn); throw new RuntimeException(e); } catch
	 * (RuntimeException e) { JdbcUtil.rollback(conn); throw e; } finally {
	 * JdbcUtil.close(conn); } } private UserProductcolumn toArticle(UserProduct
	 * req) { Date now = new Date();
	 * 
	 * return new UserProductcolumn(null, req.getuserid(), req.getqtit(),
	 * req.getqtext(), now); //null에 아이디 추가 }
	 */
	// 글 입력하기 끝
	
	// 글 목록에 읽어오기
	public UserProductPage getUserProductPage(int pageNo) throws Exception {
		int size = 5;
		int startNo = (pageNo - 1) * size + 1;
		int endNo = startNo + 4;
		try (Connection conn = DBConnection.getConnection()) {
			int total = adminDao.selectCount(conn);
			List<UserProductcolumn> userproductcolumn = adminDao.selectUserProduct(conn, startNo, endNo);
			return new UserProductPage(total, pageNo, size, userproductcolumn);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public UserProductData getUserProductRead(int userproductNum) throws Exception {
		try (Connection conn = DBConnection.getConnection()){
			UserProductcolumn userproductcolumn = adminDao.selectById(conn, userproductNum);
			if (userproductcolumn == null) {
				throw new ArticleNotFoundException();
			}
			return new UserProductData(userproductcolumn);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	// 글 목록에 읽어오기 끝

	// 글 삭제
	public void getUserProductDelete(int delNo) throws SQLException, Exception {
		try(Connection conn = DBConnection.getConnection()){
			adminDao.deleteUserProduct(conn, delNo);
		}
	}
	// 글 끝
	
	// 수정
	/*
	 * public UserProductData getUserProductMod(int userproductNum) throws Exception
	 * { try (Connection conn = DBConnection.getConnection()){ UserProductcolumn
	 * userproductcolumn = adminDao.selectById(conn, userproductNum); if
	 * (userproductcolumn == null) { throw new ArticleNotFoundException(); } return
	 * new UserProductData(userproductcolumn); } catch (SQLException e) { throw new
	 * RuntimeException(e); } }
	 * 
	 * public Integer userproductmod(int delNo, UserProduct modReq) throws Exception
	 * { Connection conn = null; try { conn = DBConnection.getConnection();
	 * conn.setAutoCommit(false);
	 * 
	 * UserProductcolumn userproductcolumn = toUserProductMod(delNo, modReq);
	 * UserProductcolumn savedArticle = adminDao.updateUserProduct(conn,
	 * userproductcolumn); if (savedArticle == null) { throw new
	 * RuntimeException("fail to update"); } conn.commit();
	 * 
	 * return savedArticle.getqno(); } catch (SQLException e) {
	 * JdbcUtil.rollback(conn); throw new RuntimeException(e); } catch
	 * (RuntimeException e) { JdbcUtil.rollback(conn); throw e; } finally {
	 * JdbcUtil.close(conn); } }
	 */
	// 수정 끝
	/*
	 * private UserProductcolumn toUserProductMod(int delNo, UserProduct req) { Date
	 * now = new Date(); return new UserProductcolumn(delNo, null, req.getqtit(),
	 * req.getqtext(), now); }
	 */
}
