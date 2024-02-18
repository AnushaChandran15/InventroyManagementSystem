package com.anushachandran1502.inventorymanagementsystem.AddProducts;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.anushachandran1502.inventorymanagementsystem.dto.Categoriy;
import com.anushachandran1502.inventorymanagementsystem.dto.Product;

public class AddProductsView {
	private AddProductsViewModel addViewModel;
	private List<Categoriy> list=new ArrayList<Categoriy>();

	public AddProductsView()
	{
		addViewModel=new AddProductsViewModel(this);
		
	}

	public void addProducts() {
		boolean terminated=true;
		do {
			Scanner scanner=new Scanner(System.in);

			System.out.println("------Categoriys------");
			list=addViewModel.getCategoriys();
			showCategories(list);
			System.out.println("Chioce the  Categoriy ");
			int categoriry=scanner.nextInt();
			scanner.next();
			System.out.println("Enter the Product Name");
			String pName=scanner.nextLine();
			String pCode=createProductCode(pName,categoriry);
			scanner.next();
			System.out.println("Enter the Quantity");
			int quantity=scanner.nextInt();
			System.out.println("Enter the Price");
			int price=scanner.nextInt();
			Product product=new Product(pName,pCode,quantity,price);
			if(addViewModel.addProduct(categoriry,product))
				System.out.println("Add successfully.....");
			else
				System.out.println("Not Added Try Again...");
			boolean inner=true;
			do
			{
			System.out.println("1.Add Next \n 2.Finish");
			int n=scanner.nextInt();
			
			switch(n)
			{
				case 1:
					terminated=true;
					inner=false;
					break;
				case 2:
					terminated=false;
					inner=false;
					break;
				default:
					System.out.println("Invalid...");
					terminated=true;
					inner=true;
			}
		}
			while(inner);
			
		}
		while(terminated);
	}

	private void showCategories(List<Categoriy> list) {
		for(Categoriy categoriy:list)
		{
			System.out.println(categoriy.getId() +" . "+ categoriy.getCategoriy());
		}
	}

	private  String createProductCode(String productNmae, int categoriry) {
		Random random = new Random();
         int codeNum=random.nextInt(9000) + 1000;
         Categoriy cateName=list.get(categoriry);
         String codeStr=cateName.getCategoriy();
		return ""+codeStr.charAt(0)+codeStr.charAt(codeStr.length()-1)+codeNum;
		
	}
	

}
