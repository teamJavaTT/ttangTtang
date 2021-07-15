package org.zerock.domain;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class User {

	private String userid;
	private String upw;
	private String uname;
	private BigDecimal memberChk;

	public User(String userid, String upw, String uname, BigDecimal memberChk) {
		this.userid = userid;
		this.upw = upw;
		this.uname = uname;
		this.memberChk = memberChk;
	}
	
	public boolean matchPassword(String inputUpw) {
		return upw.equals(inputUpw);
	}

}
