package com.niit.shoppingcart.testcase;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.domain.Supplier;
import com.niit.shoppingcart.domain.User;

public class SupplierTestCase {

	@Autowired
	private static ApplicationContext context;
	
	@Autowired
	private static Supplier supplier;
	
	@Autowired
	private static SupplierDAO supplierDAO;
	
	@BeforeClass
	public static void initialize() 
	{
		context = new AnnotationConfigApplicationContext();
		((AnnotationConfigApplicationContext) context).scan("com.niit");
		((AbstractApplicationContext) context).refresh();
		
		supplier=(Supplier)context.getBean("supplier");
		supplierDAO=(SupplierDAO)context.getBean("supplierDAO");	
	}
	
	@Test
	public void validateCredentialsTestCase()
	{
		boolean flag = ((UserDAO) supplierDAO).validate("samsung", "samsung");
		assertEquals("validateCredentialsTestCase", true, flag);	
	}
	

}
