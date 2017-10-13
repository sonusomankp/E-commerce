package com.niit.EcomB.DaoImpl;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.EcomB.Dao.ProductDao;
import com.niit.EcomB.Model.Category;
import com.niit.EcomB.Model.Product;
import com.niit.EcomB.Model.Supplier;



@SuppressWarnings("unused")
@Repository("ProductDaoImpl")
public class ProductDaoImpl implements ProductDao{
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	public ProductDaoImpl(SessionFactory sessionfactory)
	{
		this.sessionFactory=sessionfactory;
	}


//	save product
	public void saveProduct(Product product) {
		Session ssn=sessionFactory.openSession();
		Transaction t=ssn.getTransaction();
		t.begin();
		ssn.save(product);
		t.commit();
		ssn.close();
		
	}
	
	
//	get product id
	public ArrayList<Product> getprbyid(int id)
	{
		Session ssn=sessionFactory.openSession();
		Transaction t=ssn.getTransaction();
		t.begin();
		
		Query q = ssn.createQuery("from Product where  c_id= "+id);
		ArrayList<Product> cat = (ArrayList<Product>)q.list();
		t.commit();
		ssn.close();
		return cat;
		
	}
	
	
//	get all products
	
	public ArrayList<Product> getallproducts() {
		Session ssn=sessionFactory.openSession();
		Transaction t=ssn.getTransaction();
		t.begin();
		org.hibernate.Query q= ssn.createQuery("from Product");
	    ArrayList<Product> l=(ArrayList<Product>) q.list();

	    t.commit();
		ssn.close();
		for(Product c:l)
		{
			System.out.println(c);
		}
				return l;

		}
	
	//delete product
	
	public Product deleteProduct(int id) {
		Session ssn=sessionFactory.openSession();
		Transaction t=ssn.getTransaction();
		t.begin();
		
		Product i = (Product) ssn.get(Product.class,id);
		ssn.delete(i);
		
		t.commit();
		ssn.close();
		return i;
			}
	
	
	//update product list	
	
	public void updateProduct(Product p) {
		Session ssn=sessionFactory.openSession();
		Transaction t=ssn.getTransaction();
		t.begin();
		ssn.update(p);
		t.commit();
		ssn.close();
		
	}
	
	
	//get product id	
	
	public Product getprobyid(int id) {
		Session ssn=sessionFactory.openSession();
		Transaction t=ssn.getTransaction();
		t.begin();
		Product i = (Product) ssn.get(Product.class,id);
		
		t.commit();
		ssn.close();
		return i;
			}
}


	
