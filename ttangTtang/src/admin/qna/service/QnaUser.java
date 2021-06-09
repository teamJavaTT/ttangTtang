package admin.qna.service;

public class QnaUser {
	private String mno;
	private String mtit;
	private String mtext;
	private String mdate;

	public QnaUser(String mno, String mtit, String mtext, String mdate) {
		this.mno = mno;
		this.mtit = mtit;
		this.mtext = mtext;
		this.mdate = mdate;
	}

	public String getmno() {
		return mno;
	}

	public String getmtit() {
		return mtit;
	}

	public String getmtext() {
		return mtext;
	}

	public String getmdate() {
		return mdate;
	}
}
