package com.anushachandran1502.inventorymanagementsystem.deleteproduct;

import java.util.Scanner;

public class DeleteProductView {
	private DeleteProductViewModel deleteProductViewModel;
	public DeleteProductView()
	{
		deleteProductViewModel=new DeleteProductViewModel(this);
	}

	public void deleteProduct() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter Product Name/Product Code");
		String del=scanner.nextLine();
		if(deleteProductViewModel.deleteProduct(del))
		{
			System.out.println("Deleted...");
		}
		else
		{
			System.out.println("Contect not deleted..");
		}
}
	

}
