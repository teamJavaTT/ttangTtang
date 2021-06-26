package admin.qna.model;

public class Qna {

	private String userId;
	private String qTit;
	private String qText;
	private String qPw;

	public Qna(String userId, String qTit, String qText, String qPw) {
		
		this.userId = userId;
		this.qTit = qTit;
		this.qText = qText;
		this.qPw = qPw;
	}
	
	public String getUserId() {
		return userId;
	}
	public String getQtit() {
		return qTit;
	}

	public String getQtext() {
		return qText;
	}
	public String getQpw() {
		return qPw;
	}
}
