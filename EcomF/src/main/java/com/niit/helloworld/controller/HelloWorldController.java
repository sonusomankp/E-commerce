package com.niit.helloworld.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.EcomB.DaoImpl.UserDaoImpl;
import com.niit.EcomB.Dao.CategoryDao;
import com.niit.EcomB.Dao.SupplierDao;
import com.niit.EcomB.Model.Category;
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
	
	
	String message = "Welcome to Spring MVC!";
 
	@RequestMapping("/hello")
	public ModelAndView showMessage()
	{

		System.out.println("in controller");
		ModelAndView mv = new ModelAndView("homepage");
		return mv;
	}
	@RequestMapping("/")
	public String home()
	{
		System.out.println("hi");
		return "homepage";
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
	@RequestMapping("/cate")
	public ModelAndView cate(@RequestParam("dtype") String sname,@RequestParam("psw") String sadd) {
		System.out.println("in controller");
		System.out.println(sname+sadd);
		Supplier s=new Supplier();
		s.setSname(sname);
		s.setSname(sadd);
		sdao.saveSupplier(s);
	
		ModelAndView mv1 = new ModelAndView("");
		return mv1;
	}
	
	@RequestMapping("/supp")
	public ModelAndView supp(@RequestParam("psw") String cname) {
		System.out.println("in controller");
		System.out.println(cname);
		Category c=new Category();
		c.setCname(cname);
		cdao.saveCategory(c);
	
		ModelAndView mv1 = new ModelAndView("admin");
		return mv1;
	}
	
	@RequestMapping("/bas")
	public String bask()
	{
		
		return "Basket";
	}
	
}

