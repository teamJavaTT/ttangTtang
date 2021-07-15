package org.zerock.domain;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
public class User {

	private String userid;
	private String upw;
	private BigDecimal memberChk;

	public User(String userid, String upw, BigDecimal memberChk) {
		this.userid = userid;
		this.upw = upw;
		this.memberChk = memberChk;
	}
	
	public boolean matchPassword(String inputUpw) {
		return upw.equals(inputUpw);
	}

}
