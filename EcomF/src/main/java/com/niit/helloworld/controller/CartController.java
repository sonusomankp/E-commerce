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
import com.niit.EcomB.Dao.ProductDao;
import com.niit.EcomB.Dao.SupplierDao;
import com.niit.EcomB.Dao.UserDao;
import com.niit.EcomB.Model.Cart;
import com.niit.EcomB.Model.Category;
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
public class CartController {

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
	
	@RequestMapping("/cart")
	public ModelAndView addcart(@RequestParam("id") int id)
	{ 
		
		 org.springframework.security.core.Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	     String name = auth.getName();
	     Cart cart=new Cart();
		
int count=0,cartid=0;
	ArrayList<Cart> car=new ArrayList<Cart>();
	
	car=crdao.getcartbyusernmae(name);
	for(Cart c:car )
	{
		Product ppp=c.getProduct();
		if(ppp.getId()==id)
		{
			count=1;
			cartid=c.getCartid();
		}
	}
	if(count==1)
	{
		
		Cart c=crdao.getcartbyid(cartid);
		int quantity=c.getQuantity();
		quantity=quantity+1;
		crdao.updatequantity(cartid,quantity);
	}
	else
	{
		cart.setUsername(name);
        cart.setQuantity(1);
		
		
		Product p=new Product();
		p=crdao.getprbyid(id);
		
	  cart.setPrice(p.getPrice());
		
		
		cart.setProduct(p);
		//cart.setStatus("NP");
		
		crdao.addcart(cart);
			
		
	}
		
		
		
		ModelAndView mv1 = new ModelAndView("productlist1");
		Product ll=new Product();
		ll=pdao.getprobyid(id);
		
		mv1.addObject("sup",ll);
		
		
		ArrayList<Category> cat1=(ArrayList<Category>)cdao.getallcategories();
		mv1.addObject("cate",cat1);
		
	
	
		return mv1;
	}
	
	@RequestMapping("/car")
	public ModelAndView car(){
		
		ModelAndView mv1 = new ModelAndView("cart");
		
		
		ArrayList<Category> l=(ArrayList<Category>)cdao.getallcategories();
		mv1.addObject("cate",l);
		
		
				String Username=SecurityContextHolder.getContext().getAuthentication().getName();
				
				ArrayList<Cart> ll=(ArrayList<Cart>)crdao.getcartbyusernmae(Username);
				mv1.addObject("ca",ll);
				
				
				int total=0;
				for(Cart cart:ll)
				{
				int sum=cart.getPrice()*cart.getQuantity();
				total=total+sum;	
				}
				
				mv1.addObject("t",total);
				return mv1;
		
		
	}
	
	//cart delete
	@RequestMapping("/cartdel")
	public ModelAndView cartdelete(@RequestParam("prid") int carid) {
		
		crdao.deleteCart(carid);
		ModelAndView mv1 = new ModelAndView("cart");
		ArrayList<Category> l=(ArrayList<Category>)cdao.getallcategories();
		mv1.addObject("cate",l);
		String Username=SecurityContextHolder.getContext().getAuthentication().getName();
		
		ArrayList<Cart> ll=(ArrayList<Cart>)crdao.getcartbyusernmae(Username);
		mv1.addObject("ca",ll);
		
		int total=0;
		for(Cart cart:ll)
		{
		int sum=cart.getPrice()*cart.getQuantity();
		total=total+sum;	
		}
		
		mv1.addObject("t",total);
		return mv1;
}

}
