package org.zerock.domain;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Product {

	private BigDecimal ino;
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
	private String imageside;
	private String imageback;
	private String imageetc;
	private BigDecimal viewcount;
	private BigDecimal likecount;
	private Timestamp pdate;
	private Timestamp endtime;
	private String auctiontime;
	private String sellcheck;

	public Product(BigDecimal ino, String userid, String ccode, String auctioncheck, String uad, String iname, String price, String minprice, String maxprice, String apricenow, String apriceend, String pricetext, String imageface, String imageside, String imageback, String imageetc, BigDecimal viewcount, BigDecimal likecount, Timestamp pdate, Timestamp endtime, String auctiontime, String sellcheck) {
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
		this.imageside = imageside;
		this.imageback = imageback;
		this.imageetc = imageetc;
		this.viewcount = viewcount;
		this.likecount = likecount;
		this.pdate = pdate;
		this.endtime = endtime;
		this.auctiontime = auctiontime;
		this.sellcheck = sellcheck;
	}

}
