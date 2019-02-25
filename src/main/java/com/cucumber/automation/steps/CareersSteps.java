package com.cucumber.automation.steps;

import com.cucumber.automation.pages.CareersPage;
import com.cucumber.automation.utils.PropertyUtil;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CareersSteps {
	CareersPage careersPage = new CareersPage();
	PropertyUtil propUtil = new PropertyUtil();

	@Then("^I verify that I am taken to the careers page$")
	public void i_verify_that_I_am_taken_to_the_careers_page() {
		careersPage.verifyCareersPage();
	}

	@Then("^I verify that \"([^\"]*)\" address is:$")
	public void i_verify_that_address_is(String arg1, String address) {
		careersPage.verifyAddress(address);
	}

	@When("^I click on \"([^\"]*)\" address$")
	public void i_click_on_address(String address) {
		careersPage.clickAddress(address);
	}

}
