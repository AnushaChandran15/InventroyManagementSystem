package com.anushachandran1502.inventorymanagementsystem.dto;
import java.util.*;
public class Product {
		private String productName;
		private String productCode;
		private int price;
		private int quantity;

		public Product(String productName, String code, int price, int quantity) {
			this.productName=productName;
			this.productCode=code;
			this.price=price;
			this.quantity=quantity;
		}
		public Product() {
		}
		public String getProductName() {
			return productName;
		}
		public void setProductName(String productName) {
			this.productName = productName;
		}
		public String getProductCode() {
			return productCode;
		}
		public void setProductCode(String productCode) {
			this.productCode = productCode;
		}
		public int getPrice() {
			return price;
		}
		public void setPrice(int price) {
			this.price = price;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		
		public String toString()
		{
			String product="Product Name : "+ productName +"\n Product Code : "+ productCode +
					"\n Price : "+price +" \n Quantity : "+ quantity;
			return product;
		}
}
