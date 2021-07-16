package org.zerock.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class QnaColumn {

	private int qno;
	private String userid;
	private String qtit;
	private String qtext;
	private String qpw;
}
