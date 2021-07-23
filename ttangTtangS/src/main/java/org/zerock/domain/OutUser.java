package org.zerock.domain;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class OutUser {

	private int num;
	private int sno;
	private String userid;
	private String stext;
	private Date sdate;
	private Date scdate;
}
