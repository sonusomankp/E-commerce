package com.niit.EcomB.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.niit.EcomB.Model.Product;




public class ProductDaoImpl implements ProductDao{
	
	@PersistenceContext	
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")

	public List<Product> getAllProducts() {
		
		String hql = "FROM Products as products ORDER BY products.id";
		return (List<Product>) entityManager.createQuery(hql).getResultList();
		
	}

	
	public Product getProductById(int id) {
		Product product= entityManager.find(Product.class, 1);
		return product;
	}

	
	public void updateProductById(Product product) {
		entityManager.merge(product);
		
	}

}
