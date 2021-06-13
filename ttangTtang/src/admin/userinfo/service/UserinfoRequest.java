package admin.userinfo.service;

import admin.userinfo.model.Userinfo;

public class UserinfoRequest {
	private Userinfo userinfo;

	public UserinfoRequest(Userinfo userinfo) {
		this.userinfo = userinfo;
	}

	public Userinfo getuserinfo() {
		return userinfo;
	}

}
