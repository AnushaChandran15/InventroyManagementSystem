package com.anushachandran1502.inventorymanagementsystem.adminloginpage;

import java.util.Scanner;

import com.anushachandran1502.inventorymanagementsystem.home.HomeView;

public class AdminLoginView {
	private AdminLoginViewModel viewModel;
	public AdminLoginView() {
		viewModel=new AdminLoginViewModel(this);
	}

	public void start() {
		boolean terminated=true;
		while(terminated)
		{
		System.out.println("-------- Admin--------");
		Scanner scanner=new Scanner(System.in);
		System.out.println("User Name :");
		String name=scanner.nextLine();
		System.out.println("Password :");
		String password=scanner.nextLine();
		boolean isAdmin=viewModel.isValid(name,password);
			//terminated=(isAdmin)?false:true;
			if(isAdmin)
			{
				terminated=false;
				HomeView homeView=new HomeView();
				homeView.adminFeatures();
			}
			else
			{
				terminated=true;
			}
		}
		
	}

	
}
