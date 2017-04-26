package com.niit.shoppingcart.testcase;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.domain.Category;

import junit.framework.Assert;

public class CategoryTestCase {

    @Autowired
	private static Category category;

	@Autowired
	private static CategoryDAO categoryDAO;
	
	@BeforeClass
	public static void init()
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		category = (Category) context.getBean("category");
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}
	
	@Test
	public void createCategoryTestCase()
	{
		category = new Category();
		category.setId("PQ22442017");
		category.setName("TV Category");
		category.setDescription("This is a Television Category");
		
		boolean flag = categoryDAO.save(category);
		Assert.assertEquals("createCategoryTestCase", true, flag);
	}
	
	@Test
	public void updateCategoryTestCase()
	   {
		   
		   category.setId("AB45632");
		   category.setName("new Category jsjksk das");
		   category.setDescription("This is Mobile category");
		   
		   boolean flag = categoryDAO.update(category);
		   Assert.assertEquals("updateCategoryTestCase", true, flag);
	   }
	
	@Test
	public void deleteCategoryByIDTestCase()
	   {
		   boolean flag = categoryDAO.delete("AB45632");
		   Assert.assertEquals("deleteCategoryByIDTestCase" ,true, flag);
	   }
		
	@Test
	public void deleteCategory()
	{
		category.setId("AB45632");
		boolean flag = categoryDAO.delete(category);
		Assert.assertEquals("deleteCategoryTestCase" ,true, flag);
	}
	
	@Test
	public void getCategoryByIDTestCase()
	   {
		  category = categoryDAO.getCategoryByID("AB45CD632");
		  assertEquals("getCategoryByIDTestCase", null, category);
	   }
	
	@Test
	public void getCategoryByNameTestCase()
	   {
		  category = categoryDAO.getCategoryByName("Laptop Category");
		  assertEquals("getCategoryByNameTestCase", null, category);
	   }
	
	@Test
	 public void getAllCategoriesTestCase()
	   {
		  int recordsFromDAO =  categoryDAO.list().size();
		  assertEquals("getAllCategoriesTestCase",2, recordsFromDAO);
	   }
		  
	}
