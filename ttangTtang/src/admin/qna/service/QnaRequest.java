package admin.qna.service;

import java.util.Map;

import admin.notice.model.Notice;

public class QnaRequest {
	private Notice notice;

	public QnaRequest(Notice notice) {
		this.notice = notice;
	}

	public Notice getnotice() {
		return notice;
	}

}
