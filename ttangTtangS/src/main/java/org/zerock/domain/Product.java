package org.zerock.domain;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Product {
	private int ino;
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
	private String imageface1;
	private String imageface2;
	private String imageface3;
	private String imageface4;
	private int viewcount;
	private int likecount;
	private Date pdate;
	private Date endtime;
	private String auctiontime;
	private String sellcheck;
}
