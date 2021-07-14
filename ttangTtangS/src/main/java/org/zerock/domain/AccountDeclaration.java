package org.zerock.domain;
import java.math.BigDecimal;
import java.sql.Timestamp;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class AccountDeclaration { //신고

	private BigDecimal dNo;
	private String userId;
	private String duid;
	private String dtext;
	private Timestamp ddate;
	
	
	public AccountDeclaration(BigDecimal dNo, String userId, String duid, String dtext, Timestamp ddate) {
		this.dNo = dNo;
		this.userId = userId;
		this.duid = duid;
		this.dtext = dtext;
		this.ddate = ddate;
	}

}
