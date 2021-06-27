package auth.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import auth.dao.MainDao;
import auth.model.Category;
import auth.model.ProductToday;
import auth.model.Product;
import jdbc.DBConnection;

public class MainService {

	private MainDao mainDao = new MainDao();

	public List<Category> getCategory() throws Exception {
		try (Connection conn = DBConnection.getConnection()) {
			List<Category> category = mainDao.selectCategory(conn);
			return category;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public MainPage getMainPage() throws Exception {
		try (Connection conn = DBConnection.getConnection()) {
			List<ProductToday> productToday = mainDao.selectProductToday(conn);
			List<Product> product = mainDao.selectProduct(conn);
			return new MainPage(productToday, product);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void auctionEnd() throws Exception {
		try (Connection conn = DBConnection.getConnection()) {
			List<String> likeProduct = mainDao.auctionEndInoSelect(conn);
			int aucPartCnt = 0;
			if(!likeProduct.isEmpty()) {
				for (int i = 0; i < likeProduct.size(); i++) {
					mainDao.auctionEndUpdate(conn, likeProduct.get(i));
					aucPartCnt = mainDao.auctionEndInoCount(conn, likeProduct.get(i));
					String lText = "";
					if(aucPartCnt == 0) {
						List<String> noMachUserId = mainDao.aucAlimUserIdSelect(conn, likeProduct.get(i));
						lText = noMachUserId.get(1) + " 상품이 기간 내에 경매에 참여한 사람이 없어 종료되었습니다.";
						mainDao.alimInsert(conn, noMachUserId.get(0), lText);
					}else {
						List<String> machAlimUserId = mainDao.aucAlimUserIdSelect(conn, likeProduct.get(i));
						lText = machAlimUserId.get(1) + " 상품이 구매자와 매칭되었습니다.";
						mainDao.alimInsert(conn, machAlimUserId.get(0), lText);
						
						mainDao.auctioConnUpdate(conn, likeProduct.get(i));
						String connUserId = mainDao.aucConnUserIdSelect(conn, likeProduct.get(i));
						lText = machAlimUserId.get(1) + "상품 경매에 매칭되었습니다.";
						mainDao.alimInsert(conn, connUserId, lText);
					}
				}
			}
		}
	}
}
