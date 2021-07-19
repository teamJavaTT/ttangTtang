package org.zerock.domain;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Criteria {
	private int page;

	private int pageStart;
	private int pageEnd;

	public Criteria() {
		this.page = 1;
		this.pageStart = (page * 10) - 9;
		this.pageEnd = page * 10;
	}

	public void setPage(int page) {
		if (page <= 0) {
			this.page = 1;
			return;
		}

		this.page = page;
		this.pageStart = (page * 10) - 9;
		this.pageEnd = page * 10;
	}
	
}