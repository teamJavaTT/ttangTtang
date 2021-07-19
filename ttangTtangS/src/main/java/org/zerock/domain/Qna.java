package org.zerock.domain;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Qna {
	private int num;
	private int qno;
	private String userid;
	private String qtit;
	private String qtext;
	private Date qdate;
	private String patext;
	private String qstext;
	private Date qsdate;
	private String qpw;
	
}
