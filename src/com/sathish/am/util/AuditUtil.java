package com.sathish.am.util;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;










import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sathish.am.dao.AssetDAO;
import com.sathish.am.pojo.AssetPojo;
import com.sathish.am.pojo.AuditPojo;
import com.sathish.am.pojo.UserPojo;

@Component
public class AuditUtil {
	@Autowired
	private AssetDAO dao;
	public void collectAudit(HttpServletRequest req,Object curpojo,Collection<String> proplist )
	{
		Object prevpojo=req.getSession().getAttribute("prevpojo");
		Object user=req.getSession().getAttribute("user");
		Collection<AuditPojo> auditlist=new ArrayList<AuditPojo>();
		for (String string : proplist) {
			
			try {
				System.out.println(string);
				String prevvalue=BeanUtils.getProperty(prevpojo,string );
				String curvalue=BeanUtils.getProperty(curpojo,string );
				if(!prevvalue.equals(curvalue))
				{
					AuditPojo auditpojo =new AuditPojo();
					auditpojo.setCur(curvalue);
					auditpojo.setProperty(string);
					auditpojo.setEntity(prevpojo.getClass().toString());
					auditpojo.setIp(req.getRemoteHost());
					auditpojo.setPer(prevvalue);
					auditpojo.setPojo((UserPojo)user);
					auditpojo.setTime(new Date());
					auditlist.add(auditpojo);
				}
				dao.audit(auditlist);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
		
		
	}

}
