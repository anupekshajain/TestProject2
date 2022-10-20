package com.mytests;

import java.io.IOException;

public class cmdTest {
	
	public static void killExisting() throws InterruptedException 
	{
		String BatchFilePath = "killAutInstance.bat";
//		String[] command = {"cmd.exe","cd Documents", BatchFilePath };
		String path = System.getProperty("user.dir")+"\\src\\test\\resources\\"+BatchFilePath;
		Runtime.getRuntime();
		System.out.println("path is : "+path);
		String[] command = { "cmd.exe", path };
		Process p=null;
		try {
//			p = Runtime.getRuntime().exec("C:\\Users\\Anupeksha.Jain\\OneDrive - Advanced\\Automation\\DigitalDictationAutomation-master\\digitalDictation\\src\\test\\resources\\ApplicationUnderTestExe\\killAutInstance.bat");
			p = Runtime.getRuntime().exec(path);
			System.out.println("All App instance killed");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread.sleep(5000);
		p.destroy();
	}

}
