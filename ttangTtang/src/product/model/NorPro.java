package product.model;

public class NorPro {
	
	private String ino;
	private String userid;
	private String ccode;
	private String cname;
	private String auctioncheck;
	private String uad;
	private String iname;
	private String price;
	private String pricetext;
	private String imageface;
	private String viewcount;
	private String likecount;
	
	public NorPro(String ino,String userid,String ccode,String cname,String auctioncheck,String uad,String iname, String price,String pricetext,String imageface,String viewcount,String likecount) {
	this.ino = ino;
	this.userid = userid;
	this.ccode = ccode; 
	this.cname = cname;
	this.auctioncheck = auctioncheck;
	this.uad = uad;
	this.iname = iname;
	this.price = price; 
	this.pricetext = pricetext;
	this.imageface = imageface;
	this.viewcount = viewcount;
	this.likecount = likecount;
	
	
	}
	public String getIno() {
		return ino;
	}
	public String getUserid() {
		return userid;
	}
	public String getCcode() {
		return ccode;
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
	public String getPricetext() {
		return pricetext;
	}
	public String getImageface() {
		return imageface;
	}
	public String getViewcount() {
		return viewcount;
	}
	public String getLikecount() {
		return likecount;
	}
}
