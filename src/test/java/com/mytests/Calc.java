package com.mytests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.windows.WindowsDriver;

public class Calc {
    public static void main(String[] args) {
        DesiredCapabilities dc = new DesiredCapabilities();
        //dc.setCapability("app", "C:\\Windows\\System32\\calc.exe"); 
        dc.setCapability("app","Microsoft.WindowsCalculator_8wekyb3d8bbwe!App");

        WindowsDriver<WebElement> driver=null;
        try {
            driver = new WindowsDriver<WebElement>(new URL("http://127.0.0.1:4723/"), dc);
        } catch (MalformedURLException e1) {
            e1.printStackTrace();
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.quit();
    }
}