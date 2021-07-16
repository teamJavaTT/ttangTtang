package org.zerock.domain;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Notice {
	
	private BigDecimal mno;
	private String mtit;
	private String mtext;
	private Timestamp mdate;

	public Notice(BigDecimal mno, String mtit, String mtext, Timestamp mdate) {
		this.mno = mno;
		this.mtit = mtit;
		this.mtext = mtext;
		this.mdate = mdate;
	}

}
