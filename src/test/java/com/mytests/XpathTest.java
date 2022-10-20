package com.mytests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.appium.java_client.windows.WindowsDriver;

public class XpathTest 
{
	WindowsDriver driver = null;
	String winAppServPath = "C:\\Program Files (x86)\\Windows Application Driver\\WinAppDriver.exe";
	ProcessBuilder proBd = new ProcessBuilder(winAppServPath).inheritIO();
	Process pro;
	
	@BeforeSuite
	public void setUp() throws IOException
	{
		pro = proBd.start();
		driver = DDMainFunctions.setUpMethod(driver);
	}
	
	@Test
	public void Test1()
	{		
		//driver.findElementByXPath("//Edit[@Name='Username'][@AutomationId='UserName']").sendKeys("AnuA");
		//driver.findElementByXPath("//Edit[@Name='Username']").sendKeys("AnuA");
		///driver.findElementByXPath("//Edit[@Name='Password'][@AutomationId='Password']").sendKeys("Password@1");
		DDMainFunctions.aDDLogIn(driver, "AnuA", "Password@1");
//		String path = "//Pane[@ClassName='Internet Explorer_Server'][@Name='https://testclient2.advancedclouddictation.co.uk/Recorder']/Pane[@Name='Advanced Digital Dictation']/Table[starts-with(@AutomationId,'JColResizer')]/DataItem[position()=27]/Hyperlink[@Name='More']";
//		driver.findElementByXPath(path).click();
			String row = driver.findElementByName("RDP test 02").getAttribute("GridItem.Row");
			System.out.println("Row num ---" + row);
			int len = driver.findElementsByTagName("link").size();
			System.out.println("Num of items - "+ len);
		}
	
@AfterSuite
public void closure()
{
	pro.destroy();
}
	
}
