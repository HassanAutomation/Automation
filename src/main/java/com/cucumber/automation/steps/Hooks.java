package com.cucumber.automation.steps;

import com.cucumber.automation.utils.DriverUtil;
import com.cucumber.automation.utils.PropertyUtil;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	PropertyUtil propUtil = new PropertyUtil();

	@Before
	public void setUP() {
		setUp();
	}

	private void setUp() {
		DriverUtil.initDriver();
	}

	@After
	public void quit() {
		DriverUtil.getWebDriver().quit();
	}

}
