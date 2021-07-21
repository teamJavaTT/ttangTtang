package org.zerock.dto;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class NoticeColumn {

	private int mno;
	private String mtit;
	private String mtext;
	private Date mdate;
}
