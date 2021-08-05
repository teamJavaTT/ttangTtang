package org.zerock.domain;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Alim {

	private int lno;
	private String userid;
	private String ltext;
	private Date ldate;
	private String alimchk;
	private int ino;
	private String imageface1;
}
