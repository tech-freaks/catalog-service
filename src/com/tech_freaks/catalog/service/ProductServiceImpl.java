package com.tech_freaks.catalog.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.tech_freaks.catalog.dao.ProductDAO;
import com.tech_freaks.catalog.model.Product;

public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDAO productDAO;
	
	public void setProductDao(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}

	@Override
	@Transactional
	public List<Product> listProducts() {
		
		return productDAO.getAllProducts();
	}

	@Override
	@Transactional
	public Product getProduct(Integer id) {
		return productDAO.findById(id);
	}
	
	@Override
	@Transactional
	public Integer createProduct(Product product) {
		return productDAO.insert(product);
	}
	
	@Transactional
	public boolean removeProduct(Integer id) {
		return productDAO.remove(id);
	}
	
	@Transactional
	public void updateProduct(Product product) {
		productDAO.update(product);
	}
}
