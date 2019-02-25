package com.cucumber.automation.pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.automation.utils.DriverUtil;
import com.cucumber.automation.utils.PropertyUtil;
import com.cucumber.automation.utils.WebElementsUtils;

public class HomePage {

	private static final String XPATH_MENU = "//nav/ul/li/a[text()='%s']";
	private static final String XPATH_MENU_ITEMS = "//nav/ul/li/a[text()='%s']/following-sibling::ul/li//a";
	private static final String XPATH_TITLE_COMPONENT = "//ul[@id='home-carousel']//div[@class='owl-stage']/div[@class='owl-item active']//h4[text()='%s']";

	static String titleOfLeftMostComponent;
	static String titleOfRightMostComponent;

	@FindBy(css = "#logo")
	private WebElement logo;

	@FindBy(css = ".pagetitle.c")
	private WebElement pageTitle;

	@FindBy(xpath = "//ul[@id='home-carousel']//div[@class='owl-stage']/div[@class='owl-item active']//h4")
	private List<WebElement> activeComponentOnScreen;

	@FindBy(xpath = "//ul[@id='home-carousel']//div[@class='owl-prev']")
	private WebElement leftScrollButton;

	@FindBy(xpath = "//ul[@id='home-carousel']//div[@class='owl-next']")
	private WebElement rightScrollButton;

	@FindBy(xpath = "//div[@class='sitemap']//ul//li/a[text()='Careers']")
	private WebElement careerLink;

	PropertyUtil propertyUtil = new PropertyUtil();
	WebElementsUtils webElementsUtils = new WebElementsUtils();

	WebDriver driver;

	public HomePage() {
		driver = DriverUtil.getWebDriver();
		PageFactory.initElements(driver, this);
	}

	public void openHomePage() {
		driver.get(propertyUtil.getProperty("env.baseurl"));
		driver.manage().window().maximize();
	}

	public void verifyHomePageRendered() {
		Assert.assertTrue("Logo is not displayed on home page", webElementsUtils.isDisplayed(logo));
		Assert.assertTrue("Home page title is not displayed", webElementsUtils.isDisplayed(pageTitle));
	}

	public void hoverOverMenu(String menu) {
		String loc = String.format(XPATH_MENU, menu);
		webElementsUtils.moveToElement(driver.findElement(By.xpath(loc)));
	}

	public void verifyMenuDropdownList(List<String> dropDownList) {
		String loc = String.format(XPATH_MENU_ITEMS, dropDownList.get(0));
		List<WebElement> menuItemList = driver.findElements(By.xpath(loc));
		for (int i = 1; i < dropDownList.size(); i++) {
			Assert.assertTrue(dropDownList.get(i) + " not displayed",
					menuItemList.get(i - 1).getText().equalsIgnoreCase(dropDownList.get(i)));
		}
	}

	public void verifyNoDropdownList(String menu) {
		String loc = String.format(XPATH_MENU_ITEMS, menu);
		List<WebElement> menuItemList = driver.findElements(By.xpath(loc));
		Assert.assertTrue(menu + " still has menu items", menuItemList.size() == 0);
	}

	public void clickLeftScrollArrow() {
		titleOfLeftMostComponent = activeComponentOnScreen.get(0).getText();
		try {
			leftScrollButton.click();
		} catch (Exception e) {
			webElementsUtils.jsClick(leftScrollButton);
		}

	}

	public void verifyLeftScrollAppropriate() {
		String loc = String.format(XPATH_TITLE_COMPONENT, titleOfLeftMostComponent);
		Assert.assertTrue("Content are not scrolled left properly", !webElementsUtils.isPresent(loc));
	}

	public void clickRightScrollArrow() {
		titleOfRightMostComponent = activeComponentOnScreen.get(activeComponentOnScreen.size() - 1).getText();
		try {
			rightScrollButton.click();
		} catch (Exception e) {
			webElementsUtils.jsClick(rightScrollButton);
		}
	}

	public void verifyRightScrollAppropriate() {
		String loc = String.format(XPATH_TITLE_COMPONENT, titleOfRightMostComponent);
		Assert.assertTrue("Content are not scrolled left properly", !webElementsUtils.isPresent(loc));
	}

	public void clickCareersAtBottom() {
		try {
			careerLink.click();
		} catch (Exception e) {
			webElementsUtils.jsClick(careerLink);
		}
	}

}
