package admin.service;

import admin.model.Noticecolumn;

public class NoticeData {
	private Noticecolumn notice;

	public NoticeData(Noticecolumn notice) {
		this.notice = notice;
	}

	public Noticecolumn getNotice() {
		return notice;
	}
}
