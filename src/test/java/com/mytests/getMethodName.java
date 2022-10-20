package com.mytests;

import java.lang.reflect.Method;

import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class getMethodName
{
	@BeforeClass
	public void getAPP(ITestContext con)
	{
		String s = con.getCurrentXmlTest().getClass().getName();
//		String s = con.
		System.out.println("FInal ClassName - "+s);
	}
		
	@BeforeMethod
//	public void init(ITestContext con)
	public void init(Method m)
	{
//		String cla = m.getAnnotation(Test.class).getClass().getName();
		int cla=m.getAnnotations().length;
		System.out.println("ClassName - "+cla);
		getMethodName g = new getMethodName();
		printName(g);
	}
	
	@Test
	public void myOwnTest(ITestContext con){
		String s = con.getClass().getName();
		System.out.println("ItestContext CLass = "+s);
		methodA();
	}
	
	public void methodA()
	{
		String s = Reporter.getCurrentTestResult().getMethod().getMethodName();
		System.out.println(s);
		Reporter.getCurrentTestResult().setAttribute("AppName", "PMS");
		String b =  (String) Reporter.getCurrentTestResult().getAttribute("Appname");
		System.out.println(b);
	
	}
	
	  void printName(Object obj){  
		  Class<? extends Object> c = obj.getClass();    
		  System.out.println(c.getName());  
		  }  
}
