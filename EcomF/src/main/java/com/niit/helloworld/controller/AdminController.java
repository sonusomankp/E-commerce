package com.niit.helloworld.controller;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.EcomB.DaoImpl.UserDaoImpl;
import com.niit.EcomB.Dao.CartDao;
import com.niit.EcomB.Dao.CategoryDao;
import com.niit.EcomB.Dao.ProductDao;
import com.niit.EcomB.Dao.SupplierDao;
import com.niit.EcomB.Dao.UserDao;
import com.niit.EcomB.Model.Cart;
import com.niit.EcomB.Model.Category;
import com.niit.EcomB.Model.Product;
import com.niit.EcomB.Model.Supplier;
import com.niit.EcomB.Model.User;


 
@SuppressWarnings("unused")
@Controller




public class AdminController {

	
	
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
	
	
//	admin page
	
	@RequestMapping("/admin/Admin")
	public ModelAndView Admin()
	{

		System.out.println("in controller");
		ModelAndView mv = new ModelAndView("admin");
		ArrayList<Category> cat=(ArrayList<Category>)cdao.getallcategories();
		ArrayList<Supplier> ss= (ArrayList<Supplier>)sdao.getallsuppliers();
		System.out.println("hai after retrieve 1");
		
		
		mv.addObject("cate",cat);
		mv.addObject("catego",cat);
		mv.addObject("cat",ss);
		return mv;
	}
	@RequestMapping("/Admin")
	public ModelAndView admin()
	{

		System.out.println("in controller");
		ModelAndView mv = new ModelAndView("redirect:/admin/Admin");
		return mv;
	}
	
	
//	saving supplier
	
	@RequestMapping("/admin/supp")
	public ModelAndView supp(@RequestParam("dtype") String sname,@RequestParam("psw") String sadd) {
		System.out.println("in controller");
		System.out.println(sname+sadd);
		Supplier s=new Supplier();
		s.setSname(sname);
		s.setSaddr(sadd);
		sdao.saveSupplier(s);
		ModelAndView mv1 = new ModelAndView("redirect:/Admin");
		return mv1;
	}
	
	
//	saving category
	
	@RequestMapping("/admin/cate")
	public ModelAndView cate(@RequestParam("psw") String cname) {
		System.out.println("in controller");
		System.out.println(cname);
		Category c=new Category();
		c.setCname(cname);
		cdao.saveCategory(c);
		
		
		
		ModelAndView mv1 = new ModelAndView("redirect:/Admin");
		return mv1;
	}
	
	
//	 saving product
	
	@RequestMapping(value="/admin/pro",method=RequestMethod.POST)
	public ModelAndView pro(@RequestParam("name") String name ,@RequestParam("sdes") String shor,@RequestParam("pric") int price,@RequestParam("stoc") int stock,@RequestParam("ca") int categ,@RequestParam("su") int suppli,@RequestParam("img") MultipartFile file) {
		System.out.println("in controller");
		System.out.println(name+shor+price+stock+categ+suppli);
		Product pr=new Product();
		
		
		String img=file.getOriginalFilename();
		
		pr.setName(name);
	    pr.setShortDescrption(shor);
		pr.setPrice(price);
		pr.setStock(stock);
		pr.setImg(img);
		
		Category ca = new Category();
		ca = cdao.getcatbyid(categ);
		pr.setCategory(ca);
		
		Supplier sa = new Supplier();
		sa = sdao.getsupbyid(suppli);
		pr.setSupplier(sa);
		
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
		
		
		pdao.saveProduct(pr);
		ModelAndView mv1 = new ModelAndView("redirect:/Admin");
		
		return mv1;
	}
	
	// product list
	@RequestMapping("/categoryid")
	public ModelAndView productlist(@RequestParam("id") int ca) {
		System.out.println("in contoller"+ca);
		ArrayList<Product> p1=new ArrayList<Product>();
		p1=pdao.getprbyid(ca);
		
		
		ModelAndView mv1 = new ModelAndView("productlist");
		mv1.addObject("pros",p1);
		
		
		
		
		ArrayList<Category> cat=(ArrayList<Category>)cdao.getallcategories();
		mv1.addObject("cate",cat);
		
		
		return mv1;
		
	}
	
	
	// product list
		@RequestMapping("/categoryid1")
		public ModelAndView productlist1(@RequestParam("id") int ca) {
			System.out.println("in contoller"+ca);
			ArrayList<Product> p1=new ArrayList<Product>();
			p1=pdao.getprbyid(ca);
			
			
			ModelAndView mv1 = new ModelAndView("productlist1");
			mv1.addObject("pros",p1);
			
			
			ArrayList<Category> cat=(ArrayList<Category>)cdao.getallcategories();
			mv1.addObject("cate",cat);
			
			
			return mv1;
			
		}
		
	
	
}
