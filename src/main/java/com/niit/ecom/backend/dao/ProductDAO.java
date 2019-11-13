package com.niit.ecom.backend.dao;

import java.util.ArrayList;
import java.util.List;

import com.niit.ecom.backend.model.Product;

public interface ProductDAO {
	List<Product> productsList = new ArrayList<Product>();
	public boolean addProduct(Product product);
	public boolean updateProduct(Product product);
	public boolean displayProduct(int productId);
	public List<Product> displayAllProducts();
	public boolean deleteProduct(Product product);
}
