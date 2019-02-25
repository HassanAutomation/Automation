package com.cucumber.automation.steps;

import java.util.List;

import com.cucumber.automation.pages.HomePage;
import com.cucumber.automation.utils.PropertyUtil;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomeSteps {
	HomePage homePage = new HomePage();
	PropertyUtil propUtil = new PropertyUtil();

	@Given("^I am at Hobsons home page$")
	public void i_am_at_Hobsons_home_page() {
		homePage.openHomePage();
	}

	@Then("^I verify that Hobsons Home Page is rendered properly$")
	public void i_verify_that_Hobsons_Home_Page_is_rendered_properly() {
		homePage.verifyHomePageRendered();
	}

	@When("^I hover over \"([^\"]*)\" Menu$")
	public void i_hover_over_Menu(String menu) {
		homePage.hoverOverMenu(menu);

	}

	@Then("^I should see the following dropdown list$")
	public void i_should_see_the_following_dropdown_list(List<String> dropDownList) {
		homePage.verifyMenuDropdownList(dropDownList);

	}

	@Then("^I should not see any dropdown list for menu item \"([^\"]*)\"$")
	public void i_should_not_see_any_dropdown_list(String menu) {
		homePage.verifyNoDropdownList(menu);

	}

	@When("^I click on the Left scroll arrow$")
	public void i_click_on_the_Left_scroll_arrow() {
		homePage.clickLeftScrollArrow();
	}

	@Then("^contents are Left scrolled appropriately$")
	public void contents_are_Left_scrolled_appropriately() {
		homePage.verifyLeftScrollAppropriate();
	}

	@When("^I click on the Right scroll arrow$")
	public void i_click_on_the_Right_scroll_arrow() {
		homePage.clickRightScrollArrow();
	}

	@Then("^contents are Right scrolled appropriately$")
	public void contents_are_Right_scrolled_appropriately() {
		homePage.verifyRightScrollAppropriate();
	}

	/**
	 * This method clicks career link on bottom
	 */
	@When("^I click on Careers at the bottom of home page$")
	public void i_click_on_Careers_at_the_bottom_of_home_page() {
		homePage.clickCareersAtBottom();
	}

}
