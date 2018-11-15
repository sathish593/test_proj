package com.sathish.am.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sathish.am.dao.AssetDAO;
import com.sathish.am.pojo.AssetPojo;
import com.sathish.am.pojo.UserPojo;
import com.sathish.am.util.AuditUtil;


@Controller
public class UpdateController {
	@Autowired
	private AssetDAO dao;
	@Autowired
	private AuditUtil util;
	@RequestMapping("updateRec")
	public ModelAndView doPost(AssetPojo pojo,HttpServletRequest req) {
		dao.updateRecord(pojo);
		Collection<String> proplist=new ArrayList<String>();
		proplist.add("name");
		proplist.add("type");
		proplist.add("cost");
		proplist.add("vender");
		util.collectAudit(req,pojo,proplist);
		return new ModelAndView("asset","pojo",pojo);
	}
}
