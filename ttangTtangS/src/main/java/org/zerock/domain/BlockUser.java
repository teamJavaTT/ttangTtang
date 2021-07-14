package org.zerock.domain;
import java.math.BigDecimal;
import java.sql.Timestamp;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class BlockUser { //Â÷´Ü

	private BigDecimal bNo;
	private String userId;
	private String bid;
	private String btext;
	private Timestamp bdate;
	
	
	public BlockUser(BigDecimal bNo, String userId, String bid, String btext, Timestamp bdate) {
		this.bNo = bNo;
		this.userId = userId;
		this.bid = bid;
		this.btext = btext;
		this.bdate = bdate;
	}

}
