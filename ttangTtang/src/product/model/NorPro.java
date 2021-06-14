package product.model;

public class NorPro {
	
	private String userId;
	private String product_name;
	private String category;
	private String price;
	private String description;
	
	public NorPro(String userId,String product_name, String category, String price, String end_time, String description) {
		this.userId=userId;
		this.product_name=product_name;
		this.category= category;
		this.price=price;
		this.description=description;
	}


	public String getUserId() {
		return userId;
	}

	public String getProduct_name() {
		return product_name;
	}
	public String getCategory() {
		return category;
	}
	public String getPrice() {
		return price;
	}
	public String getDescription() {
		return description;
	}

}
