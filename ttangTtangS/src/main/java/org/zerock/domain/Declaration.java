package org.zerock.domain;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Declaration {

	private int num;
	private int dno;
	private String userid;
	private String duid;
	private String dtext;
	private Date ddate;
}
