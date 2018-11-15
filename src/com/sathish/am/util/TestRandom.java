package com.sathish.am.util;

import java.util.Random;

public class TestRandom {
	public static void main(String[] args) {
		int num[]={},i,j;     
	    boolean check;                         
	    for(i=0;i<9;i++)
	    {
	        check=false;
	        do
	        {
	           
	          double p= Math.random()*1000;
	          System.out.println(p);
	            num[i]=(int)p%10;
	            check=true;
	            for(j=0;j<i;j++)
	            {
	                if( num[i]==num[j])    
	                    check=false;
	                else
	                    check=true;   
	            } 
	        } while(check==false);
	    }

	   
	    for(i=0;i<9;i++)
	    {
	        System.out.println(num[i]);
	    }
	}

}
