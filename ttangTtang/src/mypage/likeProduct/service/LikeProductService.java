package mypage.likeProduct.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import auth.model.Product;
import jdbc.DBConnection;
import mypage.likeProduct.dao.LikeProductDao;

public class LikeProductService {

	private LikeProductDao likeProductDao = new LikeProductDao();

	public int likeProductUser(String userId, String ino) throws SQLException, Exception {
		try (Connection conn = DBConnection.getConnection()) {
			int iNo = likeProductDao.likeProductUser(conn, userId, ino);
			return iNo;
		}
	}

	public List<Product> likeProduct(String userId) throws SQLException, Exception {
		try (Connection conn = DBConnection.getConnection()) {

			List<String> likeProduct = likeProductDao.likeProductSelect(conn, userId);
			String test = "";
			for (int i = 0; i < likeProduct.size(); i++) {
				if(i == 0) {
					test += likeProduct.get(i);	
				}else {
					test += ","+likeProduct.get(i);
				}
			}
			
			List<Product> likeProductDetail = likeProductDao.likeDetailSelect(conn, test);
			return likeProductDetail;
		}
	}

}