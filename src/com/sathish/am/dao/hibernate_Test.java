package com.sathish.am.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.sathish.am.pojo.AssetPojo;
import com.sathish.am.util.HibernateUtil;



public class hibernate_Test {
	//general select all operation
	public static void main1(String[] args) {
		Session session=HibernateUtil.getSession();
		Transaction tx=session.beginTransaction();
		Query query=session.createQuery("from AssetPojo");
		List<AssetPojo> list=(List<AssetPojo>) query.list();
		for (AssetPojo AssetPojo : list) {
			System.out.println(AssetPojo.getId()+"::"+AssetPojo.getName());
		//AssetPojo.getRpojo().getCnum();
		}
		tx.commit();
		session.close();
		}
	//Overriding toString()
	public static void main20(String[] args) {
		Session session=HibernateUtil.getSession();
		Transaction tx=session.beginTransaction();
		Query query=session.createQuery("from AssetPojo");
		List<AssetPojo> list=(List<AssetPojo>) query.list();
		for (AssetPojo AssetPojo : list) {
			System.out.println(AssetPojo);
		//AssetPojo.getRpojo().getCnum();
		}
		tx.commit();
		session.close();
		}
	//resrticting number of columns
	public static void main2(String[] args) 
	{
		Session session=HibernateUtil.getSession();
		Transaction tx=session.beginTransaction();
		Query query=session.createQuery("select id,name from AssetPojo");
		List<Object[]> list=(List<Object[]>) query.list();
		for (Object[] object : list)  {
			System.out.println(object[0]+"::"+object[1]);
			}
		tx.commit();
		session.close();
		}
	//restricting number of rows
	public static void main3(String[] args) 
	{
		Session session=HibernateUtil.getSession();
		Transaction tx=session.beginTransaction();
		Query query=session.createQuery("from AssetPojo where id<10 ");
		List<AssetPojo> list=(List<AssetPojo>) query.list();
		for (AssetPojo AssetPojo : list) {
			//System.out.println(AssetPojo.getId()+"::"+AssetPojo.getName()+"::"+AssetPojo.getCompany()+"::"+AssetPojo.getOwner()+"::"+AssetPojo.getModel());
		}
		
		tx.commit();
		session.close();
		}
	//restricting number of columns & rows
	public static void main4(String[] args) 
	{
		Session session=HibernateUtil.getSession();
		Transaction tx=session.beginTransaction();
		Query query=session.createQuery("select id,name from AssetPojo where id<10");
		List<Object[]> list=(List<Object[]>) query.list();
		for (Object[] object : list)  {
			System.out.println(object[0]+"::"+object[1]);
			}
		tx.commit();
		session.close();
		}
	//restricting using named parameter
	public static void main5(String[] args) 
	{
		Session session=HibernateUtil.getSession();
		Transaction tx=session.beginTransaction();
		Query query=session.createQuery("select id,name from AssetPojo where name=:a");
		query.setString("a","prabhanjan");
		List<Object[]> list=(List<Object[]>) query.list();
		for (Object[] object : list)  {
			System.out.println(object[0]+"::"+object[1]);
			}
		tx.commit();
		session.close();
		}
	//joins
	public static void main6(String[] args) 
	{
		Session session=HibernateUtil.getSession();
		Transaction tx=session.beginTransaction();
		Query query=session.createQuery("select v.id,v.name,r.rid from AssetPojo v join v.rpojo r");
		//query.setString("a","prabhanjan");
		List<Object[]> list=(List<Object[]>)query.list();
		for (Object[] object : list)  {
			System.out.println("in for");
			System.out.println(object[0]+"::"+object[1]+"::"+object[2]);
			}
		System.out.println("fin");
		tx.commit();
		session.close();
		}
	//criteria get all
	public static void main7(String[] args) 
	{
		Session session=HibernateUtil.getSession();
		//Transaction tx=session.beginTransaction();
		Criteria ctr=session.createCriteria(AssetPojo.class);
		
		List<AssetPojo> list=(List<AssetPojo>)ctr.list();
		for (AssetPojo AssetPojo : list) {
			//System.out.println(AssetPojo.getId()+"::"+AssetPojo.getName()+"::"+AssetPojo.getCompany()+"::"+AssetPojo.getOwner()+"::"+AssetPojo.getModel());
		}
		//tx.commit();
		session.close();
		}
	//restrictions (restricting rows)
	public static void main8(String[] args) 
	{
		Session session=HibernateUtil.getSession();
		//Transaction tx=session.beginTransaction();
		Criteria ctr=session.createCriteria(AssetPojo.class);
		ctr.add(Restrictions.eq("name", "prabhanjan"));
		@SuppressWarnings("unchecked")
		List<AssetPojo> list=(List<AssetPojo>)ctr.list();
		for (AssetPojo AssetPojo : list) {
			//System.out.println(AssetPojo.getId()+"::"+AssetPojo.getName()+"::"+AssetPojo.getCompany()+"::"+AssetPojo.getOwner()+"::"+AssetPojo.getModel());
		}
		//tx.commit();
		session.close();
		}
	// criteria projections(restricting columns)
	public static void main9(String[] args) 
	{
		Session session=HibernateUtil.getSession();
		Transaction tx=session.beginTransaction();
		Criteria ctr=session.createCriteria(AssetPojo.class);
		ProjectionList pl=Projections.projectionList();
		pl.add(Projections.property("id"));
		pl.add(Projections.property("name"));
		ctr.setProjection(pl);
		List<Object[]> list=(List<Object[]>)ctr.list();
		
		for (Object[] AssetPojo : list) {
			System.out.println(AssetPojo[0]+":::"+AssetPojo[1]);
		}
		tx.commit();
		session.close();
		}
	//restrictions && projections
	public static void main10(String[] args) 
	{
		Session session=HibernateUtil.getSession();
		Transaction tx=session.beginTransaction();
		Criteria ctr=session.createCriteria(AssetPojo.class);
		ctr.add(Restrictions.eq("name", "prabhanjan"));
		ProjectionList pl=Projections.projectionList();
		pl.add(Projections.property("id"));
		pl.add(Projections.property("name"));
		ctr.setProjection(pl);
		List<Object[]> list=(List<Object[]>)ctr.list();
		
		for (Object[] AssetPojo : list) {
			System.out.println(AssetPojo[0]+":::"+AssetPojo[1]);
		}
		tx.commit();
		session.close();
	}
	//joins in critera with projection
	public static void main11(String[] args) 
	{
		Session session=HibernateUtil.getSession();
		Transaction tx=session.beginTransaction();
		Criteria ctr=session.createCriteria(AssetPojo.class,"v");
		ctr.createAlias("v.rpojo","r");
		ProjectionList pl=Projections.projectionList();
		pl.add(Projections.property("v.id"));
		pl.add(Projections.property("v.name"));
		pl.add(Projections.property("r.rid"));
		ctr.setProjection(pl);
		List<Object[]> list=(List<Object[]>)ctr.list();
		for (Object[] AssetPojo : list) 
		{
			System.out.println(AssetPojo[0]+":::"+AssetPojo[1]+":::"+AssetPojo[2]);
		}
		tx.commit();
		session.close();
		
	}
	//restriction and projection in criteria with joins
	public static void main12(String[] args) 
	{
		Session session=HibernateUtil.getSession();
		Transaction tx=session.beginTransaction();
		Criteria ctr=session.createCriteria(AssetPojo.class,"v");
		ctr.createAlias("v.rpojo","r");
		ProjectionList pl=Projections.projectionList();
		pl.add(Projections.property("v.id"));
		pl.add(Projections.property("v.name"));
		pl.add(Projections.property("r.rid"));
		ctr.setProjection(pl);
		ctr.add(Restrictions.le("v.id", 10));
		List<Object[]> list=(List<Object[]>)ctr.list();
		for (Object[] AssetPojo : list) 
		{
			System.out.println(AssetPojo[0]+":::"+AssetPojo[1]+":::"+AssetPojo[2]);
		}
		tx.commit();
		session.close();
		
	}
	//using IN clause in HQL {IN (:LIST)}
	public static void main13(String[] args) {
		Session session=HibernateUtil.getSession();
		Transaction tx=session.beginTransaction();
		
		Query query=session.createQuery("from AssetPojo where id in (:ids) ");
		List<Integer> list1=new ArrayList<Integer>();
		list1.add(2);
		list1.add(3);
		list1.add(4);
		list1.add(5);
		list1.add(6);
		query.setParameterList("ids", list1);
		List<AssetPojo> list=(List<AssetPojo>) query.list();
		for (AssetPojo AssetPojo : list) {
			System.out.println(AssetPojo.getId()+"::"+AssetPojo.getName());
		//AssetPojo.getRpojo().getCnum();
		}
		tx.commit();
		session.close();
		}
	//IN clause in Criteria
	public static void main14(String[] args) 
	{
		Session session=HibernateUtil.getSession();
		//Transaction tx=session.beginTransaction();
		Criteria ctr=session.createCriteria(AssetPojo.class);
		List<Integer> list1=new ArrayList<Integer>();
		list1.add(2);
		list1.add(3);
		list1.add(4);
		list1.add(5);
		list1.add(6);
		ctr.add(Restrictions.in("id",list1));
		@SuppressWarnings("unchecked")
		List<AssetPojo> list=(List<AssetPojo>)ctr.list();
		for (AssetPojo AssetPojo : list) {
			System.out.println(AssetPojo.getId()+"::"+AssetPojo.getName()+"::"+AssetPojo.getCost()+"::"+AssetPojo.getType()+"::"+AssetPojo.getVender());
		}
		//tx.commit();
		session.close();
		}
	//group by in hql
	public static void main15(String[] args) {
		Session session=HibernateUtil.getSession();
		Transaction tx=session.beginTransaction();
		Query query=session.createQuery("select sum(id),company from AssetPojo group by company");
		List<Object[]> list=(List<Object[]>)query.list();
		for (Object[] AssetPojo : list) {
			System.out.println(AssetPojo[0]+":::"+AssetPojo[1]);
		//AssetPojo.getRpojo().getCnum();
		}
		tx.commit();
		session.close();
		}
	public static void main16(String[] args) {
		Session session=HibernateUtil.getSession();
		Transaction tx=session.beginTransaction();
		Query query=session.createQuery("from AssetPojo");
		
		List<Object[]> list=(List<Object[]>)query.list();
		for (Object[] AssetPojo : list) {
			System.out.println(AssetPojo[0]+":::"+AssetPojo[1]);
		//AssetPojo.getRpojo().getCnum();
		}
		tx.commit();
		session.close();
		}
	public static void main(String[] args) {
		Session session=HibernateUtil.getSession();
		Transaction tx=session.beginTransaction();
		Query query=session.createQuery("from AssetPojo1");
		
		List<Object[]> list=(List<Object[]>)query.list();
		for (Object[] AssetPojo : list) {
			System.out.println(AssetPojo[0]+":::"+AssetPojo[1]);
		//AssetPojo.getRpojo().getCnum();
		}
		tx.commit();
		session.close();
		}
}
