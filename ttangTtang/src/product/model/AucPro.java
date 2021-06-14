package product.model;

public class AucPro {
	
	private String userId;
	private String product_name;
	private String category;
	private String max_price;
	private String min_price;
	private String end_day;
	private String end_time;
	private String description;
	private String imageface;
	
	public AucPro(String userId, String product_name,String category, String max_price, String min_price,String end_day, String end_time, String description,String imageface) {
		this.userId=userId;
		this.product_name=product_name;
		this.category=category;
		this.max_price=max_price;
		this.min_price=min_price;
		this.end_day=end_day;
		this.end_time=end_time;
		this.description=description;
		this.imageface=imageface;
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
	
	public String getMax_price() {
		return max_price;
	}
	public String getMin_price() {
		return min_price;
		}
	public String getEnd_day() {
		return end_day;
	}
	public String getEnd_time() {
		return end_time;
	}
	public String getDescription() {
		return description;
	}
	public String getImageface() {
		return imageface;
	}


}
