package product.model;

public class AucPro {
	
	private String product_name;
	private String category;
	private int max_price;
	private int min_price;
	private String end_time;
	private String description;
	private String imageface;
	
	public AucPro(String product_name,String category, int max_price, int min_price, String end_time, String description,String imageface) {
	
		this.product_name=product_name;
		this.category=category;
		this.max_price=max_price;
		this.min_price=min_price;
		this.end_time=end_time;
		this.description=description;
		this.imageface=imageface;
	}

	public String getProduct_name() {
		return product_name;
	}
	public String getCategory() {
		return category;
	}
	
	public int getMax_price() {
		return max_price;
	}
	public int getMin_price() {
		return min_price;
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
