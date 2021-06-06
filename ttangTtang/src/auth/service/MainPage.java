package auth.service;

import java.util.List;

import auth.model.Category;
import auth.model.Product;

public class MainPage {

	private List<Category> category;
	private List<Product> product;

	public MainPage(List<Category> category, List<Product> product) {
		this.category = category;
		this.product = product;
	}
	public List<Category> getCategory() {
		return category;
	}
	public List<Product> getProduct() {
		return product;
	}
}
