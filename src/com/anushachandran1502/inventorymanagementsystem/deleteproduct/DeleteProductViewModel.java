package com.anushachandran1502.inventorymanagementsystem.deleteproduct;

import com.anushachandran1502.inventorymanagementsystem.Repository.Repository;

public class DeleteProductViewModel {
	private Repository repo;
	private DeleteProductView delView;
	public DeleteProductViewModel(DeleteProductView deleteProductView) {
		this.delView=deleteProductView;
		repo=Repository.getInstance();
	}
	public boolean deleteProduct(String del) {
		return repo.deleteProductByDB(del);
	}
	

}
