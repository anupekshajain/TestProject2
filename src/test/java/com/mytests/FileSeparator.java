package com.mytests;

import java.io.File;
import java.util.Date;



public class FileSeparator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(System.getProperty("user.dir")+File.separator);
		final String REPORTS = "reports";
		final String SCREENSHOTS = "screenshots";
		final String SCREENSHOTSPATH = REPORTS + File.separator + SCREENSHOTS;
		System.out.println("SCREENSHOTSPATH : "+SCREENSHOTSPATH);
		String screenshotPath = SCREENSHOTSPATH + File.separator + FileDriver.getFormattedDate(new Date(), "dd_MMMM_yyyy_HH_mm_ss") + ".jpg";
		System.out.println("screenshotPath : "+screenshotPath);
		String rtnString = screenshotPath.replace(screenshotPath, SCREENSHOTS + screenshotPath.split(SCREENSHOTS)[1]);
		System.out.println("Return Value : "+rtnString);
		String splitVal = REPORTS+File.separator;
		System.out.println(screenshotPath.split(splitVal)[0]);
	}

}
