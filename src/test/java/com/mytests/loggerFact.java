package com.mytests;

import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class loggerFact {
	public static void main(String args[]) {
		
		PropertyConfigurator.configure(System.getProperty("user.dir"));
		Logger logg = LoggerFactory.getLogger(loggerFact.class);
		logg.info("My first Log");
		logg.debug("SOmething went wrong");
	}

}
