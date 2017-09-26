package com.niit.EcomB.Dao;

import java.util.ArrayList;

import com.niit.EcomB.Model.Category;

public interface CategoryDao {
	void saveCategory(Category c);

	ArrayList<Category> getallcategories();
}
