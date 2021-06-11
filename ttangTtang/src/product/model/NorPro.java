package product.model;

public class NorPro {
	
	private String product_name;
	private String category;
	private String price;
	private String description;
	
	public NorPro(String product_name, String category, String price, String end_time, String description) {
	
		this.product_name=product_name;
		this.category= category;
		this.price=price;
		this.description=description;
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
