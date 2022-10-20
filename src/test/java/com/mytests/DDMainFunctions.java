package com.mytests;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;

public class DDMainFunctions 
{
	public static WindowsDriver<WebElement> setUpMethod(WindowsDriver<WebElement> driver)
	{
		DesiredCapabilities capb = new DesiredCapabilities();
		capb.setCapability("app", "C:\\Program Files (x86)\\Advanced Digital Dictation\\Layer App\\OyezSpeech7.exe");
		capb.setCapability("platformName", "Windows");
		capb.setCapability("deviceName", "WindowsPC");
		try 
		{
			driver = new WindowsDriver<WebElement>(new URL("http://127.0.0.1:4723"), capb);
		} 
		catch (MalformedURLException e) 
		{
//			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		return driver;
		
		}
	
	public static void aDDLogIn(WindowsDriver<WebElement> driver, String username, String password)
	{
		WebElement userN = DDMainFunctions.dynamicWaitConditional(driver, "accessibilityId", "UserName");
		userN.sendKeys(username);
		driver.findElementByAccessibilityId("Password").sendKeys(password);
		driver.findElementByName("Submit").click();
		WebElement recoveredOk = DDMainFunctions.dynamicWaitConditional(driver, "name", "Ok");
		if(recoveredOk!=null)
		{
			recoveredOk.click();		
		}
	}
	
	public static void recordDictation(WindowsDriver<WindowsElement> driver, int length)
	{
//		WebElement defaultBtn = driver.findElementByName("Default");
		WebElement recBtn = driver.findElementByAccessibilityId("recBtn");
//		DDMainFunctions.dynamicallyWaitforElement(driver, recBtn);
		recBtn.click();
		DDMainFunctions.waitForSeconds(length);
		recBtn.click();
	}
	
	public static String sendJobOut(WindowsDriver<WebElement> driver, String workTyp, String prior, String sendT, String desc)
	{
		driver.findElementByAccessibilityId("out").click();
		WebElement workType = driver.findElementByName("Work type\r\n"
				+ "\r\n"
				+ "FaxFile noteLetterMemoMobileReportsTest");
		workType.sendKeys(workTyp);
		workType.sendKeys(Keys.TAB);
		
		WebElement prio = driver.findElementByName("Priority\r\n"
				+ "\r\n"
				+ "P1 [2 hrs]P2 [4 hrs]P3 [8 hrs]P4 [12 hrs]P5 [24 hrs]P6 [2 mins]Test [7 hrs]Test1 [3 mins]");
		
		prio.sendKeys(prior);
		prio.sendKeys(Keys.TAB);
		
		WebElement sendTo = driver.findElementByName("Send to\r\n"
				+ "\r\n"
				+ "TypingPrivateAdvanced Speech Recognition");
		
		sendTo.sendKeys(sendT);
		sendTo.sendKeys(Keys.TAB);
		
		WebElement description = driver.findElementByName("Description");
		description.sendKeys(desc);
		
		driver.findElementByAccessibilityId("dialogConfirmBtn").click();
		Date d = new Date();
		TimeZone.setDefault(TimeZone.getTimeZone("Europe/London"));
		return DDMainFunctions.getDateVal(d);
	}
	
	public static void logOff(WindowsDriver<WebElement> driver)
	{
		driver.findElementByName("Log off").click();
		try
		{
		driver.findElementByAccessibilityId("6").click();
		}
		catch(Exception e)
		{
//			System.out.println(e.getLocalizedMessage());
		}
	}
	
	public static void dynamicallyWaitforElement(WindowsDriver<WebElement> driver, WebElement ele)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	public static WebElement dynamicWaitConditional(WindowsDriver<WebElement> driver, String attribute, String attValue)
	{
		WebElement ele;
		for(int i=0; i<2;i++)
		{
			try 
			{
				switch(attribute)
				{
				case "name":
					ele = driver.findElementByName(attValue);
					return ele;
				case "accessibilityId":
					ele = driver.findElementByAccessibilityId(attValue);
					return ele;
				}		
				break;
			} 
			catch (Exception e)
			{
				try 
				{
					Thread.sleep(1000);
				} 
				catch (InterruptedException e1) 
				{
					e1.printStackTrace();
				}
			}
		}
		return null;
	}
	
	public static void waitForSeconds(int length)
	{
		try {
			Thread.sleep(length*1000);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
	
	public static WebElement ifJobExists(WindowsDriver<WebElement> driver, String jobDesc)
	{
		WebElement ele = null;
		try
		{
			ele = driver.findElementByName(jobDesc);
			System.out.println("Passed : Job - " +jobDesc+" exist in the list");
			return ele;
		}
		catch(Exception e)
		{
			System.out.println("Failed : Job - " +jobDesc+" does not exist in the list");
			return null;
		}
	}
	
	public static void verifyJob(WindowsDriver<WebElement> driver, String row, String jobDesc, String date1,String jobStatus)
	{
		WebElement jobsTable = driver.findElementByAccessibilityId("JColResizer0");
		if(findRowData(jobsTable, jobDesc, row) !=null && findRowData(jobsTable, jobStatus, row)!=null )
		{
				System.out.println("PASSED : Mentioned job is verified and is at the row number : "+ findRowData(jobsTable, jobDesc,row).getAttribute("GridItem.Row"));
		}
		else
		{
			System.out.println("FAILED : Mentioned job is not verified");
		}
	}

	
	public static WebElement findRowData(WebElement jTable, String jobDetails, String rowNo)
	{
		List<WebElement> jobsList = jTable.findElements(By.name(jobDetails));
//		System.out.println("Num of jobs : "+ jobsList.size());
		int j, rowInd;
		for(j=0; j<jobsList.size(); j++)
		{
			rowInd = Integer.parseInt(jobsList.get(j).getAttribute("GridItem.Row"));
			if( rowInd>0 && rowInd == Integer.parseInt(rowNo))
			{
				return jobsList.get(j);
			}
		}
		return null;
	}
	
	public static String getDateVal(Date d)
	{
//		SimpleDateFormat yr = new SimpleDateFormat("YYYY");
		SimpleDateFormat month_date = new SimpleDateFormat("MMM");
		SimpleDateFormat dateV = new SimpleDateFormat("dd");
		SimpleDateFormat min = new SimpleDateFormat("mm");
		SimpleDateFormat hr = new SimpleDateFormat("HH");
		String dateVal = dateV.format(d);
		//dateVal = String.valueOf(Integer.parseInt(dateVal));
		String hrVal = hr.format(d);
		String mmVal = min.format(d);
		if(Integer.parseInt(dateVal)<10)
		{
			dateVal = dateVal.replace("0", "");
		}
	//		return (d.getDay()+"/"+d.getMonth()+"/"+(d.getYear()+1900) + " " + d.getHours()+":"+d.getMinutes())	;
		return (Integer.parseInt(dateVal)+" "+month_date.format(d)+ " " + Integer.parseInt(hrVal)+":"+Integer.parseInt(mmVal));
	}
	//Edited
	public static void verifyJobWithCreatedDate(WindowsDriver<WebElement> driver, String createdDate, String jobName, String expectedJobStatus)
	{
		WebElement jobcreatedD = DDMainFunctions.ifJobExists(driver, createdDate);
		if(jobcreatedD!=null)
		{
		String rowN = jobcreatedD.getAttribute("GridItem.Row");
		System.out.println(rowN);
		String jobStatus="";
		String descRow = (driver.findElementByName(jobName).getAttribute("GridItem.Row"));
		if(Integer.parseInt(descRow)==Integer.parseInt(rowN))
		{
			List<WebElement> jobs = driver.findElementsByName(expectedJobStatus);
			for(int i=0; i<jobs.size(); i++)
			{
				if(Integer.parseInt(jobs.get(i).getAttribute("GridItem.Row"))== Integer.parseInt(rowN))
				{
					jobStatus= jobs.get(i).getText();
					break;
				}
			}
			if(jobStatus.equals(expectedJobStatus))
			{
				System.out.println("PASSED VERIFICATION");
			}
			else
			{
				System.out.println("FAILED VERIFICATION : Status of the given description mismatch");
			}
		}
		else
		{
			System.out.println("FAILED VERIFICATION : Description and Created Date mismatch");
		}
		}
		else
		{
			System.out.println("FAILED VERIFICATION : Description does not exist");
		}
	
	}
}
