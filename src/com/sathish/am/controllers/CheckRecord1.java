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
public class CheckRecord1 {
	@Autowired
	private AssetDAO dao;
	@RequestMapping("checkRecord")
	public @ResponseBody AssetPojo doPost(String name,HttpServletRequest req) {
		System.out.println("in check record controller");
		AssetPojo result=dao.checkRecord(name);
		
		if(result==null)
			return new AssetPojo();
		else
			return result;
		
		}
}



