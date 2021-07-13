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

	public Category(String ccode, String cname, String maincategory, String middlecategory) {
		this.ccode = ccode;
		this.cname = cname;
		this.maincategory = maincategory;
		this.middlecategory = middlecategory;
	}

}
