package com.cucumber.automation.pages;

import java.util.ArrayList;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.automation.utils.DriverUtil;
import com.cucumber.automation.utils.WebElementsUtils;

public class GoogleMapsPage {
	DriverUtil driverUtil = new DriverUtil();
	WebElementsUtils webElementsUtils = new WebElementsUtils();

	@FindBy(css = "#searchboxinput")
	private WebElement searchBox;

	WebDriver driver;

	public GoogleMapsPage() {
		driver = DriverUtil.getWebDriver();
		PageFactory.initElements(driver, this);
	}

	public void verifyGoogleMapsPage() {
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		Assert.assertTrue("Google map page not rendered properly", webElementsUtils.isDisplayed(searchBox));
	}

	public void verifyLocationGoogleMapsPage(String location) {
		System.out.println(searchBox.getAttribute("value"));
		System.out.println(location);
		Assert.assertTrue("", searchBox.getAttribute("value").equalsIgnoreCase(location));
	}

}
