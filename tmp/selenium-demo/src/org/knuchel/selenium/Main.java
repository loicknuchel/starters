package org.knuchel.selenium;

import org.knuchel.selenium.beans.Env;
import org.knuchel.selenium.config.Config;
import org.knuchel.selenium.config.Urls;
import org.knuchel.selenium.extentions.MyWebDriver;
import org.knuchel.selenium.pages.global.State;
import org.knuchel.selenium.test.ITestcase;
import org.knuchel.selenium.test.TestAddRemoveComputer;
import org.knuchel.selenium.test.TestComputerList;
import org.knuchel.selenium.utils.DriverFactory;

public class Main {
	public static void main(String[] args) {
		Config.ENV = Env.LOCAL;
		Config.DRIVER = Config.Driver.CHROME;
		Config.ASSETS = "C:\\tmp";
		MyWebDriver webDriver = DriverFactory.getDriver();
		State state = State.getInstance();
		state.setWebDriver(webDriver);
		try {
			webDriver.get(Urls.getBaseUrl());

			tests();
			// ComputerListPage computerListPage = new ComputerListPage(webDriver);
			//
			// computerListPage.goAddComputer().setComputerDatas("AAA", "1900-05-23", "1999-12-12", "Cray").submitComputerForm();
			// System.out.println("Computer created: " + computerListPage.isComputerAdded("AAA"));
			// computerListPage.filter("AAA").getComputer(0).goComputerPage();
			// ComputerEditPage computerEditPage = new ComputerEditPage(webDriver);
			//
			// System.out.println("Computer deleted: " + computerEditPage.deleteComputer().isComputerDeleted());

			Thread.sleep(1 * 1000);
		} catch (Exception e) {
			state.logError(e);
			e.printStackTrace();
		} finally {
			webDriver.quit();
		}

	}

	public static void tests() {
		test(TestComputerList.class);
		test(TestAddRemoveComputer.class);
	}

	private static void test(Class<? extends ITestcase> clazz) {
		String result = "init", testName = "UnknownTest";
		long start = 0, end = 0;
		try {
			testName = clazz.getSimpleName();
			start = System.currentTimeMillis();
			ITestcase testCase = clazz.newInstance();
			result = testCase.start();
			end = System.currentTimeMillis();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (result == null) {
			System.out.println("OK   : " + testName + " passed in " + ((end - start) / 1000) + " seconds.");
		} else {
			System.out.println("FAIL : " + testName + " has errors on " + result);
		}
	}
}
