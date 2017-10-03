package com.niit.EcomB.DaoImpl;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.EcomB.Dao.CategoryDao;
import com.niit.EcomB.Model.Category;

		@Repository("CategoryDaoImpl")
		public class CategoryDaolmpl implements CategoryDao {
			@Autowired
			SessionFactory sessionFactory;
			@Autowired
			public void CategoryDaoImpl(SessionFactory sessionfactory)
			{
				this.sessionFactory=sessionfactory;
			}	
			public void saveCategory(Category c) {
				Session ssn=sessionFactory.openSession();
				Transaction t=ssn.getTransaction();
				t.begin();
				ssn.save(c);
				t.commit();
				ssn.close();
				
			}
			
public ArrayList<Category> getallcategories() {
		Session ssn=sessionFactory.openSession();
		Transaction t=ssn.getTransaction();
		t.begin();
		org.hibernate.Query q= ssn.createQuery("from Category");
	    ArrayList<Category> l=(ArrayList<Category>) q.list();
        t.commit();
		ssn.close();
		for(Category c:l)
		{
			System.out.println(c);
		}
				return l;

		}
public Category getcatbyid(int cat) {
	Session ssn=sessionFactory.openSession();
	Transaction t=ssn.getTransaction();
	t.begin();
	Category i = (Category) ssn.get(Category.class,cat);
	
	t.commit();
	ssn.close();
	return i;
		}
		}
	
