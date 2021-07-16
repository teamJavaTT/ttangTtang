package org.zerock.domain;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class AccountDeclaration { // 신고

	private int dNo;
	private String userId;
	private String duid;
	private String dtext;
	private Date ddate;

}
