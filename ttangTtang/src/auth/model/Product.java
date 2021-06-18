package auth.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Product {

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

	public Product(String ino, String userid, String ccode, String auctioncheck, String uad, String iname, String price, String minprice, String maxprice, String apricenow, String apriceend,String pricetext, String imageface, Date endtime) {
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
		
		if(endtime != null) {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
			String strDate = simpleDateFormat.format(endtime);
			this.endtime = strDate;
		}else {
			this.endtime = null;
		}
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
}
