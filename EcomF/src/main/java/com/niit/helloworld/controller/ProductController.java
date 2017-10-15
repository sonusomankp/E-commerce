package com.niit.helloworld.controller;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.EcomB.DaoImpl.UserDaoImpl;
import com.niit.EcomB.Dao.CategoryDao;
import com.niit.EcomB.Dao.ProductDao;
import com.niit.EcomB.Dao.SupplierDao;
import com.niit.EcomB.Dao.UserDao;
import com.niit.EcomB.Model.Category;
import com.niit.EcomB.Model.Product;
import com.niit.EcomB.Model.Supplier;
import com.niit.EcomB.Model.User;


 
@SuppressWarnings("unused")
@Controller
public class ProductController {
	
	@Autowired
	UserDao udao;
	
	@Autowired
	CategoryDao cdao;
	
	@Autowired
	SupplierDao sdao;
	
	@Autowired
	ProductDao pdao;
	
	
	//product list
	@RequestMapping("/listP")
	public ModelAndView listP()
	{

		System.out.println("list P");
		
		ModelAndView mv = new ModelAndView("listproduct");
		ArrayList<Product> cat=(ArrayList<Product>)pdao.getallproducts();
		mv.addObject("pr",cat);
	
		return mv;
	}
	
	//product delete
	 @RequestMapping("/prodel")
		public ModelAndView prodelete(@RequestParam("id") int prod) {
			System.out.println("in contoller"+prod);
			ArrayList<Product> s = new ArrayList<Product>();
			pdao.deleteProduct(prod);
			
			ArrayList<Product> cat=(ArrayList<Product>)pdao.getallproducts();
			
			
			
			ModelAndView mv1 = new ModelAndView("listproduct");
			mv1.addObject("pros",s);
			mv1.addObject("pr",cat);
			
			
			
			return mv1;

	}
	 
	 
	 //product update
	 @RequestMapping("/proupd")
		public ModelAndView proupdate(@RequestParam("id") int id,@RequestParam("name") String name ,@RequestParam("sdes") String shor,@RequestParam("pric") int price,@RequestParam("stoc") int stock,@RequestParam("ca") int categ,@RequestParam("su") int suppli ) 
	{
		  System.out.println("in controller pro");
		  System.out.println(name);
		  Product p = new Product();
		  p.setId(id);
		  p.setName(name);
		  p.setShortDescrption(shor);
		  p.setPrice(price);
		  p.setStock(stock);
		  
		  Category ca = new Category();
			ca = cdao.getcatbyid(categ);
			p.setCategory(ca);
			
			Supplier sa = new Supplier();
			sa = sdao.getsupbyid(suppli);
			p.setSupplier(sa);
			
		pdao.updateProduct(p);
		
	    ModelAndView mv1 = new ModelAndView("updateproduct");
	    return mv1;
	}
	  
	 //product update page
	  @RequestMapping("/prou")
		public ModelAndView proup(@RequestParam("id") int id ) 
	{
		  Product p=new Product();
		  p=pdao.getprobyid(id);
		  System.out.println("prou");
		  
	   
		  ArrayList<Category> cat=(ArrayList<Category>)cdao.getallcategories();
		  ArrayList<Supplier> ss= (ArrayList<Supplier>)sdao.getallsuppliers();
		  
		    
			
			ModelAndView mv1 = new ModelAndView("updateproduct");
		  
		  mv1.addObject("sup",p);
		  mv1.addObject("catego",cat);
		  mv1.addObject("cat",ss);
	      return mv1;
	}
	  
	  //product update page
	  @RequestMapping("/prou1")
		public ModelAndView proup1(@RequestParam("id") int id ) 
	{
		  Product p=new Product();
		  p=pdao.getprobyid(id);
		  System.out.println("prou");
		  
	   
		  ArrayList<Category> cat=(ArrayList<Category>)cdao.getallcategories();
		  ArrayList<Supplier> ss= (ArrayList<Supplier>)sdao.getallsuppliers();
		  
		    
			
		  ModelAndView mv1 = new ModelAndView("productlist1");
		  
		  mv1.addObject("sup",p);
		  mv1.addObject("catego",cat);
		  mv1.addObject("cat",ss);
	      return mv1;
	}


}
