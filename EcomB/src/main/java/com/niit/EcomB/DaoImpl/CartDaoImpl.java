package com.niit.EcomB.DaoImpl;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.EcomB.Dao.CartDao;
import com.niit.EcomB.Model.Cart;


public class CartDaoImpl {

	@Repository("CartDaoImpl")
	public class CartDaolmpl implements CartDao {
		@Autowired
		SessionFactory sessionFactory;
		@Autowired
		public void CategoryDaoImpl(SessionFactory sessionfactory)
		{
			this.sessionFactory=sessionfactory;
		}	
		
	 public void addcart(Cart cart)
	 {
		 Session ssn=sessionFactory.openSession();
			Transaction t=ssn.getTransaction();
			t.begin();
			ssn.save(cart);
			t.commit();
			ssn.close();
		 
		 
		 
		 
	 }
	}
}
