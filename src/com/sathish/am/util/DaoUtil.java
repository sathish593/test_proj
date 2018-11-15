package com.sathish.am.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.sathish.am.dao.AssetDAO;
import com.sathish.am.idao.Iassetdao;


public class DaoUtil 
{
	public static Iassetdao getAssetdao() throws FileNotFoundException, IOException
	{
		Iassetdao iasset=null;
		String s=null;
		 Properties prop=new Properties();
		 //prop.load(new FileInputStream(new File("asset.properties")));
		 InputStream is= DaoUtil.class.getClassLoader().getResourceAsStream("asset.properties");
		prop.load(is);
		  s=(String) prop.get("config");
		if(s!=null&&s.equals("1"))
		{
			iasset= new AssetDAO();
		}
		else if(s!=null&&s.equals("2"))
		{
			iasset= new AssetDAO();
		}
		else
		{
			iasset= new AssetDAO();
		}
		 
		 
		 return iasset;
		
	}
	

}
