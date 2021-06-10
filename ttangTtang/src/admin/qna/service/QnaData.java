package admin.qna.service;

import admin.qna.model.Qnacolumn;

public class QnaData {
	private Qnacolumn qna;

	public QnaData(Qnacolumn qna) {
		this.qna = qna;
	}

	public Qnacolumn getQna() {
		return qna;
	}

}
