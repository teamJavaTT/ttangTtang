package auth.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import auth.dao.MainDao;
import auth.model.Article;
import jdbc.DBConnection;

public class MainService {

	private MainDao mainDao = new MainDao();

	public ArticlePage getMainPage() throws Exception {
		try (Connection conn = DBConnection.getConnection()) {
			List<Article> content = mainDao.select(conn);
			return new ArticlePage(content);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
