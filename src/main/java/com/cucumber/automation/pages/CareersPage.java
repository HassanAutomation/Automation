package com.cucumber.automation.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.automation.utils.DriverUtil;
import com.cucumber.automation.utils.WebElementsUtils;

public class CareersPage {

	private static final String XPATH_ADDRESS_LINK = "//section[@id='careers-locations']//table//tr/td//a[text()='%s']";
	
	@FindBy(xpath = "//ul[@class='tabs']//a[text()='Open positions']")
	private WebElement btnOpenPosition;

	DriverUtil driverUtil = new DriverUtil();
	WebElementsUtils webElementsUtils = new WebElementsUtils();
	WebDriver driver;

	public CareersPage() {
		driver = DriverUtil.getWebDriver();
		PageFactory.initElements(driver, this);
	}

	public void verifyCareersPage() {
		Assert.assertTrue("Career page not rendered properly", webElementsUtils.isDisplayed(btnOpenPosition));
	}

	public void verifyAddress(String address) {
		
	}

	public void clickAddress(String address) {
		String loc = String.format(XPATH_ADDRESS_LINK, address);
		try{
		driver.findElement(By.xpath(loc)).click();
		}catch(Exception e){
			webElementsUtils.jsClick(driver.findElement(By.xpath(loc)));
		}
		
	}

}
