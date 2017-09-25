package com.niit.EcomB.DaoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.EcomB.Dao.SupplierDao;
import com.niit.EcomB.Model.Supplier;

@Repository
public class SupplierDaoImpl implements SupplierDao {
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	public void UserDaoImpl(SessionFactory sessionfactory)
	{
		this.sessionFactory=sessionfactory;
	}


	public void saveSupplier(Supplier supplier) {
		Session ssn=sessionFactory.openSession();
		Transaction t=ssn.getTransaction();
		t.begin();
		ssn.save(supplier);
		t.commit();
		ssn.close();
		
	}

}

