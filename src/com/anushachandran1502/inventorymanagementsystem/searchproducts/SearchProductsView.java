package com.anushachandran1502.inventorymanagementsystem.searchproducts;

import java.util.List;
import java.util.Scanner;

import com.anushachandran1502.inventorymanagementsystem.dto.Product;


public class SearchProductsView {
	private SearchProductsViewModel searchProViewModel;
	public SearchProductsView()
	{
		searchProViewModel=new SearchProductsViewModel(this);
	}
	public void searchProducts()
	{
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the Product Name/Product Code");
		String search=scanner.nextLine();
		System.out.println("Search.....");
	List<Product> searchList=searchProViewModel.getSearchProducts(search);
	if(searchList!=null)
	{
		for(Product product:searchList)
		{
			System.out.println(product);
			System.out.println();
		}
		System.out.println("**********");
	}
	else
	{
		System.out.println("Not found.....");
	}

	}

}
