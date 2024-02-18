package com.anushachandran1502.inventorymanagementsystem.AddProducts;

import java.util.List;

import com.anushachandran1502.inventorymanagementsystem.Repository.Repository;
import com.anushachandran1502.inventorymanagementsystem.dto.Categoriy;
import com.anushachandran1502.inventorymanagementsystem.dto.Product;

public class AddProductsViewModel {
	private AddProductsView addProductsView;
	private Repository repo;
	public AddProductsViewModel(AddProductsView addProductsView) {
		this.addProductsView=addProductsView;
		repo=Repository.getInstance();
	}

	public List<Categoriy> getCategoriys() {
		return repo.getCategoriyByDB();
	}

	public boolean addProduct(int categoriry, Product product) {
		return repo.AddProductToDB(categoriry,product);
	}

}
