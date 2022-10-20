package MenuItems;

import java.math.BigInteger;
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

public class menuItemsIssue {
	@Test
	public void Test1() throws InterruptedException {

//		cmdTest.killExisting();

		WindowsDriver<WindowsElement> driver = null;
		DesiredCapabilities capb = new DesiredCapabilities();

		String winAppServPath = "C:\\Program Files\\Windows Application Driver\\WinAppDriver.exe";
		ProcessBuilder proBd = new ProcessBuilder(winAppServPath).inheritIO();
		Process pro = null;

		capb.setCapability("app", "C:\\Users\\Anupeksha.Jain\\Downloads\\Sample\\Debug\\WinAppDriverTest.exe");
//		String winAppURL = "http://127.0.0.1:4723";
		capb.setCapability("platformName", "Windows");
		capb.setCapability("deviceName", "WindowsPC");
		capb.setCapability("ms:waitForAppLaunch", "15");
//		capb.acceptInsecureCerts();
		capb.setAcceptInsecureCerts(true);

		try {
			pro = proBd.start();
			driver = new WindowsDriver<WindowsElement>(new URL("http://127.0.0.1:4723"), capb);
			WebElement w = driver.findElementByXPath("//Text[@Name='Test1']");
			Actions act = new Actions(driver);
			act.moveToElement(w).contextClick().build().perform();
			Thread.sleep(2000);

			// Create a new desktop session
			WindowsDriver<WebElement> DesktopSession = null;
			DesiredCapabilities capNew = new DesiredCapabilities();
			capNew.setCapability("app", "Root");
			DesktopSession = new WindowsDriver<WebElement>(new URL("http://127.0.0.1:4723"), capNew);
			List<WebElement> menu = DesktopSession.findElementsByName("Context");
			System.out.println("Size : " +menu.size());
			String NativeWindowHandle =menu.get(0).getAttribute("NativeWindowHandle");
			NativeWindowHandle=String.format("%040x", new BigInteger(1, NativeWindowHandle.getBytes()));
			DesiredCapabilities caps2= new DesiredCapabilities();
			caps2.setCapability("appTopLevelWindow", NativeWindowHandle);
			WindowsDriver<WebElement> ContextMenuTopLevelSession = new WindowsDriver<WebElement>(new URL("http://127.0.0.1:4723"), capNew);
			ContextMenuTopLevelSession.findElementByName("Add").click();
			System.out.println("CLicked");

		} catch (Exception e) {

			System.out.println(e.getMessage());

		}

	}
}