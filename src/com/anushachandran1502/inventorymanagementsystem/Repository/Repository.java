package com.anushachandran1502.inventorymanagementsystem.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import com.anushachandran1502.inventorymanagementsystem.dto.*;
public class Repository {
	static Repository repository;
	static Connection connection;
	PreparedStatement preparedStatement;
	private List<Categoriy> categoriys=new ArrayList<>();
	private List<Product> products=new ArrayList<>();

	public List<Categoriy> getCategoriys() {
		return categoriys;
	}
	public void setCategoriys(List<Categoriy> categoriys) {
		this.categoriys = categoriys;
	}
	private Repository()
	{
		 String url = "jdbc:mysql://localhost:3306/InventoryManagement";
		 String userName = "root";
		 String passWord = "root";
		 try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				 this.connection = DriverManager.getConnection(url, userName, passWord);
		 }
		 catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static Repository getInstance()
	{
		if(repository==null)
		{
			repository=new Repository();
		}
		return repository;
	}
	public boolean isValidAdmin(String name, String password) {
		String query="Select * from Admin Where admin=? And password=?";
		 try {
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2,password);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next())
			{
				return true;
			}
			else
			{
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public List<Categoriy> getCategoriyByDB() {
		String query = "SELECT category_id, category FROM categoriy WHERE active_status = 1";
		Statement statement;
		ResultSet resultSet = null;
		try {
			statement = connection.createStatement();
			resultSet=statement.executeQuery(query);
			while(resultSet.next())
			{
				categoriys.add(new Categoriy(resultSet.getInt("category_id"),resultSet.getString("category")));
			}


		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categoriys;
		
	}
	public List<Product> getSearchProductsDB(String search) {
		String query = "SELECT * FROM products WHERE LOWER(product_name) LIKE '%"+search.toLowerCase()+"%' OR product_code  LIKE '%"+search+"%'";
		Statement statement;
		ResultSet rs;
		try {
			statement = connection.createStatement();
			 rs = statement.executeQuery(query);
			 while(rs.next())
				{
					products.add(new Product(rs.getString("product_name"),rs.getString("product_code"),rs.getInt("price"),rs.getInt("quantity")));
				}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return products;
	}
	public boolean deleteProductByDB(String del) {
		String query="Delete from products where product_name=? or product_code=?";
        PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(query);
			 preparedStatement.setString(1, del);
		        preparedStatement.setString(2, del);
		        int rowsAffected = preparedStatement.executeUpdate();
		        if(rowsAffected>0)
		        {
		        	return true;
		        }
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean updateTheProductByDB(String name, String newName, String newCode, int newPrice, int quantity) {
	    String query = "UPDATE products SET product_name = ?, product_code = ?, price=?, quantity=? WHERE name = ?";
	    PreparedStatement ps ;
	    try {
	    ps= connection.prepareStatement(query);
	        ps.setString(1, newName);
	        ps.setString(2, newCode);
	        ps.setInt(3, newPrice);
	        ps.setInt(4, quantity);
	        ps.setString(5,name);

	        int rowsAffected = ps.executeUpdate();

	        return rowsAffected > 0;
	    }
	    catch (SQLException e) {
			e.printStackTrace();
		}
	
	return false;
}
	public boolean AddProductToDB(int categoriry, Product product) {
		 String query = "INSERT INTO products (product_name,product_code,quantity,price,categorie) VALUES (?,?,?,?,?)";
		 int rowsAffected=0;
	        PreparedStatement preparedStatement;
			try {
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, product.getProductName());
		        preparedStatement.setString(2, product.getProductCode());
		        preparedStatement.setInt(3, product.getQuantity());
		        preparedStatement.setInt(4, product.getPrice());
		        preparedStatement.setInt(5, categoriry);
		         rowsAffected = preparedStatement.executeUpdate();


			} catch (SQLException e) {
				e.printStackTrace();
			}
	        
		return (rowsAffected>0)?true:false;
	}
}