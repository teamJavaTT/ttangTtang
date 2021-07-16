package org.zerock.domain;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Sellcheck { // 판매내역

	private int iNo;
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
	private int viewCount;
	private Date pDate;
	private Date endTime;
	private String sellCheck;

	

}
