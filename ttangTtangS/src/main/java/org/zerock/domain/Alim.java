package org.zerock.domain;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Alim {

	private int lNo;
	private String userId;
	private String lText;
	private Date lDate;
	private String alimChk;
}
