package admin.declaration.service;

import admin.declaration.model.Declarationcolumn;

public class DeclarationData {
	private Declarationcolumn declaration;

	public DeclarationData(Declarationcolumn declaration) {
		this.declaration = declaration;
	}

	public Declarationcolumn getDeclaration() {
		return declaration;
	}

}
