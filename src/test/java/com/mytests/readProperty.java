package com.mytests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class readProperty {
	@Test
	public void read() throws IOException {
		String path = "C:\\Users\\Anupeksha.Jain\\eclipse-workspace\\WinAppDriverSample\\credentials.properties";
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(path);
		prop.load(fis);
		
		String email = prop.getProperty("user2");
		System.out.println("Value is : "+email);
		if(email.equals(""))
		{
			System.out.println("true");
		}
		
		String pswd = System.getProperty("userPassword");
		System.out.println(pswd);
	}
}
