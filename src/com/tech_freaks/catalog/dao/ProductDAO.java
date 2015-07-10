package com.tech_freaks.catalog.dao;

import java.util.List;

import com.tech_freaks.catalog.model.Product;

public interface ProductDAO {

	public List<Product> getAllProducts();
	
	public Product findById(Integer id);
	
	public Integer insert(Product product);
	
	public boolean remove(Integer id);
	
	public void update(Product product);
}
