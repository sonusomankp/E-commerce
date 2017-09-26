package com.niit.EcomB.DaoImpl;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.EcomB.Dao.ProductDao;
import com.niit.EcomB.Model.Product;



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


	public void saveProduct(Product product) {
		Session ssn=sessionFactory.openSession();
		Transaction t=ssn.getTransaction();
		t.begin();
		ssn.save(product);
		t.commit();
		ssn.close();
		
	}
}


	
