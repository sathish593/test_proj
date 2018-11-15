package com.sathish.am.util;


public class switchtest {
	public static void main(String[] args) {
		if(1==1)
		{
			int ch=0;
			switch(ch)
			{
			case 0:
				switch(ch+1)
				{
				case 1:System.out.println(ch+1);
				}
			case 2:if(ch==2){System.out.println(ch);}
				System.out.println(ch);
			}
		}
	}

}