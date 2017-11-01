package com.niit.EcomB.DaoImpl;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.Query;


import com.niit.EcomB.Dao.CartDao;
import com.niit.EcomB.Model.Cart;
import com.niit.EcomB.Model.Product;



	@Repository("CartDaoImpl")
	public class CartDaolmpl implements CartDao {
		
		@Autowired
		SessionFactory sessionFactory;
		
		@Autowired
		public void CartDaoImpl(SessionFactory sessionfactory)
		{
			this.sessionFactory=sessionfactory;
		}	
		
		//save cart
	 public void addcart(Cart cart)
	 {
		 Session ssn=sessionFactory.openSession();
			Transaction t=ssn.getTransaction();
			t.begin();
			ssn.save(cart);
			t.commit();
			ssn.close();
		 
	 }
	 
	 //get cart using user name
	 public ArrayList<Cart> getcartbyusernmae(String Username) {
		    Session ssn=sessionFactory.openSession();
			Transaction t=ssn.getTransaction();
			t.begin();
			Query q=ssn.createQuery("from Cart where USERNAME='"+Username+"'");
			ArrayList<Cart> cat=(ArrayList<Cart>)q.list();

	        t.commit();
	        ssn.close();
			return cat;
		}
	 
	 //get product by id

		public Product getprbyid(int id) {
			
		Session ssn=sessionFactory.openSession();
		Transaction t=ssn.getTransaction();
		t.begin();
		Product l = (Product) ssn.get(Product.class,id);
		
	    t.commit();
	    ssn.close();
	    return l;
	}
		
		
	//get cart by cart id
		public Cart getcartbyid(int id) {
			Session ssn=sessionFactory.openSession();
			Transaction t=ssn.getTransaction();
			t.begin();
			Cart l = (Cart) ssn.get(Cart.class, id);
			
					
			
		    t.commit();
		    ssn.close();
		    return l;
			
		}
		
		//update quantity
		public void updatequantity(int cartid, int i) {
			Session ssn=sessionFactory.openSession();
			Transaction t=ssn.getTransaction();
			t.begin();
			
			Query qry1 = ssn.createQuery("update Cart  set quantity="+i+"where CARTID="+cartid);
		    qry1.executeUpdate();
					         				
			
		    t.commit();
		    ssn.close();
			
		}
		
		//delete cart
		public void deleteCart(int id){
			Session ssn=sessionFactory.openSession();
			Transaction t=ssn.getTransaction();
			t.begin();
			Cart p = (Cart) ssn.get(Cart.class, id);
			ssn.delete(p);
	        t.commit();
	        ssn.close();
		}
		
		
		//cart update
		public void updateCart(Cart id){
			Session ssn=sessionFactory.openSession();
			Transaction t=ssn.getTransaction();
			t.begin();
			ssn.update(id);
	        t.commit();
	        ssn.close();
		}
	}
