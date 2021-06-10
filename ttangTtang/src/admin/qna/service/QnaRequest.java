package admin.qna.service;

import admin.qna.model.Qna;

public class QnaRequest {
	private Qna qna;

	public QnaRequest(Qna qna) {
		this.qna = qna;
	}

	public Qna getqna() {
		return qna;
	}

}
