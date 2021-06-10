package auth.service;

import java.sql.Connection;
import java.sql.SQLException;
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
	

}
