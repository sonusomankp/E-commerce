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
	public ModelAndView addca(@RequestParam("id") int id)
	{ 
		ModelAndView mv1 = new ModelAndView("redirect:/user/cart?id="+id);
		return mv1;
		
	}
	
	@RequestMapping("/car")
	public ModelAndView carth()
	{ 
		ModelAndView mv1 = new ModelAndView("redirect:/user/car");
		return mv1;
		
	}
	
	
	//add cart
	@RequestMapping("/user/cart")
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
	
	//stock
	
	Product p = new Product();
	p=pdao.getprobyid(id);
	p.setStock(p.getStock()-1);
	pdao.updateProduct(p);
	
	
	
		ModelAndView mv1 = new ModelAndView("productlist1");
		Product ll=new Product();
		ll=pdao.getprobyid(id);
		
		mv1.addObject("sup",ll);
		
		
		ArrayList<Category> cat1=(ArrayList<Category>)cdao.getallcategories();
		mv1.addObject("cate",cat1);
		
	
	
		return mv1;
	}
	
	
	
	
	
	
	
	
	//cart header
	@RequestMapping("/user/car")
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
	@RequestMapping("/user/cartdel")
	public ModelAndView cartdelete(@RequestParam("prid") int carid) {
		
		//stock
		Cart ss = crdao.getcartbyid(carid);
		Product p = pdao.getprobyid(ss.getProduct().getId());
		p.setStock(p.getStock()+(ss.getQuantity()));
		pdao.updateProduct(p);
		
		
		
		crdao.deleteCart(carid);
		ModelAndView mv1 = new ModelAndView("redirect:/user/car");
		
//		ArrayList<Category> l=(ArrayList<Category>)cdao.getallcategories();
//		mv1.addObject("cate",l);
//		String Username=SecurityContextHolder.getContext().getAuthentication().getName();
//		
//		ArrayList<Cart> ll=(ArrayList<Cart>)crdao.getcartbyusernmae(Username);
//		mv1.addObject("ca",ll);
//		
//		int total=0;
//		for(Cart cart:ll)
//		{
//		int sum=cart.getPrice()*cart.getQuantity();
//		total=total+sum;	
//		}
//		
//		mv1.addObject("t",total);
		return mv1;
}
	
	@RequestMapping("/cartdel")
	public ModelAndView cartd(@RequestParam("cartid") int cartid){
	ModelAndView mv1 = new ModelAndView("redirect:/user/cartup?carid"+cartid);
	return mv1;
			
	}
	
	
	
	@RequestMapping("/cartup")
	public ModelAndView cartu(@RequestParam("cartid") int cartid){
	ModelAndView mv1 = new ModelAndView("redirect:/user/cartup?cartid"+cartid);
	return mv1;
			
	}
	
	//redirecting to cart update page
	@RequestMapping("/user/cartup")
		public ModelAndView cartupdate(@RequestParam("cartid") int cartid) {
			
			ModelAndView mv1 = new ModelAndView("updatecart");
			ArrayList<Category> l=(ArrayList<Category>)cdao.getallcategories();
			mv1.addObject("cate",l);
			Cart c= new Cart();
			c=crdao.getcartbyid(cartid);
			mv1.addObject("ca",c);
			return mv1;
	}

	

	//cart update 
		@RequestMapping("/user/cartupdate")
		public ModelAndView cartupda(@RequestParam("cid") int cartid, @RequestParam("quantity") int quantity,@RequestParam("proid") int pid) {
			System.out.println(cartid);
			ModelAndView mv1 = new ModelAndView("redirect:/user/car");
			
			
			//stock
			Cart ss = crdao.getcartbyid(cartid);
			Product p = pdao.getprobyid(pid);
			p.setStock(p.getStock()-(quantity-ss.getQuantity()));
			pdao.updateProduct(p);
			
					
			ArrayList<Category> l=(ArrayList<Category>)cdao.getallcategories();
			mv1.addObject("cate",l);
		    Cart c= new Cart();
			String Username=SecurityContextHolder.getContext().getAuthentication().getName();
			c.setUsername(Username);
			c.setQuantity(quantity);
			crdao.updatequantity(cartid,quantity);
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
		
		
		
		
		
		//buy
		@RequestMapping("/buy")
		public ModelAndView buyn(@RequestParam("id") int id)
		{
			ModelAndView mv1 = new ModelAndView("redirect:/user/buy?id="+id);
			return mv1;
		}
		
		@RequestMapping("/user/buy")
		public ModelAndView buynow(@RequestParam("id") int id)
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
		
		//stock
		
		Product p = new Product();
		p=pdao.getprobyid(id);
		p.setStock(p.getStock()-1);
		pdao.updateProduct(p);
		
		
	        ModelAndView mv1 = new ModelAndView("redirect:/car");
			Product ll=new Product();
			ll=pdao.getprobyid(id);
			
			mv1.addObject("sup",ll);
			
			
			ArrayList<Category> cat1=(ArrayList<Category>)cdao.getallcategories();
			mv1.addObject("cate",cat1);
			
		
		
			return mv1;
		}
		
		
		
		

}
