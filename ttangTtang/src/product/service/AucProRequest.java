package product.service;

public class AucProRequest {
	private String ino;
	private String userId;
	private String category;
	private String auctioncheck;
	private String productName;
	private String minPrice;
	private String maxPrice;
	private String priceText;
	private String imageFace;
	private String auctionTime;

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

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(String minPrice) {
		this.minPrice = minPrice;
	}

	public String getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(String maxPrice) {
		this.maxPrice = maxPrice;
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

	public String getAuctionTime() {
		return auctionTime;
	}

	public void setAuctionTime(String auctionTime) {
		this.auctionTime = auctionTime;
	}

}
