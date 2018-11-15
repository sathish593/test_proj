package com.sathish.am.dao;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
//import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
//import org.hibernate.cfg.AnnotationConfiguration;
//import org.hibernate.cfg.Configuration;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.sathish.am.idao.Iassetdao;
import com.sathish.am.pojo.AssetPojo;
import com.sathish.am.pojo.AuditPojo;
import com.sathish.am.pojo.UserPojo;

//import com.sathish.am.util.HibernateUtil;
@Repository
public class AssetDAO extends HibernateDaoSupport implements Iassetdao{
	
	@Autowired
	public void init(HibernateTemplate htemplate)
	{
		super.setHibernateTemplate(htemplate);
	}
	
	public void insertAsset(AssetPojo pojo)
	{
	
		getHibernateTemplate().save(pojo);
	}
	public List<AssetPojo> getAllRec()
	{
		List<AssetPojo> list=(List<AssetPojo>)getHibernateTemplate().find("from AssetPojo");
		return list;
	}
	public AssetPojo getRecord(Integer id)
	{
		AssetPojo pojo=(AssetPojo)getHibernateTemplate().get(AssetPojo.class, id);
		return pojo;
	}
	public void delRecord(AssetPojo pojo)
	{
		getHibernateTemplate().delete(pojo);
	}
	public void updateRecord(AssetPojo pojo)
	{
		getHibernateTemplate().update(pojo);
	}
	public boolean Login(com.sathish.am.pojo.UserPojo pojo)
	{
		boolean result=false;
		@SuppressWarnings("unchecked")
		List<com.sathish.am.pojo.UserPojo> list=getHibernateTemplate().find("from UserPojo where username=? and password=?",pojo.getUsername(),pojo.getPassword());
	
		int count= list.size();
		if(count>0){
			result=true;
			
		}
		else
			result=false;
		
		return result;
	
	}
	public void audit(Collection<AuditPojo> auditlist)
	{
		for (AuditPojo auditPojo : auditlist) {
			//System.out.println(auditPojo.getId());
			getHibernateTemplate().persist(auditPojo);
		
		}
	}
	public UserPojo getuserpojo(UserPojo pojo)
	{
		@SuppressWarnings("unchecked")
		List<UserPojo> list=getHibernateTemplate().find("from UserPojo where username=? and password=?",pojo.getUsername(),pojo.getPassword());
		UserPojo pojo1=list.get(0);
		return pojo1;
	}
	public AssetPojo checkRecord(String name)
	{
		@SuppressWarnings("unchecked")
		List<AssetPojo> list=(List<AssetPojo>)getHibernateTemplate().find("from AssetPojo where name=?",name);
		if(list.size()>0)
			return list.get(0);
		else
			return null;
	}

}
