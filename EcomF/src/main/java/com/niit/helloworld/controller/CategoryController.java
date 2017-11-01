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

	
	
	//	category list
	
	@RequestMapping("/admin/listC")
	public ModelAndView listC(@RequestParam("f") String s)
	{
		
		ModelAndView mv = new ModelAndView("listcategory");
		ArrayList<Category> cat=(ArrayList<Category>)cdao.getallcategories();
		mv.addObject("catego",cat);

		System.out.println("list C");
		if(s == "")
		{
			mv.addObject("c","");
		
		}
		else
		{
			mv.addObject("c",s);
		}
		
	
	
		return mv;
	}
	
//	category delete
	
	@RequestMapping("/admin/catdel")
	public String catdelete(@RequestParam("id") int cad) {
		String c ="";
		try
		{
			cdao.deleteCategory(cad);
			c="success";
		}
		catch(Exception e)
		{
			c="can't delete(already in product)";
		}
		return "redirect:/admin/listC?f="+c;
		
		
		
	}
	
	
//	  category update
	
	  @RequestMapping("/admin/catupd")
	 	public ModelAndView catupdate(@RequestParam("id") int cid,@RequestParam("name") String cname ) 
	  {
		
		  Category c=new Category();
		  c.setC_id(cid);
		  c.setCname(cname);
	      cdao.updateCategory(c);
	      
	      
	      ModelAndView mv1 = new ModelAndView("redirect:/admin/listC?f=");
	      return mv1;
	  }
	 		
//	category update page 
	  
	  @RequestMapping("/admin/catu")
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
