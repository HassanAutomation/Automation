package com.cucumber.automation.steps;

import com.cucumber.automation.pages.GoogleMapsPage;
import com.cucumber.automation.utils.PropertyUtil;

import cucumber.api.java.en.Then;

public class GoogleMapsSteps {
	GoogleMapsPage googleMapsPage = new GoogleMapsPage();
	PropertyUtil propUtil = new PropertyUtil();

	@Then("^I verify that I am taken to google maps page$")
	public void i_verify_that_I_am_taken_to_google_maps_page() {
		googleMapsPage.verifyGoogleMapsPage();

	}

	@Then("^the location at google maps is:$")
	public void the_location_at_google_maps_is(String location) {
		googleMapsPage.verifyLocationGoogleMapsPage(location);
	}

}
