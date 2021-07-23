package org.zerock.domain;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class BlackList {

	private int num;
	private int bno;
	private String userid;
	private String bid;
	private String btext;
	private Date bdate;
}
