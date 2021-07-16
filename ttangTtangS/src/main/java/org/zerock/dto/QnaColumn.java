package org.zerock.dto;


import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class QnaColumn {

	private BigDecimal qno;
	private String userid;
	private String qtit;
	private String qtext;
	private String qpw;
}
