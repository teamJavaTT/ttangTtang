package admin.outuser.service;

import admin.outuser.model.OutUsercolumn;

public class OutUserData {
	private OutUsercolumn outuser;

	public OutUserData(OutUsercolumn outuser) {
		this.outuser = outuser;
	}

	public OutUsercolumn getOutUser() {
		return outuser;
	}

}
