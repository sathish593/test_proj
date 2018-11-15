package com.sathish.am.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sathish.am.dao.AssetDAO;
import com.sathish.am.pojo.AssetPojo;
import com.sathish.am.pojo.UserPojo;


@Controller
public class GerController {
	@Autowired
	private AssetDAO dao;
	/*@RequestMapping("gerRec")
	public ModelAndView doPost(AssetPojo pojo,HttpServletRequest req)
	{
		AssetPojo pojo1=dao.getRecord(pojo.getId());
		req.getSession().setAttribute("prevpojo", pojo1);
		return new ModelAndView("asset","pojo",pojo1);
		
	}
*/
	@RequestMapping("gerRec")
	public @ResponseBody AssetPojo doPost(Integer id,HttpServletRequest req)
	{ System.out.println(id);
		AssetPojo pojo1=dao.getRecord(id);
		
		return pojo1;
		
	}

}
