package auth.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import auth.dao.MainDao;
import auth.model.AuctionEnd;
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
	
	public MainPage auctionEnd() throws Exception {
		try (Connection conn = DBConnection.getConnection()) {
			List<String> likeProduct = mainDao.auctionEndInoSelect(conn);
			String likeList = "";
			List<AuctionEnd> auctionEnd = new ArrayList<>();
			if(!likeProduct.isEmpty()) {
				for (int i = 0; i < likeProduct.size(); i++) {
					if(i == 0) {
						likeList += likeProduct.get(i);	
					}else {
						likeList += ","+likeProduct.get(i);
					}
				}
				mainDao.auctionEndUpdate(conn, likeList);
				auctionEnd = mainDao.auctionEndInoCount(conn, likeList);
			}
			
			
			String lText = "";
			for (int i = 0; i < auctionEnd.size(); i++) {
				if(((AuctionEnd) auctionEnd.get(i)).getCnt() == 0) {
					lText = "기간 내에 경매에 참여한 사람이 없어 종료되었습니다.";
					String userid = mainDao.aucAlimUserIdSelect(conn, ((AuctionEnd) auctionEnd.get(i)).getIno());
					mainDao.alimInsert(conn, userid, lText);
				}else {
					lText = "경매에 매칭되었습니다.";
					String alimUserId = mainDao.aucAlimUserIdSelect(conn, ((AuctionEnd) auctionEnd.get(i)).getIno());
					mainDao.alimInsert(conn, alimUserId, lText);
					
					mainDao.auctioConnUpdate(conn, ((AuctionEnd) auctionEnd.get(i)).getIno());
					String connUserId = mainDao.aucConnUserIdSelect(conn, ((AuctionEnd) auctionEnd.get(i)).getIno());
					lText = "경매에 매칭되었습니다.";
					mainDao.alimInsert(conn, connUserId, lText);
				}
			}
			
			return null;
		}
	}
}
