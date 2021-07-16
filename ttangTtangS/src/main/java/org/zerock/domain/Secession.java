package org.zerock.domain;
import java.math.BigDecimal;
import java.sql.Timestamp;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Secession { //회원탈퇴

	private BigDecimal sNo;
	private String userId;
	private String stext;
	private Timestamp sdate;
	private Timestamp bcdate;
	
	
	

}
