package org.knuchel.selenium;

import org.knuchel.selenium.beans.Env;
import org.knuchel.selenium.config.Config;
import org.knuchel.selenium.config.Urls;
import org.knuchel.selenium.extentions.MyWebDriver;
import org.knuchel.selenium.pages.global.State;
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

	}
}
