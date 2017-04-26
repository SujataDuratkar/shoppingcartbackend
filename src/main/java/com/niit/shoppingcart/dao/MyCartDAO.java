package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.domain.Category;
import com.niit.shoppingcart.domain.MyCart;

public interface MyCartDAO {
	
public List<MyCart> list(String userID);

    public MyCart get(String id);
	
	public boolean save(MyCart myCart);
	
	public boolean update(MyCart myCart);
	
	public boolean delete(MyCart myCart);
	
	
	public Long getTotalAmount(String id);
	
	public MyCart getMyCart(String userID, String productName);
	
	public int getQuantity(String userID, String productName);
	

}
