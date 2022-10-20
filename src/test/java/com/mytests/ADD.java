package com.mytests;

public class ADD {
//	public static WindowsDriver<WindowsElement> driver = null;
//	public static WebDriverWait wait;
//	
//
//	@BeforeSuite
//	public void setUp() {
//		DesiredCapabilities capb = new DesiredCapabilities();
//		capb.setCapability("app", "C:\\Program Files (x86)\\Advanced Digital Dictation\\Layer App\\OyezSpeech7.exe");
//		capb.setCapability("platformName", "Windows");
//		capb.setCapability("deviceName", "WindowsPC");
//		try 
//		{
//			driver = new WindowsDriver(new URL("http://127.0.0.1:4723"), capb);
//		} 
//		catch (MalformedURLException e) 
//		{
////			e.printStackTrace();
//		}
//		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//		
//		wait = new WebDriverWait(driver, 8);
//	}
//
//	
//	@Test(priority = 1)
//	public void ADDLogin() 
//	{
////		driver.findElementByAccessibilityId("UserName").sendKeys("prathuA");
////		driver.findElementByXPath("//*[@Name='Username' and @LocalizedControlType='edit']").sendKeys("AnuA");
//		driver.findElementByXPath("//Edit[@Name='Username']").sendKeys("AnuA");
////		"/Pane[@ClassName=\"#32769\"][@Name=\"Desktop 1\"]/Window[@Name=\""Advanced Digital Dictation - Digital Dictation [Administrator\"][@AutomationId=\"FormLogin\"]/Pane[@AutomationId=\"webBrowser\"]/Pane[@ClassName=\"Shell Embedding\"]/Pane[@ClassName=\"Shell DocObject View\"]/Pane[@ClassName=\"Internet Explorer_Server\"][@Name=\"https://testclient2.advancedclouddictation.co.uk/Account/Login\"]/Pane[@Name=\"Advanced Digital Dictation - Login\"]/List[position()=3]/ListItem[@Name=\"Username\"]/Edit[@Name=\"Username\"][@AutomationId=\"UserName\"]"
//
////		driver.findElementByAccessibilityId("Password").sendKeys("Password@1");
////		driver.findElementByName("Submit").click();
////
////		try
////		{
////			driver.findElementByName("Ok").click();
////		}
////		catch(Exception e)
////		{
//////			System.out.println(e.getCause());
////		}
//	}
//	
//	@Ignore
//	@Test(priority = 2)
//	public void recordDictation()
//	{
//		
//		WebElement defaultBtn = driver.findElementByName("Default");
//		WebElement recBtn = driver.findElementByAccessibilityId("recBtn");
//		
//		wait.until(ExpectedConditions.visibilityOf(defaultBtn));
//		
//		recBtn.click();
//		try 
//		{
//			Thread.sleep(5000);
//		} 
//		catch (InterruptedException e) 
//		{
//			e.printStackTrace();
//		}
//		driver.findElementByAccessibilityId("recBtn").click();
//	}
//	
//	@Ignore
//	@Test(priority = 3)
//	public void sendJobOut()
//	{
//		driver.findElementByAccessibilityId("out").click();
//		WebElement workType = driver.findElementByName("Work type\r\n"
//				+ "\r\n"
//				+ "FaxFile noteLetterMemoMobileReportsTest");
////		workType.findElement(By.name("Open")).click();
//		workType.sendKeys("Memo");
//		workType.sendKeys(Keys.TAB);
//		
//		WebElement prio = driver.findElementByName("Priority\r\n"
//				+ "\r\n"
//				+ "P1 [2 hrs]P2 [4 hrs]P3 [8 hrs]P4 [12 hrs]P5 [24 hrs]P6 [2 mins]Test [7 hrs]Test1 [3 mins]");
//		
//		prio.sendKeys("Test [7 hrs]");
//		prio.sendKeys(Keys.TAB);
//		
//		WebElement sendTo = driver.findElementByName("Send to\r\n"
//				+ "\r\n"
//				+ "TypingPrivateAdvanced Speech Recognition");
//		
//		sendTo.sendKeys("Advanced Speech Recognition");
//		sendTo.sendKeys(Keys.TAB);
//		
//		WebElement description = driver.findElementByName("Description");
//		description.sendKeys("Anupeksha Test WinApp 001");
//		
//		driver.findElementByAccessibilityId("dialogConfirmBtn").click();
//	
//		
//
//	}
//
//	@Ignore
//	@Test
//	public void logOff()
//	{
//		driver.findElementByName("Log off").click();
//		try
//		{
//		driver.findElementByAccessibilityId("6").click();
//		}
//		catch(Exception e)
//		{
////			System.out.println(e.getLocalizedMessage());
//		}
//		
//	}
//	
////	@AfterSuite
////	public void tearDown() 
////	{
////		driver.quit();
////	}

}
