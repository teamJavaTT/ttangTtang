package org.zerock.domain;
import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Secession { //회원탈퇴

	private int sNo;
	private String userId;
	private String stext;
	private Date sdate;
	private Date bcdate;
	
	
	

}
