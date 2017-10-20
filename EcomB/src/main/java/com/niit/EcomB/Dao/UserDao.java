package com.niit.EcomB.Dao;
import java.util.ArrayList;

import com.niit.EcomB.Model.User;

public interface UserDao {

	void saveUser(User user);
	public ArrayList<User> getalluserdetails();

}
