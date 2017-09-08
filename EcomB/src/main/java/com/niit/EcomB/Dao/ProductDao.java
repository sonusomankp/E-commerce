package com.niit.EcomB.Dao;
import java.util.List;
import com.niit.EcomB.Model.Product;



public interface ProductDao {

	List<Product> getAllProducts();
	
	Product getProductById(int id);
	
	void updateProductById(Product product);

}
