package org.zerock.dto;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class AccountDeclarationDTO { // 신고

	
	private String userId;
	private String declId;
	private String dtext;
	

}
