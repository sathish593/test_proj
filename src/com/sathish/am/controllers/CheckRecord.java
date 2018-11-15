package com.sathish.am.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sathish.am.dao.AssetDAO;
import com.sathish.am.pojo.AssetPojo;

@Controller
public class CheckRecord {
	@Autowired
	private AssetDAO dao;
	@RequestMapping("checkRecord1")
	public @ResponseBody String doPost(String name,HttpServletRequest req) {
		System.out.println("in check record controller");
		AssetPojo result=dao.checkRecord(name);
		String msg=null;
		if(result==null)
			msg="not exist you can procede";
		else
			msg="Already exists";
		return "{\"msg\":\""+msg+"\"}";
		
		}
}



