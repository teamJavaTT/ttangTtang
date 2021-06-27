package member.model;

public class Alim {

	private String lNo;
	private String userId;
	private String lText;
	private String lDate;
	private String alimChk;

	public Alim(String lNo, String userId, String lText, String lDate, String alimChk) {
		
		this.lNo = lNo;
		this.userId = userId;
		this.lText = lText;
		this.lDate = lDate;
		this.alimChk = alimChk;
	}
	public String getlNo() {
		return lNo;
	}
	public String getUserId() {
		return userId;
	}
	public String getlText() {
		return lText;
	}
	public String getlDate() {
		return lDate;
	}
	public String getAlimChk() {
		return alimChk;
	}	
}
