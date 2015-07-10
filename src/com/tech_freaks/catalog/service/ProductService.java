package com.tech_freaks.catalog.service;

import java.util.List;

import com.tech_freaks.catalog.model.Product;

public interface ProductService {

	public List<Product> listProducts();
	
	public Product getProduct(Integer id);
	
	public Integer createProduct(Product product);
	
	public boolean removeProduct(Integer id);
	
	public void updateProduct(Product product);
}
