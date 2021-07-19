package org.zerock.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class AucProduct {

	private String userid;
	private String ccode;
	private String cname;
	private String auctioncheck;
	private String uadAuc;
	private String productNameAuc;
	private String price;
	private String minPrice;
	private String maxPrice;
	private String apricenow;
	private String apriceend;
	private String pricetext;
	private String imageface;
	private String endtime;
	private String viewcount;
	private String likecount;
	private String sellcheck;
}


