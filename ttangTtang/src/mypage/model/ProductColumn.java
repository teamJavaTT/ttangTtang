package mypage.model;

public class ProductColumn {

	private String iNo;
	private String userId;
	private String cCode;

	private String auctionCheck;
	private String uad;
	private String iName;
	private String price;
	private String minPrice;
	private String maxPrice;
	private String apriceNow;
	private String apriceEnd;
	private String priceText;
	private String imageFace;
	private String viewCount;
	private String pDate;
	private String endTime;
	private String sellCheck;

	public ProductColumn(String iNo, String userId, String cCode, String auctionCheck, String uad,
			String iName, String price, String minPrice, String maxPrice, String apriceNow, String apriceEnd,
			String priceText, String imageFace, String viewCount, String pDate, String endTime,String sellCheck) {
		this.iNo = iNo;
		this.userId = userId;
		this.cCode = cCode;
		this.auctionCheck = auctionCheck;
		this.uad = uad;
		this.iName = iName;
		this.price = price;
		this.minPrice = minPrice;
		this.maxPrice = maxPrice;
		this.apriceNow = apriceNow;
		this.apriceEnd = apriceEnd;
		this.priceText = priceText;
		this.imageFace = imageFace;
		this.viewCount = viewCount;
		this.pDate = pDate;
		this.endTime = endTime;
		this.sellCheck = sellCheck;
	}

	public String getiNo() {
		return iNo;
	}

	public String getUserId() {
		return userId;
	}

	public String getcCode() {
		return cCode;
	}

	public String getAuctionCheck() {
		return auctionCheck;
	}

	public String getUad() {
		return uad;
	}

	public String getiName() {
		return iName;
	}

	public String getPrice() {
		return price;
	}

	public String getMinPrice() {
		return minPrice;
	}

	public String getmaxPrice() {
		return maxPrice;
	}

	public String getApriceNow() {
		return apriceNow;

	}

	public String getApriceEnd() {
		return apriceEnd;

	}

	public String getPriceText() {
		return priceText;
	}

	public String getImageFace() {
		return imageFace;
	}
	public String getpViewCount() {
		return viewCount;
	}
	public String getpDate() {
		return pDate;
	}

	public String getEndTime() {
		return endTime;
	}
	public String getSellCheck() {
		return sellCheck;
	}
}
