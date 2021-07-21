package org.zerock.domain;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Faq {

	private int num;
	private int fno;
	private String ftit;
	private String ftext;
	private Date fdate;
}
