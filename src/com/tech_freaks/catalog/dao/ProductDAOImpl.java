package com.tech_freaks.catalog.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.tech_freaks.catalog.model.Product;

public class ProductDAOImpl extends AbstractDAO<Product> implements ProductDAO {
	
	
	//private static final Logger logger = LoggerFactory.getLogger(PersonDAOImpl.class);
	@Override
	public List<Product> getAllProducts() {
		Session session = getSession();
        List<Product> productList = session.createQuery("from Product").list();
        return productList;
	}
	
	@Override
	public Product findById(Integer id) {
		return (Product) getSession().get(Product.class, id);
	}
	
	@Override
	public Integer insert(Product product) {
		return persist(product);
	}
	
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
