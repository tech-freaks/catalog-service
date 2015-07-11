package com.tech_freaks.catalog.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.tech_freaks.catalog.model.Product;

public class ProductDAOImpl extends AbstractDAO<Product> implements ProductDAO {
	
	
	/**
	 * Fetches all the product from the PRODUCT table
	 */
	@Override
	public List<Product> getAllProducts() {
		Session session = getSession();
        List<Product> productList = session.createQuery("from Product").list();
        return productList;
	}
	
	/**
	 * Fetches product based on the primary key productId
	 */
	@Override
	public Product findById(Integer id) {
		return (Product) getSession().get(Product.class, id);
	}
	
	/**
	 * Inserts a new record in the product table.
	 */
	@Override
	public Integer insert(Product product) {
		return persist(product);
	}
	
	/**
	 * Loads the product using the primary key and then removes it from the database.
	 */
	@Override
	public boolean remove(Integer id)  {
		boolean deleted = false;
		Product delProduct = findById(id);
		if(delProduct!=null) {
			delete(delProduct);
			deleted = true;
		} 
		return deleted;
	}
	
	

}
