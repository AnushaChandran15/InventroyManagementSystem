package com.anushachandran1502.inventorymanagementsystem.updateproducts;

import com.anushachandran1502.inventorymanagementsystem.Repository.Repository;

public class UpdateProductViewModel {
	private UpdateProductView updateView;
	private Repository repo;
	public UpdateProductViewModel(UpdateProductView updateProductView) {
		this.updateView=updateProductView;
		this.repo=Repository.getInstance();
	}
	public boolean updatetheStock(String name, String newName, String newCode, int newPrice, int quantity) {
	 		return repo.updateTheProductByDB(name,newName,newCode,newPrice,quantity);

	}

}
