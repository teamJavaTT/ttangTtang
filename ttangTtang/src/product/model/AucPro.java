package product.model;

public class AucPro {
	
	private String product_name;
	private String max_price;
	private String min_price;
	private String end_time;
	private String description;
	
	public AucPro(String product_name, String max_price, String min_price, String end_time, String description) {
	
		this.product_name=product_name;
		this.max_price=max_price;
		this.min_price=min_price;
		this.end_time=end_time;
		this.description=description;
	}

	public String getProduct_name() {
		return product_name;
	}
	public String getMax_price() {
		return max_price;
	}
	public String getMin_price() {
		return min_price;
	}
	public String getEnd_time() {
		return end_time;
	}
	public String getDescription() {
		return description;
	}

}
