package product.model;

public class AucPro {
	
	private String ino;
	private String userid;
	private String ccode;
	private String auctioncheck;
	private String uad;
	private String iname;
	private String price;
	private String minprice;
	private String maxprice;
	private String apricenow;
	private String apriceend;
	private String pricetext;
	private String imageface;
	private String endtime;
	private String udate;
	

	public AucPro(String ino, String userid, String ccode, String auctioncheck, String uad, String iname, String price, String minprice, String maxprice, String apricenow, String apriceend,String pricetext, String imageface,String endtime,String udate) {
		this.ino = ino;
		this.userid = userid;
		this.ccode = ccode;
		this.auctioncheck = auctioncheck;
		this.uad = uad;
		this.iname = iname;
		this.price = price;
		this.minprice = minprice;
		this.maxprice = maxprice;
		this.apricenow = apricenow;
		this.apriceend = apriceend;
		this.pricetext = pricetext;
		this.imageface = imageface;
		this.endtime = endtime;
		this.udate = udate;
	}

	public String getIno() {
		return ino;
	}
	public String getUserid() {
		return userid;
	}
	public String getCname() {
		return ccode;
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
	public String getApricenow() {
		return apricenow;
		
	}
	public String getApriceend() {
		return apriceend;
		
	}
	public String getPricetext() {
		return pricetext;
	}
	public String getImageface() {
		return imageface;
	}
	public String getEndtime() {
		return endtime;
	}
	public String Udate() {
		return udate;
	}
}
