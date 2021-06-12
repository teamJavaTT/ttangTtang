package admin.notice.model;

import java.util.Date;

public class Noticecolumn {

	private Integer mNo;
	private String mTit;
	private String mText;
	private Date mDate;
	public Noticecolumn(Integer mNo, String mTit, String mText, Date mDate) {
		this.mNo = mNo;
		this.mTit = mTit;
		this.mText = mText;
		this.mDate = mDate;
	}

	public Integer getMno() {
		return mNo;
	}

	public String getMtit() {
		return mTit;
	}

	public String getMtext() {
		return mText;
	}

	public Date getMdate() {
		return mDate;
	}
}
