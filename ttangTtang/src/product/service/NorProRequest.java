package product.service;

public class NorProRequest {
	private String ino;
	private String userId;
	private String category;
	private String auctioncheck;
	private String uad;
	private String productName;
	private String price;
	private String priceText;
	private String imageFace;

	
	public String getIno() {
		return ino;
	}
	public void setIno(String ino) {
		this.ino = ino;
	}
	
		
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
	
	public String getAuctioncheck() {
		return auctioncheck;
	}
	public void setAuctioncheck(String auctioncheck) {
		this.auctioncheck = auctioncheck;
	}
	
	public String getUad() {
		return uad;
	}
	public void setUad(String uad) {
		this.uad = uad;
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