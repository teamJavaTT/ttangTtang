package admin.qna.model;

public class Qna {

	private String userId;
	private String qTit;
	private String qText;

	public Qna(String userId, String qTit, String qText) {
		
		this.userId = userId;
		this.qTit = qTit;
		this.qText = qText;
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

}
