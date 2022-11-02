package com.mytests;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;

public class startWithALB {
    @Test
    public void Test1() throws InterruptedException {

//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Anupeksha.Jain\\Downloads\\chromedriver_win32\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
//		String url = " https://www.tutorialspoint.com/questions/index.php";
//		driver.get(url);
//		driver.manage().window().maximize();
//		Thread.sleep(5000);
//		driver.quit();

        WindowsDriver<WindowsElement> driver = null;
        DesiredCapabilities capb = new DesiredCapabilities();
        String winAppServPath = "C:\\Program Files (x86)\\Windows Application Driver\\WinAppDriver.exe";
        ProcessBuilder proBd = new ProcessBuilder(winAppServPath).inheritIO();
        Process pro = null;

        capb.setCapability("app", "C:\\Program Files (x86)\\Advanced Legal\\ALB\\PMS\\IRIS.Law.PmsExe.exe");
        String winAppURL = "http://127.0.0.1:4723";
        capb.setCapability("platformName", "Windows");
        capb.setCapability("ms:waitForAppLaunch", "50");

        try {
            pro = proBd.start();
            driver = new WindowsDriver<WindowsElement>(new URL("http://127.0.0.1:4723"), capb);
            driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
            Thread.sleep(30000);
    
            // System.out.println("App Launched");

        } catch (Exception e) {
// 			System.out.println(e.getMessage());
        }
        JOptionPane.showMessageDialog(null, "My Goodness, this is so concise");
		driver.findElementByAccessibilityId("Username").sendKeys("Anupeksha.jain@oneadvanced.com");
//		driver.findElementByAccessibilityId("Username").sendKeys(Keys.TAB);
////		System.out.println(driver.getWindowHandles().size());
		WindowsElement pswd = driver.findElementByAccessibilityId("Password");
		pswd.sendKeys("Password@1");
//		driver.findElementByXPath("//*[@Name='Login' and @LocalizedControlType='button']").click();
//		Thread.sleep(9000);
//		System.out.println("Wait over");
//		System.out.println(driver.toString());
//        driver.findElementByAccessibilityId("Username").sendKeys("Anupeksha.jain@oneadvanced.com" + Keys.TAB);
//        WindowsElement pswd = driver.findElementByAccessibilityId("Password");
//        pswd.sendKeys("Password@1");
//        driver.findElementByName("Login").click();
//        Thread.sleep(9000);

        if (driver != null) {
            driver.quit();
        }
        if (pro != null) {
            pro.destroy();
        }
    }

}
