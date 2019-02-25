package com.cucumber.automation.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverUtil {

	static private WebDriver driver;

	public static WebDriver getWebDriver() {
		if (driver == null) {
			initDriver();
		}
		return driver;
	}

	public static void initDriver() {
		PropertyUtil propertyUtil = new PropertyUtil();
		String browser = propertyUtil.getProperty("selenium.browser");

		if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
			driver = new ChromeDriver();
		} else {
			driver = new FirefoxDriver();
		}
	}

}