package admin.service;

import java.util.List;

import admin.model.Notice;

public class NoticePage {

	private List<Notice> notice;

	public NoticePage(List<Notice> notice) {
		this.notice = notice;
	}
	public List<Notice> getNotice() {
		return notice;
	}
}