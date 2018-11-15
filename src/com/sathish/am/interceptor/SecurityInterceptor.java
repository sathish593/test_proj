package com.sathish.am.interceptor;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.sathish.am.pojo.UserPojo;

public class SecurityInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
System.out.println("aftercomplition");
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("posthandle");

	}

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2) throws Exception {
		// TODO Auto-generated method stub
		
		arg0.setAttribute("user", new UserPojo());
		String uri= arg0.getRequestURI();
		System.out.println(uri);
		
		ArrayList<String> list=new ArrayList<String>();
		list.add("/assetmag/test.action");
		list.add("/assetmag/Login.action");
		if(!list.contains(uri))
		{
			String verified =(String)arg0.getSession().getAttribute("verified");
			System.out.println(verified);
			if(verified==null||!verified.trim().equals("true"))
			{ 
				System.out.println("login");
				arg0.getRequestDispatcher("test.action");
			}
			else
				return true;
		}
		
			return true;
		
		
	}

}
