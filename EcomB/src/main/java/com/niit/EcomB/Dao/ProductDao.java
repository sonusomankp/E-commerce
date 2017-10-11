package com.niit.EcomB.Dao;
import java.util.ArrayList;
import java.util.List;
import com.niit.EcomB.Model.Product;




@SuppressWarnings("unused")
public interface ProductDao {
	public void saveProduct(Product product);
	public ArrayList<Product> getprbyid(int id);
	public ArrayList<Product> getallproducts();
	public Product deleteProduct(int id);
	public void updateProduct(Product p);
	public Product getprobyid(int id);
	
}
