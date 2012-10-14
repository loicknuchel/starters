package org.knuchel.selenium;

import org.knuchel.selenium.beans.Env;
import org.knuchel.selenium.config.Config;
import org.knuchel.selenium.config.Urls;
import org.knuchel.selenium.extentions.MyWebDriver;
import org.knuchel.selenium.pages.global.State;
import org.knuchel.selenium.test.TestSample;
import org.knuchel.selenium.utils.DriverFactory;

public class Main {
	public static void main(String[] args) {
		Config.ENV = Env.LOCAL;
		Config.DRIVER = Config.Driver.CHROME;
		Config.ASSETS = "C:\\tmp";
		MyWebDriver webDriver = DriverFactory.getDriver();
		State state = State.getInstance();
		try {
			state.setWebDriver(webDriver);
			webDriver.get(Urls.getBaseUrl());

			tests(webDriver);

			Thread.sleep(3000);
		} catch (Exception e) {
			state.logError(e);
			e.printStackTrace();
		} finally {
			webDriver.quit();
		}

	}

	public static void tests(MyWebDriver webDriver) {
		TestSample testSample = new TestSample(webDriver);
		testResult("TestSample", testSample.start(), System.currentTimeMillis());
	}

	public static void testResult(String testName, String result, long start) {
		long end = System.currentTimeMillis();
		if (result == null) {
			System.out.println("OK   : " + testName + " passed in " + ((end - start) / 1000) + " seconds.");
		} else {
			System.out.println("FAIL : " + testName + " has errors on " + result);
		}
	}
}
