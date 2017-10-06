package com.niit.EcomB.Dao;

import java.util.ArrayList;


import com.niit.EcomB.Model.Supplier;

public interface SupplierDao {
	public void saveSupplier(Supplier supplier);
	public ArrayList<Supplier> getallsuppliers();
	public Supplier getsupbyid(int sup);
	public Supplier deleteSupplier(int id);
}
