package mypage.model;

public class BlockColumn {

	private String bNo;
	private String userId;
	private String bid;
	private String btext;
	private String bdate;

	public BlockColumn(String bNo, String userId, String bid, String btext, String bdate) {
		this.bNo = bNo;
		this.userId = userId;
		this.bid = bid;
		this.btext = btext;
		this.bdate = bdate;

	}

	public String getbNo() {
		return bNo;
	}

	public void setbNo(String bNo) {
		this.bNo = bNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getBid() {
		return bid;
	}

	public void setBid(String bid) {
		this.bid = bid;
	}

	public String getBtext() {
		return btext;
	}

	public void setBtext(String btext) {
		this.btext = btext;
	}

	public String getBdate() {
		return bdate;
	}

	public void setBdate(String bdate) {
		this.bdate = bdate;
	}
}
