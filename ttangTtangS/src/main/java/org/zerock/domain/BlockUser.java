package org.zerock.domain;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class BlockUser { // 차단

	private int bNo;
	private String userId;
	private String bid;
	private String btext;
	private Date bdate;

}
