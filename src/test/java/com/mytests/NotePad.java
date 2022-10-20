package com.mytests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.windows.WindowsDriver;


public class NotePad 
{
	public static WindowsDriver driver = null;
	
	@SuppressWarnings("rawtypes")
	@BeforeMethod
	public void setUp()
	{
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("app", "C:\\Windows\\System32\\notepad.exe");
		cap.setCapability("platformName", "Windows");
		cap.setCapability("deviceName", "WindowsPC");
		try
		{
			driver = new WindowsDriver (new URL("http://127.0.0.1:4723"), cap);
		}
		catch(MalformedURLException e)
		{
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void cleanUp() 
	{
		driver.quit();
		setUp();
	}
	
	@AfterSuite
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test
	public void checkHelpAbout()
	{
		driver.findElementByName("Help").click();
		//driver.findElementById(null)
		driver.findElementByName("About Notepad").click();
		driver.findElementByName("OK").click();
		
	}
}
