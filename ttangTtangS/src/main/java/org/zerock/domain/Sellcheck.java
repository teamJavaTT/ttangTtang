package org.zerock.domain;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Sellcheck { // 판매내역

	private BigDecimal iNo;
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
	private BigDecimal viewCount;
	private Timestamp pDate;
	private Timestamp endTime;
	private String sellCheck;

	public Sellcheck(BigDecimal iNo, String userId, String cCode, String auctionCheck, String uad, String iName,
			String price, String minPrice, String maxPrice, String apriceNow, String apriceEnd, String priceText,
			String imageFace, BigDecimal viewCount, Timestamp pDate, Timestamp endTime, String sellCheck) {
		this.iNo = iNo;
		this.userId = userId;
		this.cCode = cCode;
		this.auctionCheck = auctionCheck;
		this.uad = uad;
		this.iName = iName;
		this.price = price;
		this.minPrice = minPrice;
		this.maxPrice = maxPrice;
		this.apriceNow = apriceNow;
		this.apriceEnd = apriceEnd;
		this.priceText = priceText;
		this.imageFace = imageFace;
		this.viewCount = viewCount;
		this.pDate = pDate;
		this.endTime = endTime;
		this.sellCheck = sellCheck;
	}

}
