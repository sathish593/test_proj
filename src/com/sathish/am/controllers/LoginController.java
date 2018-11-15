package com.sathish.am.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;






import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.web.servlet.ModelAndView;

import com.sathish.am.dao.AssetDAO;
import com.sathish.am.pojo.AssetPojo;
import com.sathish.am.pojo.UserPojo;




@Controller
public class LoginController 
{	
	@Autowired
	private AssetDAO dao;
	@RequestMapping("Login")
	public ModelAndView Login(@Valid @ModelAttribute("pojo") UserPojo pojo,BindingResult br,HttpSession session,HttpServletRequest req)
	{
		if(br.hasErrors())
		{
			System.out.println("has errors");
			return new ModelAndView("Login","pojo",pojo);
		}
		System.out.println("in controller");
	boolean result= dao.Login(pojo);
	if(result)
	{
		System.out.println("success");
		session.setAttribute("verified", "true");
		UserPojo user=dao.getuserpojo(pojo);
		req.getSession().setAttribute("user",user);
		return new ModelAndView("asset","pojo",new AssetPojo());
	
		}
	else
	{
		System.out.println("fail");
		return new ModelAndView("Login","pojo",pojo);
	
	}
	}
	@RequestMapping("glogin")
	public void gLogin(HttpServletRequest req)
	{
		System.out.println(req.getParameter("email"));
		System.out.println(req.getParameter("Password"));
		req.getRequestDispatcher("www.google.co.in");
		
		
	}
}