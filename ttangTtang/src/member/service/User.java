package member.service;

public class User {

	private String userid;
	private String uname;

	public User(String userid, String uname) {
		this.userid = userid;
		this.uname = uname;
	}

	public String getUserid() {
		return userid;
	}

	public String getUname() {
		return uname;
	}

}
