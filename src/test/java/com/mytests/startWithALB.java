package com.mytests;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.windows.WindowsDriver;

public class startWithALB {
	@Test
	public void Test1() throws InterruptedException {
		
//		cmdTest.killExisting();
		
		WindowsDriver<WebElement> driver = null;
		DesiredCapabilities capb = new DesiredCapabilities();
		
		
		String winAppServPath = "C:\\Program Files (x86)\\Windows Application Driver\\WinAppDriver.exe";
		ProcessBuilder proBd = new ProcessBuilder(winAppServPath).inheritIO();
		Process pro = null;
		
		capb.setCapability("app", "C:\\Program Files (x86)\\Advanced Legal\\ALB\\PMS\\IRIS.Law.PmsExe.exe");
//		String winAppURL = "http://127.0.0.1:4723";
		capb.setCapability("platformName", "Windows");
		capb.setCapability("deviceName", "WindowsPC");
		capb.setCapability("ms:waitForAppLaunch", "25");
//		capb.acceptInsecureCerts();
		capb.setAcceptInsecureCerts(true);
		
		try {
			pro = proBd.start();
			driver = new WindowsDriver<WebElement>(new URL("http://127.0.0.1:4723"), capb);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Thread.sleep(10000);
			System.out.println("App Launched");
		} catch (Exception e) {

//			e.printStackTrace();
//			driver.a
			
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElementByAccessibilityId("Username").sendKeys("Anupeksha.jain@oneadvanced.com");
		driver.findElementByAccessibilityId("Username").sendKeys(Keys.TAB);
		System.out.println(driver.getWindowHandles().size());
		WebElement pswd = driver.findElementByAccessibilityId("Password");
		pswd.sendKeys("Password@1");
		driver.findElementByXPath("//*[@Name='Login' and @LocalizedControlType='button']").click();
		Thread.sleep(9000);
		System.out.println("Wait over");
		System.out.println(driver.toString());
		try
		{
			driver.manage().window().maximize();
//			int size = driver.getWindowHandles().size();
//			System.out.println(size);
		}
		catch(Exception ex)
		{
			System.out.println("driver gone");
		}
		driver.quit();

//		driver.manage().window().maximize();
//		List<Map<String, Object>> s = driver.getAllSessionDetails();
//		for(Map m:s)
//		{
//			System.out.println(m);
//		}
//		Set<String> windows = driver.getWindowHandles();
//		System.out.println(windows.size());
//		
//		driver.findElementByName("Practice Management System - ALB : Advanced Legal").click();
//		driver.findElementByName("Search for Matter").click();
//		System.out.println("Size of getWindowHandles : "+driver.getWindowHandles().size());
		
//		if(pro!=null)
//			{
//			pro.destroy();
//			}
	}

}
