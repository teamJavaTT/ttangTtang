package org.zerock.domain;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class ProductToday {
	private BigDecimal num;
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
	private String imageface1;
	private String imageface2;
	private String imageface3;
	private String imageface4;
	private BigDecimal viewcount;
	private BigDecimal likecount;
	private Timestamp pdate;
	private Timestamp endtime;
	private String auctiontime;
	private String sellcheck;

}
