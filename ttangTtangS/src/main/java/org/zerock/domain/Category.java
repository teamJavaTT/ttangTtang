package org.zerock.domain;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Category {
	private String ccode;
	private String cname;
	private String maincategory;
	private String middlecategory;
}
