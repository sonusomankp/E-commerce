package com.niit.EcomB.Dao;

import java.util.ArrayList;

import com.niit.EcomB.Model.Cart;
import com.niit.EcomB.Model.Product;

public interface CartDao {
	public void addcart(Cart cart);
	public ArrayList<Cart> getcartbyusernmae(String Username);
	public Product getprbyid(int id);
	public Cart getcartbyid(int id);
	public void updatequantity(int cartid, int i);
	public void deleteCart(int id);
	public void updateCart(Cart id);
}
