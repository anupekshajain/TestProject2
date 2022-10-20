package com.mytests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class startWithALB {
	@Test
	public void Test1() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Anupeksha.Jain\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String url = " https://www.tutorialspoint.com/questions/index.php";
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.quit();
		
//		cmdTest.killExisting();
		
//		WindowsDriver<WebElement> driver = null;
//		DesiredCapabilities capb = new DesiredCapabilities();
//		
//		
//		String winAppServPath = "C:\\Program Files (x86)\\Windows Application Driver\\WinAppDriver.exe";
//		ProcessBuilder proBd = new ProcessBuilder(winAppServPath).inheritIO();
//		Process pro = null;
//		
//		capb.setCapability("app", "C:\\Program Files (x86)\\Advanced Legal\\ALB\\PMS\\IRIS.Law.PmsExe.exe");
////		String winAppURL = "http://127.0.0.1:4723";
//		capb.setCapability("platformName", "Windows");
//		capb.setCapability("deviceName", "WindowsPC");
//		capb.setCapability("ms:waitForAppLaunch", "25");
////		capb.acceptInsecureCerts();
//		capb.setAcceptInsecureCerts(true);
//		
//		try {
//			pro = proBd.start();
//			driver = new WindowsDriver<WebElement>(new URL("http://127.0.0.1:4723"), capb);
//			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//			Thread.sleep(10000);
//			System.out.println("App Launched");
//			
//		} catch (Exception e) {
//			
//		}
//		driver.findElementByAccessibilityId("Username").sendKeys("Anupeksha.jain@oneadvanced.com");
//		driver.findElementByAccessibilityId("Username").sendKeys(Keys.TAB);
//		System.out.println(driver.getWindowHandles().size());
//		WebElement pswd = driver.findElementByAccessibilityId("Password");
//		pswd.sendKeys("Password@1");
//		driver.findElementByXPath("//*[@Name='Login' and @LocalizedControlType='button']").click();
//		Thread.sleep(9000);
//		System.out.println("Wait over");
//		System.out.println(driver.toString());
//		
//		if(pro!=null)
//			{
//			pro.destroy();
//			}
	}

}
