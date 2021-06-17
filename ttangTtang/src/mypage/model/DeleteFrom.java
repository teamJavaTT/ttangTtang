package mypage.model;

public class DeleteFrom {

	private String userid;
	private String userpassword;

	public DeleteFrom(String userid, String userpassword) {
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

	public boolean matchPassword(String inputUpw) {
		return userpassword.equals(inputUpw);
	}

	public void changePassword(String newPwd) {
		this.userpassword = newPwd;
	}

}
