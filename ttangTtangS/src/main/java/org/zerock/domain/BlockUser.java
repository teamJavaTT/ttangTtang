package org.zerock.domain;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class BlockUser { // 차단

	private BigDecimal bNo;
	private String userId;
	private String bid;
	private String btext;
	private Timestamp bdate;

}
