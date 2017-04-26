package com.niit.shoppingcart.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//import com.niit.shoppingcart.config.dao.ProductDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.domain.Product;

@Transactional
@Repository("productDAO")
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public ProductDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
	public List<Product> list() {
		
	return	sessionFactory.getCurrentSession().createQuery("from Product").list();
		
	}

	public boolean save(Product product) {
		try
		{
		sessionFactory.getCurrentSession().save(product);
		return true;
		} catch(Exception e)
		{
			e.printStackTrace(); 
			         
			return false;
		}
		
	}

	public boolean update(Product product) {
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
			
		}
	}

	@Transactional
	public boolean delete(String id) {
		try {
			sessionFactory.getCurrentSession().delete(getProductByID(id));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	public boolean delete(Product product) {
		try {
			sessionFactory.getCurrentSession().delete(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
			
		}
	}

	public Product getProductByID(String id) {
		
	  return (Product) sessionFactory.getCurrentSession().get(Product.class, id);
		
	}

	public Product getProductByName(String name) {
		  
		  return (Product) sessionFactory.getCurrentSession().createQuery("from Product where name = '"+name + "'").uniqueResult();
			
	}

	public boolean validate(Product product) {
		
		return false;
	}

	public boolean validate(String Product, String product2) {
		
		return false;
	}

}
