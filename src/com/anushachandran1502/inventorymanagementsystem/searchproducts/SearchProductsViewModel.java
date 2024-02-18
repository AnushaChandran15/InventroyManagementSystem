package com.anushachandran1502.inventorymanagementsystem.searchproducts;

import java.util.List;

import com.anushachandran1502.inventorymanagementsystem.Repository.Repository;
import com.anushachandran1502.inventorymanagementsystem.dto.Product;

public class SearchProductsViewModel {
	private SearchProductsView searchProView;
	private Repository repo;
	public SearchProductsViewModel(SearchProductsView searchProductsView) {
		this.searchProView=searchProductsView;
		this.repo=Repository.getInstance();
	}
	public List<Product> getSearchProducts(String search) {
		return repo.getSearchProductsDB(search);
	}

}
