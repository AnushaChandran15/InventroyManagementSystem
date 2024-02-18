package com.anushachandran1502.inventorymanagementsystem.updateproducts;

import java.util.Scanner;

public class UpdateProductView {
	private UpdateProductViewModel updateViewModel;
	public UpdateProductView()
	{
		updateViewModel=new UpdateProductViewModel(this);
		
	}
	public void update() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Which Product you want to Update?");
		System.out.println("Enter the Product Name/Product Code");
		String name=scanner.nextLine();
		System.out.println("Enter the new Product name");
		String newName=scanner.nextLine();
		System.out.println("Enter the new Product code");
		String newCode=scanner.nextLine();
		System.out.println("Enter the new Price");
		int newPrice=scanner.nextInt();
		System.out.println("Enter the new Quantity");
		int quantity=scanner.nextInt();
		if(updateViewModel.updatetheStock(name,newName,newCode,newPrice,quantity))
			System.out.println("Updated....");
		else
		{
			System.out.println("Not Updated...");
		}
	}
	

}
