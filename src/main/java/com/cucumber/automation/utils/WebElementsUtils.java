package com.cucumber.automation.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebElementsUtils {

	public String getScreenshotName() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		Calendar cal = Calendar.getInstance();
		return (dateFormat.format(cal.getTime()).toString());
	}

	public boolean isPresent(String loc) {
		try {
			DriverUtil.getWebDriver().findElement(By.xpath(loc));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public void jsClick(WebElement element){
		JavascriptExecutor executor = (JavascriptExecutor)DriverUtil.getWebDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public boolean isDisplayed(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(DriverUtil.getWebDriver(), 10);
			wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public void moveToElement(WebElement element){
		Actions action = new Actions(DriverUtil.getWebDriver());
		action.moveToElement(element).perform();
	}

	public String getScreenshot() {
		String name = getScreenshotName();
		name = name + ".png";
		File scrFile = ((TakesScreenshot) DriverUtil.getWebDriver()).getScreenshotAs(OutputType.FILE);
		System.out.println("====>" + scrFile);

		try {
			File f = new File("Report\\" + name);
			System.err.println(f);
			FileUtils.copyFile(scrFile, f);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return name;
	}
}
