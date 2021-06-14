package admin.blacklist.service;

import admin.blacklist.model.Blacklistcolumn;

public class BlacklistData {
	private Blacklistcolumn blacklist;

	public BlacklistData(Blacklistcolumn blacklist) {
		this.blacklist = blacklist;
	}

	public Blacklistcolumn getBlacklist() {
		return blacklist;
	}

}
