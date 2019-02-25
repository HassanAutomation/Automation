package com.cucumber.automation.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertyUtil {
	static Properties prop = new Properties();

	public PropertyUtil() {
		try {
			prop.load(new FileInputStream(new File(
					System.getProperty("user.dir") + "//src//test//resources//config//config.properties")));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getProperty(String key) {
		return prop.getProperty(key);
	}

}
