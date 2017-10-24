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
public class SupplierController {
	@Autowired
	UserDao udao;
	
	@Autowired
	CategoryDao cdao;
	
	@Autowired
	SupplierDao sdao;
	
	@Autowired
	ProductDao pdao;
	
	
	//list supplier
	@RequestMapping("/admin/listS")
	public ModelAndView listS(@RequestParam("f") String s)
	{

		System.out.println("list S");
		
		ModelAndView mv = new ModelAndView("listsupplier");
		ArrayList<Supplier> cat=(ArrayList<Supplier>)sdao.getallsuppliers();
		mv.addObject("su",cat);
		
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
	
	//delete supplier
	@RequestMapping("/admin/supdel")
	public String supdelete(@RequestParam("id") int sup) {
		String c ="";
		try
		{
			sdao.deleteSupplier(sup);
			c="success";
		}
		catch(Exception e)
		{
			c="can't delete";
		}
		return "redirect:/admin/listS?f="+c;
		
		
		
	}
		
	
	
	//supplier update
	 @RequestMapping("/admin/supupd")
		public ModelAndView supupdate(@RequestParam("id") int sid,@RequestParam("name") String sname,@RequestParam("sad") String sadd ) 
	{
		  System.out.println("in controller sup");
		  System.out.println(sname);
		  Supplier s = new Supplier();
		  
		  s.setS_id(sid);
		  s.setSname(sname);
		  s.setSaddr(sadd);
	      sdao.updateSupplier(s);
	    
	    
	    ModelAndView mv1 = new ModelAndView("redirect:/admin/listS?f=");
	    return mv1;
	}
	  
	 
	 //supplier update page
	  @RequestMapping("/admin/supu")
		public ModelAndView supup(@RequestParam("id") int sid ) 
	{
		  Supplier s=new Supplier();
		  s=sdao.getsupbyid(sid);
		  System.out.println(s);
		  ModelAndView mv1 = new ModelAndView("updatesupplier");
	      mv1.addObject("sup",s);
	      return mv1;
	}
	
	
	
  
}

