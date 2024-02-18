package com.anushachandran1502.inventorymanagementsystem.home;

import java.util.Scanner;

import com.anushachandran1502.inventorymanagementsystem.AddProducts.AddProductsView;
import com.anushachandran1502.inventorymanagementsystem.deleteproduct.DeleteProductView;
import com.anushachandran1502.inventorymanagementsystem.searchproducts.SearchProductsView;
import com.anushachandran1502.inventorymanagementsystem.updateproducts.UpdateProductView;

public class HomeView {

	public void adminFeatures() {
		boolean terminated=false;
		do {
		
			System.out.println("1.Add Products \n 2.Search Products \n 3.Update \n 4.Delete products\n 0.Exit");
			Scanner scanner=new Scanner(System.in);
			System.out.println("Enter your choice");
			int choice=scanner.nextInt();
			switch(choice)
			{
				case 1:
					AddProductsView addProductsView=new AddProductsView();
					addProductsView.addProducts();
					break;
				case 2:
					SearchProductsView searchProView=new SearchProductsView();
					searchProView.searchProducts();
					break;
				case 3:
					UpdateProductView updateView=new UpdateProductView();
					updateView.update();
					break;
				case 4 :
					DeleteProductView deleteProView=new DeleteProductView();
					deleteProView.deleteProduct();
					break;
					
					
					
			}
		}
		while(terminated);
		
	}

}
