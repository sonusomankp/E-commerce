package com.niit.EcomB.Dao;

import java.util.ArrayList;

import com.niit.EcomB.Model.Order;

public interface OrderDao {
	 public void addorder(Order order);
	 public ArrayList<Order> getorderbyusername(String Username);
	
}
