package com.mytests;

public class DigDic2 
{
//	public static WindowsDriver<WebElement> driver = null;
////	public static WebDriverWait wait;
//
//	@BeforeSuite
//	public void setUp() 
//	{
//		driver = DDMainFunctions.setUpMethod(driver);
////		wait = new WebDriverWait(driver, 8);
//	}
//
//	@Ignore
//	@Test
//	public void TestCase1() 
//	{
//		
//		DDMainFunctions.aDDLogIn(driver, "PrathuA", "Password@1");
//		DDMainFunctions.recordDictation(driver, 5);
//		String jobName = "Anu_Winapp 004";
//		DDMainFunctions.sendJobOut(driver, "File note", "Test1 [3 mins]", "Advanced Speech Recognition", jobName);
//		WebElement jobFound = DDMainFunctions.ifJobExists(driver, jobName);
//		System.out.println("Row number : " +jobFound.getAttribute("GridItem.Row"));
//	}
//	
//	@Ignore
//	@Test
//	public void TestCase2()
//	{
//		DDMainFunctions.aDDLogIn(driver, "PrathuA", "Password@1");
//		String jobName = "Anu_Winapp 005";
////		String 
//		WebElement jobFound = DDMainFunctions.ifJobExists(driver, jobName);
//		if(jobFound!=null)
//		{
//			String rowNum = jobFound.getAttribute("GridItem.Row");
//			Date d = new Date();
//			String jobDate = DDMainFunctions.getDateVal(d);
//			System.out.println(jobDate);
//			DDMainFunctions.verifyJob(driver, rowNum, jobName, jobDate, "Pending");	
//		}
//		}
//	
//	@Ignore
//	@Test
//	public void TestCase3()
//	{
//		DDMainFunctions.aDDLogIn(driver, "authornew", "Password@1");
//		Date d = new Date();
//		String jobDate = DDMainFunctions.getDateVal(d);
//		WebElement jobsTable = driver.findElementByAccessibilityId("JColResizer0");
//		driver.findElement(By.name("<All dates>"));
//	}
//
//	
//	@Test
//	public void TestCase4()
//	{
//		DDMainFunctions.aDDLogIn(driver, "authornew", "Password@1");
//		DDMainFunctions.recordDictation(driver, 3);
//		String jobName = "Anu_Winapp 016";
//		String createdDate = DDMainFunctions.sendJobOut(driver, "File note", "P5 [24 hrs]", "Typing", jobName);
//	//	String jobName = "Enable sett 011";
//	//	String jobName = "Venkat";
//	//	WebElement job = driver.findElementByName(jobName);		
//	//	Date d = new Date();
//	//	String jobDate = DDMainFunctions.getDateVal(d);
//	//	String createdDate = "17 Nov 11:35";
//		DDMainFunctions.verifyJobWithCreatedDate(driver, createdDate, jobName, "Pending");
//	}
}
//	@AfterSuite
//	public void tearDown() 
//	{
//		driver.quit();
//	}


