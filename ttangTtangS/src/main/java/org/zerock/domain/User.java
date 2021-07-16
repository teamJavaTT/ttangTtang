package org.zerock.domain;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class User {
	private String userid;
	private String upw;
	private String uname;
	private int memberChk;

	public boolean matchPassword(String inputUpw) {
		System.out.println("mem"+memberChk);
		return upw.equals(inputUpw);
	}
}
