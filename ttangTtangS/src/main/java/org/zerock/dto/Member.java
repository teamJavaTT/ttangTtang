package org.zerock.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Member {

	private String userid;
	private String upw;
	private String uemail;
	private String uname;
	private String phone;
	private String sex;
	private String address1;
	private String address2;
	private String address3;

}
