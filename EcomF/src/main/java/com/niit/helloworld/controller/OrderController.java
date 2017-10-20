package com.niit.helloworld.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.niit.EcomB.DaoImpl.UserDaoImpl;

import com.niit.EcomB.Dao.CategoryDao;
import com.niit.EcomB.Dao.OrderDao;
import com.niit.EcomB.Dao.ProductDao;
import com.niit.EcomB.Dao.SupplierDao;
import com.niit.EcomB.Dao.UserDao;
import com.niit.EcomB.Model.Cart;
import com.niit.EcomB.Model.Category;
import com.niit.EcomB.Model.Order;
import com.niit.EcomB.Model.Product;
import com.niit.EcomB.Model.Supplier;
import com.niit.EcomB.Model.User;


import com.niit.EcomB.Dao.CartDao;
import com.niit.EcomB.Dao.CategoryDao;
import com.niit.EcomB.Dao.ProductDao;
import com.niit.EcomB.Dao.SupplierDao;
import com.niit.EcomB.Dao.UserDao;


@SuppressWarnings("unused")


@Controller
public class OrderController {

	@Autowired
	UserDao udao;

	@Autowired
	CategoryDao cdao;

	@Autowired
	SupplierDao sdao;

	@Autowired
	ProductDao pdao;
	
	@Autowired
	CartDao crdao;
	
	@Autowired
	OrderDao ordao;
	
	
	@RequestMapping("/order")
	public ModelAndView orders() {
		
		ModelAndView mv1 = new ModelAndView("order1");
		ArrayList<Category> l=(ArrayList<Category>)cdao.getallcategories();
		mv1.addObject("cate",l);
		return mv1;
}
	
	// save order details
		@RequestMapping("/orderadd")
		public ModelAndView up(@RequestParam("name") String uname ,@RequestParam("email") String uemail,@RequestParam("mob") long no,@RequestParam("add") String addr) {
		
			Order o=new Order();
			
			o.setUsername(uname);
			o.setEmail(uemail);
			o.setMobno(no);
			o.setAddress(addr);
			
			ordao.addorder(o);
		    ModelAndView mv1 = new ModelAndView("billing");
			
			return mv1;
		}
		
	
		
}
