package com.mytests;

import org.testng.annotations.Test;

public class StringFormattr 
{
	@Test
	public void stngFr()
	{
		String x = "gfgweg '%s' jhsjwgef '%s' sghfd  '%s' hjgjsd";
		String y = String.format(x, "Anu","Jain","34");
		System.out.println(y);
	}

}
