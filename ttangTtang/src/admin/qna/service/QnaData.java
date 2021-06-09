package admin.qna.service;

import admin.notice.model.Noticecolumn;

public class QnaData {
	private Noticecolumn notice;

	public QnaData(Noticecolumn notice) {
		this.notice = notice;
	}

	public Noticecolumn getNotice() {
		return notice;
	}

}
