package admin.userinfo.service;

import admin.userinfo.model.Userinfocolumn;

public class UserinfoData {
	private Userinfocolumn userinfo;

	public UserinfoData(Userinfocolumn userinfo) {
		this.userinfo = userinfo;
	}

	public Userinfocolumn getUserinfo() {
		return userinfo;
	}

}
