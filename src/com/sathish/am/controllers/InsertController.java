
package com.sathish.am.controllers;




import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sathish.am.dao.AssetDAO;
import com.sathish.am.pojo.AssetPojo;

@Controller
public class InsertController {
	@Autowired
	private AssetDAO dao;
	@RequestMapping("insertRec")
	public ModelAndView doPost(AssetPojo pojo,HttpServletRequest req,HttpServletResponse res) 
	{
		/*String verified=(String)req.getSession().getAttribute("verified");
		if(verified==null||!verified.trim().equals("true"))
		{ 
			return new ModelAndView("Login","pojo",new UserPojo());
		}
		else{*/
		MultipartFile file1=pojo.getFile();
		File file=new File("F:\\dev\\uploaded\\"+file1.getOriginalFilename());
		FileOutputStream fos=null;
		BufferedOutputStream bos=null;
		
		try {
			fos = new FileOutputStream(file);
			bos=new BufferedOutputStream(fos);
			bos.write(file1.getBytes());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				if(bos!=null)
					bos.close();
				if(fos!=null)
					fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	dao.insertAsset(pojo);
	
	return new ModelAndView("asset","pojo",pojo);
	}
	@RequestMapping("showfiles")
	public ModelAndView showfiles(AssetPojo pojo,HttpServletRequest req,HttpServletResponse res) 
	{
		File fl=new File("F:\\dev\\uploaded\\");
		String[] list=fl.list();
		req.setAttribute("fl", list);
		return new ModelAndView("asset","pojo",new AssetPojo());
	}
	@RequestMapping("download")
	public @ResponseBody byte[] download(String file,HttpServletRequest req,HttpServletResponse res) throws IOException 
	{
		File file1=new File("F:\\dev\\uploaded\\"+file);

		res.setContentType("application/octet-stream");
		res.setHeader("Content-Disposition","attachment; filename=\"" + file1.getName() +"\"");
		//res.setContentLength((int)file1.);
		return FileUtils.readFileToByteArray(file1);
	}
}
