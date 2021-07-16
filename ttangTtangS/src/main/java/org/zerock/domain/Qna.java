package org.zerock.domain;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Qna {
	
	private BigDecimal qno;
	private String userid;
	private String qtit;
	private String qtext;
	private Timestamp qdate;
	private String patext;
	private String qstext;
	private Timestamp qsdate;
	private String qpw;
	
	public Qna(BigDecimal qno, String userid, String qtit, String qtext, Timestamp qdate, String patext, String qstext, Timestamp qsdate, String qpw) {
		this.qno = qno;
		this.userid = userid;
		this.qtit = qtit;
		this.qtext = qtext;
		this.qdate = qdate;
		this.patext = patext;
		this.qstext = qstext;
		this.qsdate = qsdate;
		this.qpw = qpw;
	}
}
