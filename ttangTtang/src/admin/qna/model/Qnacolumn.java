package admin.qna.model;

import java.util.Date;

public class Qnacolumn {

	private Integer mno;
	private String mtit;
	private String mtext;
	private Date mdate;
	public Qnacolumn(Integer mno, String mtit, String mtext, Date mdate) {
		this.mno = mno;
		this.mtit = mtit;
		this.mtext = mtext;
		this.mdate = mdate;
	}

	public Integer getmno() {
		return mno;
	}

	public String getmtit() {
		return mtit;
	}

	public String getmtext() {
		return mtext;
	}

	public Date getmdate() {
		return mdate;
	}
}
