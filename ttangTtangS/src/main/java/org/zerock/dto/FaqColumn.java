package org.zerock.dto;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class FaqColumn {

	private int fno;
	private String ftit;
	private String ftext;
	private Date fdate;
}
