package com.mytests;

import java.io.IOException;

public class REstartSErvice {
	
	public static void killExisting() throws InterruptedException 
	{
		String BatchFilePath = "C:\\Users\\Anupeksha.Jain\\OneDrive - Advanced\\Automation Tech for ALB\\Latest code 8th Jun\\stopLegalTaskScheduler.bat";
		Process p=null;
		try {
//			p = Runtime.getRuntime().exec("C:\\Users\\Anupeksha.Jain\\OneDrive - Advanced\\Automation\\DigitalDictationAutomation-master\\digitalDictation\\src\\test\\resources\\ApplicationUnderTestExe\\killAutInstance.bat");
			p = Runtime.getRuntime().exec(BatchFilePath);
			System.out.println("Stopped services");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p.destroy();
	}

}
