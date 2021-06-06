package auth.model;

public class Product {

	private String ino;
	private String userid;
	private String cname;
	private String auctioncheck;
	private String uad;
	private String iname;
	private String price;
	private String minprice;
	private String maxprice;
	private String pricetext;
	private String imageface;
	private String redate;

	public Product(String ino, String userid, String cname, String auctioncheck, String uad, String iname, String price, String minprice, String maxprice, String pricetext, String imageface, String redate) {
		this.ino = ino;
		this.userid = userid;
		this.cname = cname;
		this.auctioncheck = auctioncheck;
		this.uad = uad;
		this.iname = iname;
		this.price = price;
		this.minprice = minprice;
		this.maxprice = maxprice;
		this.pricetext = pricetext;
		this.imageface = imageface;
		this.redate = redate;
	}

	public String getIno() {
		return ino;
	}
	public String getUserid() {
		return userid;
	}
	public String getCname() {
		return cname;
	}
	public String getAuctioncheck() {
		return auctioncheck;	
	}
	public String getUad() {
		return uad;
	}
	public String getIname() {
		return iname;
	}
	public String getPrice() {
		return price;
	}
	public String getMinprice() {
		return minprice;
	}
	public String getMaxprice() {
		return maxprice;
	}
	public String getPricetext() {
		return pricetext;
	}
	public String getImageface() {
		return imageface;
	}
	public String getRedate() {
		return redate;
	}
}
