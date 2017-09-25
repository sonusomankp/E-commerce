package com.niit.EcomB.DaoImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.niit.EcomB.Model.User;
import com.niit.EcomB.Dao.UserDao;
	@Repository("UserDaoImpl")
	public class UserDaoImpl implements UserDao {
		@Autowired
		SessionFactory sessionFactory;
		@Autowired
		public UserDaoImpl(SessionFactory sessionfactory)
		{
			this.sessionFactory=sessionfactory;
		}

	
		public void saveUser(User user) {
			Session ssn=sessionFactory.openSession();
			Transaction t=ssn.getTransaction();
			t.begin();
			ssn.save(user);
			t.commit();
			ssn.close();
			
		}

	}
