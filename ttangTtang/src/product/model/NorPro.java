package product.model;

public class NorPro {
	
	private String ino;
	private String userid;
	private String ccode;
	private String iname;
	private String price;
	private String pricetext;
	private String imageface;
	
	public NorPro(String ino,String userid,String ccode,String iname,String price,String pricetext,	String imageface) {
	this.ino = ino;
	this.userid = userid;
	this.ccode = ccode; 
	this.iname = iname;
	this.price = price; 
	this.pricetext = pricetext;
	this.imageface = imageface;
	
	
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
}