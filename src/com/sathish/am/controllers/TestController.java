package com.sathish.am.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sathish.am.pojo.AssetPojo;
import com.sathish.am.pojo.UserPojo;

@Controller
public class TestController {
	@RequestMapping("test")
	public ModelAndView test()
	{	
		return new ModelAndView("Login","pojo",new UserPojo());		
	}
	
}
