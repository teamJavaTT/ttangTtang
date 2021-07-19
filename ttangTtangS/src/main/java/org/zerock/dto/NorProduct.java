package org.zerock.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class NorProduct {
	
	private String ino;
	private String userid;
	private String ccode;
	private String cname;
	private String auctioncheck;
	private String uadNor;
	private String productNameNor;
	private String price;
	private String priceTextNor;
	private String imagefaceNor;
	private String viewcount;
	private String likecount;
	private String sellcheck;
}
