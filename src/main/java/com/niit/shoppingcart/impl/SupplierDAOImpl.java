package com.niit.shoppingcart.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.domain.Category;
import com.niit.shoppingcart.domain.Supplier;

@Repository("supplierDAO")
@Transactional
public class SupplierDAOImpl implements SupplierDAO {
	
@Autowired
private SessionFactory sessionFactory;
	
	public SupplierDAOImpl(SessionFactory sessionFactory)
	{
	this.sessionFactory = sessionFactory;
	}
	
	private Session getSession()
	{
		return  sessionFactory.getCurrentSession();
	}
	
	public List<Supplier> list() {
	return	getSession().createQuery("from Supplier").list();
	}
	
	public Supplier getSupplier(String id) {
	return  (Supplier)getSession().get(Supplier.class, id);
	}
	
	public boolean save(Supplier supplier) {
		try{
			getSession().save(supplier);
			return true;
		}catch	(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean update(Supplier supplier) {
		try{
			getSession().update(supplier);
			return true;
		}catch	(Exception e) {
			e.printStackTrace();
		return false;
	}
	}
	
	@Transactional
	public boolean delete(String id) {
		try {
			getSession().delete(getSupplierByID(id));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	public boolean delete(Supplier supplier) {
		try {
			getSession().delete(supplier);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}	
		}
	
	public Supplier getSupplierByID(String id) {
		
		  return (Supplier) getSession().get(Supplier.class, id);
			
		}

		public Supplier getSupplierByName(String name) {
			  
			  return (Supplier) getSession().createQuery("from Supplier where name = '"+name + "'").uniqueResult();
				
		}
	
	public boolean validate(String id, String password) {
		String hql="from User where id='"+id+"' and password = '" + password + "'";
	if (getSession().createQuery(hql).uniqueResult() == null)
	{	
		return false;
	}
	return true;
	}

}
