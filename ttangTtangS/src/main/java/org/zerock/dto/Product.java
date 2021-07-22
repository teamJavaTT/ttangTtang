package org.zerock.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Product {
	
	private String ino;
	private String userid;
	private String ccode;
	private String cname;
	private String auctioncheck;
	private String uad;
	private String iname;
	private String price;
	private String minPrice;
	private String maxPrice;
	private String apricenow;
	private String apriceend;
	private String priceText;
	private String imageface;
	private String endDay;
	private String endTime;
	private int totalTime;
	private String viewcount;
	private String likecount;
	private String sellcheck;
	}


