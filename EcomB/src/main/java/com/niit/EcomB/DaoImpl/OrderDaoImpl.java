package com.niit.EcomB.DaoImpl;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.Query;


import com.niit.EcomB.Dao.CartDao;
import com.niit.EcomB.Dao.OrderDao;
import com.niit.EcomB.Model.Cart;
import com.niit.EcomB.Model.Order;
import com.niit.EcomB.Model.Product;



	@SuppressWarnings("unused")
	@Repository("OrderDaoImpl")
	
	public class OrderDaoImpl implements OrderDao {
		
		@Autowired
		SessionFactory sessionFactory;
		
		@Autowired
		public void CartDaoImpl(SessionFactory sessionfactory)
		{
			this.sessionFactory=sessionfactory;
		}	
		
	 public void addorder(Order order)
	 {
		 Session ssn=sessionFactory.openSession();
			Transaction t=ssn.getTransaction();
			t.begin();
			ssn.save(order);
			t.commit();
			ssn.close();
		 
	 }
	}