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
public class HelloWorldController {
	
	@Autowired
	UserDao udao;
	
	@Autowired
	CategoryDao cdao;
	
	@Autowired
	SupplierDao sdao;
	
	@Autowired
	ProductDao pdao;
	
	
	String message = "Welcome to Spring MVC!";
 
	@RequestMapping("/hello")
	public ModelAndView showMessage()
	{

		System.out.println("in controller");
		ModelAndView mv = new ModelAndView("homepage");
		return mv;
	}
	
	//home page
	@RequestMapping("/")
	public ModelAndView index()
	{
		System.out.println("in controller");
		ModelAndView mv = new ModelAndView("homepage");
		ArrayList<Category> cat=(ArrayList<Category>)cdao.getallcategories();
		System.out.println("hai after retrieve");
		for(Category c:cat)
		{
			System.out.println(c);
		}
		mv.addObject("cate",cat);
		System.out.println("after adding object");
	    return mv;
	}
	
	//login
	@RequestMapping("/in")
	public ModelAndView login()
	{
		ArrayList<Category> cat=(ArrayList<Category>)cdao.getallcategories();
		ModelAndView mv = new ModelAndView("login");
		mv.addObject("cate",cat);
		return mv;
		
	}

	
	//	sign up
	
	@RequestMapping("/signUp")
	public ModelAndView signup()
	{
		ArrayList<Category> cat=(ArrayList<Category>)cdao.getallcategories();
		ModelAndView mv = new ModelAndView("signup");
		mv.addObject("cate",cat);
		return mv;
		
	}
	
	
//	cart
	@RequestMapping("/bas")
	public String bask()
	{
		
		
		return "Basket";
	}

	

  

  

  
  
 		
  
  

  
 		
}

