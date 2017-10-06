package com.niit.EcomB.DaoImpl;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.EcomB.Dao.SupplierDao;
import com.niit.EcomB.Model.Category;
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
	
	public ArrayList<Supplier> getallsuppliers() {
		Session ssn=sessionFactory.openSession();
		Transaction t=ssn.getTransaction();
		t.begin();
		org.hibernate.Query q= ssn.createQuery("from Supplier");
	    ArrayList<Supplier> l=(ArrayList<Supplier>) q.list();
        t.commit();
		ssn.close();
		for(Supplier s:l)
		{
			System.out.println(s);
		}
				return l;

		}
	public Supplier getsupbyid(int sup) {
		Session ssn=sessionFactory.openSession();
		Transaction t=ssn.getTransaction();
		t.begin();
		Supplier i = (Supplier) ssn.get(Supplier.class,sup);
		
		t.commit();
		ssn.close();
		return i;
			}
	
	
	public Supplier deleteSupplier(int id) {
		Session ssn=sessionFactory.openSession();
		Transaction t=ssn.getTransaction();
		t.begin();
		
		Supplier i = (Supplier) ssn.get(Supplier.class,id);
		ssn.delete(i);
		
		t.commit();
		ssn.close();
		return i;
			}

}

