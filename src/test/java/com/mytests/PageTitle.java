package com.mytests;

public class PageTitle 
{
	public static void main(String[] args)
	{
		String title="//*[@Name='%s']";
		String pageTitle = "Logon to ALB";
		 String fmt = String.format(title, pageTitle);
		 System.out.println(fmt);
	}

}
