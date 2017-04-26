package com.niit.shoppingcart.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.dao.MyCartDAO;
import com.niit.shoppingcart.domain.MyCart;
import com.niit.shoppingcart.domain.Product;

@Transactional
@Repository("mycartDAO")
public class MyCartDAOImpl implements MyCartDAO {

	private static Logger log = LoggerFactory.getLogger(MyCartDAOImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public MyCartDAOImpl(SessionFactory sessionFactory)
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

	public List<MyCart> list(String userID) {
		
		return null;
	}

	public MyCart get(String id) {
		
		return null;
	}

	public boolean save(MyCart myCart) {
		
		return false;
	}

	public boolean update(MyCart myCart) {
		
		return false;
	}

	public boolean delete(MyCart myCart) {
		
		return false;
	}

	public Long getTotalAmount(String id) {
		
		return null;
	}

	public MyCart getMyCart(String userID, String productName) {
		
		return null;
	}

	public int getQuantity(String userID, String productName) {
		
		return 0;
	}
	
}
