package org.zerock.domain;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class UserInfo {

	private int num;
	private String userid;
	private String uemail;
	private String uname;
	private String phone;
	private String sex;
	private Date datetime;
	private int memberchk;
}
