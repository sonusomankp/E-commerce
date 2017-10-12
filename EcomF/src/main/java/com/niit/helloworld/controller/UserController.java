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
public class UserController {
	@Autowired
	UserDao udao;
	
	@Autowired
	CategoryDao cdao;
	
	@Autowired
	SupplierDao sdao;
	
	@Autowired
	ProductDao pdao;
	
	
	@RequestMapping("/up")
	public ModelAndView up(@RequestParam("name") String uname ,@RequestParam("email") String uemail,@RequestParam("pwd") String pass,@RequestParam("no") long no) {
		System.out.println("in controller");
		
		User p=new User();
		
	    p.setUname(uname);
	    p.setUemail(uemail);
	    p.setUpass(pass);
	    p.setUmob(no);
	    p.setRole("USER ROLE");
		udao.saveUser(p);
	
		ModelAndView mv1 = new ModelAndView("signup");
		
		return mv1;
	}
	
}
