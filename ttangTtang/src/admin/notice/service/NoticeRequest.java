package admin.notice.service;

import java.util.Map;

import admin.notice.model.Notice;

public class NoticeRequest {
	private Notice notice;

	public NoticeRequest(Notice notice) {
		this.notice = notice;
	}

	public Notice getNotice() {
		return notice;
	}
}
