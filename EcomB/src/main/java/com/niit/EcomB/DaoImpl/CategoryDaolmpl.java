package com.niit.EcomB.DaoImpl;

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

		}
	
