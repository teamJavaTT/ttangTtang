package product.service;

public class NorProRequest {
	private String userId;
	private String category;
	private String productName;
	private String price;
	private String priceText;
	private String imageFace;
	
	
		
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getPriceText() {
		return priceText;
	}
	public void setPriceText(String priceText) {
		this.priceText = priceText;
	}
	public String getImageFace() {
		return imageFace;
	}
	public void setImageFace(String imageFace) {
		this.imageFace = imageFace;
	}
}