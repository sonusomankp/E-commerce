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
public class CategoryController {
	
	@Autowired
	UserDao udao;
	
	@Autowired
	CategoryDao cdao;
	
	@Autowired
	SupplierDao sdao;
	
	@Autowired
	ProductDao pdao;
	
	@RequestMapping("/listC")
	public ModelAndView listC()
	{

		System.out.println("list C");
		
		ModelAndView mv = new ModelAndView("listcategory");
		ArrayList<Category> cat=(ArrayList<Category>)cdao.getallcategories();
		mv.addObject("catego",cat);
	
		return mv;
	}
	
	@RequestMapping("/catdel")
	public ModelAndView catdelete(@RequestParam("id") int cad) {
		System.out.println("in contoller"+cad);
		ArrayList<Category> c = new ArrayList<Category>();
		cdao.deleteCategory(cad);
		
		ArrayList<Category> cat=(ArrayList<Category>)cdao.getallcategories();
		
		
		
		ModelAndView mv1 = new ModelAndView("listcategory");
		mv1.addObject("pros",c);
		mv1.addObject("catego",cat);
		
		
		
		return mv1;
		
	}
	
	
	  
	  @RequestMapping("/catupd")
	 	public ModelAndView catupdate(@RequestParam("id") int cid,@RequestParam("name") String cname ) 
	  {
		  System.out.println("in controller");
		  System.out.println(cname);
		  Category c=new Category();
		  c.setC_id(cid);
		  c.setCname(cname);
	      cdao.updateCategory(c);
	      
	      
	      ModelAndView mv1 = new ModelAndView("updatecategory");
	      return mv1;
	  }
	 		
	  
	  @RequestMapping("/catu")
	 	public ModelAndView catup(@RequestParam("id") int cid ) 
	  {
		  Category p=new Category();
		  p=cdao.getcatbyid(cid);
		  System.out.println(p);
		  ModelAndView mv1 = new ModelAndView("updatecategory");
	      mv1.addObject("cat",p);
	      return mv1;
	  }
	  
  
}
