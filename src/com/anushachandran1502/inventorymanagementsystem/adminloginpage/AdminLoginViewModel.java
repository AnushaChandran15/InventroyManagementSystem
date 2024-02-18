package com.anushachandran1502.inventorymanagementsystem.adminloginpage;

import com.anushachandran1502.inventorymanagementsystem.Repository.Repository;

public class AdminLoginViewModel {
	private AdminLoginView view;
	private Repository repository;
	public AdminLoginViewModel(AdminLoginView adminLoginView) {
		this.view=adminLoginView;
		this.repository=Repository.getInstance();
	}

	public AdminLoginViewModel() {
	}

	public boolean isValid(String name, String password) {
		return repository.isValidAdmin(name,password);
	}

}
