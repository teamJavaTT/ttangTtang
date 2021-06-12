package admin.notice.model;

public class Notice {

	private String mTit;
	private String mText;

	public Notice(String mTit, String mText) {

		this.mTit = mTit;
		this.mText = mText;
	}

	public String getMtit() {
		return mTit;
	}

	public String getMtext() {
		return mText;
	}

}
