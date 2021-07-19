package org.zerock.domain;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class User {
	
	private String userid;
	private String upw;
	private String uemail;
	private String uname;
	private String phone;
	private String sex;
	private String address1;
	private String address2;
	private String address3;
	private int memberChk;

	public boolean matchPassword(String inputUpw) {
		System.out.println("mem"+memberChk);
		return upw.equals(inputUpw);
	}
}
