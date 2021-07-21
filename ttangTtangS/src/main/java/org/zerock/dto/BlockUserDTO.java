package org.zerock.dto;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class BlockUserDTO { // 차단

	private String userId;
	private String blockid2;
	private String btext;

}
