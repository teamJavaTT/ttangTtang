package product.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import auth.model.ProductToday;
import auth.service.MainPage;
import auth.model.Product;
import jdbc.DBConnection;
import product.dao.SearchDao;
import product.model.SearchProduct;

public class SearchService {

	private SearchDao searchDao = new SearchDao();
	
	public List<Product> getSearchPage(String search) throws Exception {
		try (Connection conn = DBConnection.getConnection()) {
			List<Product> searchProduct = searchDao.selectSearchProduct(conn, search);
			return searchProduct;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	

}
