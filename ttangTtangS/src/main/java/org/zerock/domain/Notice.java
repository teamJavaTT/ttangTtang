package org.zerock.domain;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Notice {

	private int num;
	private int mno;
	private String mtit;
	private String mtext;
	private Date mdate;
}
