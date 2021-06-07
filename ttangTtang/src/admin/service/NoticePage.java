package admin.service;

import java.util.List;

import admin.model.Notice;
import admin.model.Noticecolumn;

public class NoticePage {

	private List<Noticecolumn> notice;

	public NoticePage(List<Noticecolumn> notice) {
		this.notice = notice;
	}
	public List<Noticecolumn> getNotice() {
		return notice;
	}
}