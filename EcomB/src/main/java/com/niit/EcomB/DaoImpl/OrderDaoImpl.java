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
import com.niit.EcomB.Model.Category;
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
	
		//saving shipping address
	 public void addorder(Order order)
	 {
		 Session ssn=sessionFactory.openSession();
			Transaction t=ssn.getTransaction();
			t.begin();
			ssn.save(order);
			t.commit();
			ssn.close();
		 
	 }
	 
	 //get order by user name
	 public ArrayList<Order> getorderbyusername(String Username) {
		    Session ssn=sessionFactory.openSession();
			Transaction t=ssn.getTransaction();
			t.begin();
			Query q=ssn.createQuery("from Order where USERNAME='"+Username+"'");
			ArrayList<Order> cat=(ArrayList<Order>)q.list();

	        t.commit();
	        ssn.close();
			return cat;
		}
	}