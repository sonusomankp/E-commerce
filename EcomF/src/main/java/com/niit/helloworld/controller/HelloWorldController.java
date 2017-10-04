package com.niit.helloworld.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	public ModelAndView Admin()
	{

		System.out.println("in controller");
		ModelAndView mv = new ModelAndView("admin");
		ArrayList<Category> cat=(ArrayList<Category>)cdao.getallcategories();
		ArrayList<Supplier> ss= (ArrayList<Supplier>)sdao.getallsuppliers();
		System.out.println("hai after retrieve 1");
		
		mv.addObject("catego",cat);
		mv.addObject("cat",ss);
		return mv;
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
	@RequestMapping(value="/pro",method=RequestMethod.POST)
	public ModelAndView pro(@RequestParam("name") String name ,@RequestParam("sdes") String shor,@RequestParam("pric") int price,@RequestParam("stoc") int stock,@RequestParam("ca") int categ,@RequestParam("su") int suppli) {
		System.out.println("in controller");
		System.out.println(name+shor+price+stock+categ+suppli);
		Product pr=new Product();
		
		pr.setName(name);
	    pr.setShortDescrption(shor);
		pr.setPrice(price);
		pr.setStock(stock);
		
		
		Category ca = new Category();
		ca = cdao.getcatbyid(categ);
		pr.setCategory(ca);
		
		Supplier sa = new Supplier();
		sa = sdao.getsupbyid(suppli);
		pr.setSupplier(sa);
		
		
		
		pdao.saveProduct(pr);
		ModelAndView mv1 = new ModelAndView("admin");
		
		return mv1;
	}
	
	@RequestMapping("/bas")
	public String bask()
	{
		
		
		return "Basket";
	}
	@RequestMapping("/{categoryid}")
	public ModelAndView ca(@PathVariable("categoryid") int ca) {
		System.out.println("in contoller"+ca);
		ArrayList<Product> p1=new ArrayList<Product>();
		p1=pdao.getprbyid(ca);
		
		ModelAndView mv1 = new ModelAndView("ProductList");
		mv1.addObject("pro",p1);
		
		ArrayList<Category> l=(ArrayList<Category>)cdao.getallcategories();
		mv1.addObject("cate",l);
	
		
		return mv1;
		
	}
}

