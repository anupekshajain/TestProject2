package MenuItems;

import java.net.URL;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;

public class menuItemsIssue2 {
	@Test
	public void Test1() throws InterruptedException {

		WindowsDriver<WindowsElement> DesktopSession = null;
		DesiredCapabilities capNew = new DesiredCapabilities();
		capNew.setCapability("app", "Root");

		String winAppServPath = "C:\\Program Files\\Windows Application Driver\\WinAppDriver.exe";
		ProcessBuilder proBd = new ProcessBuilder(winAppServPath).inheritIO();
		Process pro = null;

		try {
			pro = proBd.start();
			// Create a new desktop session
			DesktopSession = new WindowsDriver<WindowsElement>(new URL("http://127.0.0.1:4723"), capNew);
			 List<WindowsElement> ALB_Logon = DesktopSession.findElementsByName("Context");
			for(int i=0;i<ALB_Logon.size();i++)
			{
				 String topLevelWindowHandle = ALB_Logon.get(i).getText();
				 System.out.println(topLevelWindowHandle);
			}
			
			// MobileElement LoginScreen = ALB_Logon.findElementByName("Logon to ALB");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}