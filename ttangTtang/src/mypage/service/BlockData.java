package mypage.service;

import mypage.model.DeclarationColumn;

public class BlockData {
	private DeclarationColumn blockDeclaration;

	public BlockData(DeclarationColumn blockDeclaration) {
		this.blockDeclaration = blockDeclaration;
	}

	public DeclarationColumn getProduct() {
		return blockDeclaration;
	}

}
