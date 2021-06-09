package admin.notice.service;

import admin.notice.model.Noticecolumn;

public class NoticeData {
	private Noticecolumn notice;

	public NoticeData(Noticecolumn notice) {
		this.notice = notice;
	}

	public Noticecolumn getNotice() {
		return notice;
	}

}
