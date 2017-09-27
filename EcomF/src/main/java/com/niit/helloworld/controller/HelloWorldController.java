package com.niit.helloworld.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.EcomB.DaoImpl.UserDaoImpl;
import com.niit.EcomB.Dao.CategoryDao;
import com.niit.EcomB.Dao.ProductDao;
import com.niit.EcomB.Dao.SupplierDao;
import com.niit.EcomB.Model.Category;
import com.niit.EcomB.Model.Product;
import com.niit.EcomB.Model.Supplier;
import com.niit.EcomB.Model.User;


 
@SuppressWarnings("unused")
@Controller
public class HelloWorldController {
	
	@Autowired
	UserDaoImpl udao;
	
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
	@RequestMapping("/in")
	public String login()
	{
		
		return "login";
	}
	@RequestMapping("/signUp")
	public String signUp()
	{
		
		return "signup";
	}
	@RequestMapping("/Admin")
	public String Admin()
	{
		
		return "admin";
	}
	@RequestMapping("/up")
		public ModelAndView up(@RequestParam("name") String uname ,@RequestParam("email") String uemail,@RequestParam("pwd") String pass,@RequestParam("no") long no) {
			System.out.println("in controller");
			System.out.println(uname+uemail+pass+no);
			User p=new User();
			
			p.setUname(uname);
			p.setUemail(uemail);
			p.setUmobno(no);
			p.setUpass(pass);
			udao.saveUser(p);
		
			ModelAndView mv1 = new ModelAndView("signup");
			
			return mv1;
		}
	@RequestMapping("/supp")
	public ModelAndView supp(@RequestParam("dtype") String sname,@RequestParam("psw") String sadd) {
		System.out.println("in controller");
		System.out.println(sname+sadd);
		Supplier s=new Supplier();
		s.setSname(sname);
		s.setSname(sadd);
		sdao.saveSupplier(s);
		ModelAndView mv1 = new ModelAndView("admin");
		
		return mv1;
	}
	
	@RequestMapping("/cate")
	public ModelAndView cate(@RequestParam("psw") String cname) {
		System.out.println("in controller");
		System.out.println(cname);
		Category c=new Category();
		c.setCname(cname);
		cdao.saveCategory(c);
		
		
		
		ModelAndView mv1 = new ModelAndView("admin");
	
		return mv1;
	}
	@RequestMapping("/pro")
	public ModelAndView pro(@RequestParam("dtype") String type ,@RequestParam("tit") String title,@RequestParam("sdes") String shortdes,@RequestParam("form") String format) {
		System.out.println("in controller");
		System.out.println(type+title+shortdes+format);
		Product pr=new Product();
		
		pr.setdType(type);
		pr.setTitle(title);
		pr.setShortDescrption(shortdes);
		pr.setFormat(format);
		pdao.saveProduct(pr);
	
		ModelAndView mv1 = new ModelAndView("admin");
		
		return mv1;
	}
	
	@RequestMapping("/bas")
	public String bask()
	{
		
		return "Basket";
	}
	
}

