package mypage.model;

public class DeleteFrome {

	private String userid;
	private String userpassword;
	
	
	public DeleteFrome(String userid, String userpassword) {
		this.userid = userid;
		this.userpassword = userpassword;
		
	}


	public String getUserid() {
		return userid;
	}


	public void setUserid(String userid) {
		this.userid = userid;
	}


	public String getUserpassword() {
		return userpassword;
	}


	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}



	
}
