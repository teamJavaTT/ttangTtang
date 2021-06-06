package admin.service;

import java.util.Map;

import admin.model.Notice;

public class NoticeRequest {
	private Notice notice;

	public NoticeRequest(Notice notice) {
		this.notice = notice;
	}

	public Notice getnotice() {
		return notice;
	}

}
