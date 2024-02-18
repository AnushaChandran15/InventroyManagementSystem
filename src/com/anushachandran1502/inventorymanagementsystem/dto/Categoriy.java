package com.anushachandran1502.inventorymanagementsystem.dto;

public class Categoriy {
	
	private int id;
	private String categoriy;

	public Categoriy(int id, String categry) {
		this.id=id;
		this.categoriy=categry;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategoriy() {
		return categoriy;
	}
	public void setCategoriy(String categoriy) {
		this.categoriy = categoriy;
	}

}
