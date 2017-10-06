package com.niit.EcomB.Dao;

import java.util.ArrayList;

import com.niit.EcomB.Model.Category;

public interface CategoryDao {
	public void saveCategory(Category c);
    public ArrayList<Category> getallcategories();;
    public Category getcatbyid(int cat);
    public Category deleteCategory(int id);
}
