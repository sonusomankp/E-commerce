package com.niit.helloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
 
@Controller
public class HelloWorldController {
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
	@RequestMapping("/up")
	public String signup()
	{
		
		return "signup";
	}
	@RequestMapping("/bas")
	public String bask()
	{
		
		return "Basket";
	}
	
}

