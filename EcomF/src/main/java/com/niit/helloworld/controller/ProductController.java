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
	@RequestMapping("/admin/listP")
	public ModelAndView listP(@RequestParam("f") String s)
	{

		System.out.println("list P");
		
		ModelAndView mv = new ModelAndView("listproduct");
		ArrayList<Product> cat=(ArrayList<Product>)pdao.getallproducts();
		mv.addObject("pr",cat);
		
	
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
	
	//product delete
	 @RequestMapping("/admin/prodel")
		public String prodelete(@RequestParam("id") int prod) {
		
		 String c ="";
			try
			{
				pdao.deleteProduct(prod);
				c="success";
			}
			catch(Exception e)
			{
				c="can't delete(already in cart)";
			}
			return "redirect:/admin/listP?f="+c;

	}
	 
	 
	 //product update
	 @RequestMapping("/admin/proupd")
		public ModelAndView proupdate(@RequestParam("id") int id,@RequestParam("name") String name ,@RequestParam("sdes") String shor,@RequestParam("pric") int price,@RequestParam("stoc") int stock,@RequestParam("ca") int categ,@RequestParam("su") int suppli,@RequestParam("img") MultipartFile file ) 
	{
		 
		
		
		  Product p =pdao.getprobyid(id);
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
			
		if(file.getOriginalFilename()!="")
		{
			 String img=file.getOriginalFilename();
			 p.setImg(img);
		
			/* String filepath = request.getSession().getServletContext().getRealPath("/") + "resources/product/" + file.getOriginalFilename();
			*/
		    String filepath ="C:/Users/SONU/workspace/EcomF/src/main/webapp/resources/proimages/" + file.getOriginalFilename();
			System.out.println("File Path : "+filepath);
			System.out.println(filepath);
			try {
				byte imagebyte[] = file.getBytes();
				BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream(filepath));
				fos.write(imagebyte);
				fos.close();
				} catch (IOException e) {
				e.printStackTrace();
				} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
			
		}
			
			
			
			
		pdao.updateProduct(p);
		
	    ModelAndView mv1 = new ModelAndView("redirect:/admin/listP?f=");
	    return mv1;
	}
	  
	 //display product
	 
	  @RequestMapping("/admin/prou")
		public ModelAndView proup(@RequestParam("id") int id ) 
	{
		  Product p=new Product();
		  p=pdao.getprobyid(id);
		  
		  
	   
		  ArrayList<Category> cat=(ArrayList<Category>)cdao.getallcategories();
		  ArrayList<Supplier> ss= (ArrayList<Supplier>)sdao.getallsuppliers();
		  
		    
			
			ModelAndView mv1 = new ModelAndView("updateproduct");
		  
		  mv1.addObject("sup",p);
		  mv1.addObject("catego",cat);
		  mv1.addObject("cat",ss);
	      return mv1;
	}
	  
	  //product display
	  
	  @RequestMapping("/prou1")
		public ModelAndView proup1(@RequestParam("id") int id ) 
	{
		  Product p=new Product();
		  p=pdao.getprobyid(id);
		  
		  
	   
		  ArrayList<Category> cat=(ArrayList<Category>)cdao.getallcategories();
		  ArrayList<Supplier> ss= (ArrayList<Supplier>)sdao.getallsuppliers();
		  
		    
			
		  ModelAndView mv1 = new ModelAndView("productlist1");
		  
		  mv1.addObject("sup",p);
		  mv1.addObject("cate",cat);
		  mv1.addObject("cat",ss);
	      return mv1;
	}


}
