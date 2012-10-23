package org.knuchel.selenium;

import org.knuchel.selenium.beans.Env;
import org.knuchel.selenium.config.Config;
import org.knuchel.selenium.config.Urls;
import org.knuchel.selenium.extentions.MyWebDriver;
import org.knuchel.selenium.pages.global.State;
import org.knuchel.selenium.test.ITestcase;
import org.knuchel.selenium.test.TestAddRemoveComputer;
import org.knuchel.selenium.test.TestFindComputerInList;
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

			Thread.sleep(1 * 1000);
		} catch (Exception e) {
			String logError = state.logError(e);
			System.out.println("GLOBAL ERROR: see " + logError + " for more informations");
			e.printStackTrace();
		} finally {
			webDriver.quit();
		}

	}

	public static void tests() {
//		test(TestSimple.class);
		 test(TestFindComputerInList.class);
		 test(TestAddRemoveComputer.class);
	}

	private static void test(Class<? extends ITestcase> clazz) {
		String testName = clazz.getSimpleName();
		try {
			long start = System.currentTimeMillis();
			ITestcase testCase = clazz.newInstance();
			testCase.start();
			long end = System.currentTimeMillis();
			System.out.println("OK   : " + testName + " passed in " + ((end - start) / 1000) + " seconds.");
		} catch (Exception e) {
			State state = State.getInstance();
			String logError = state.logError(e);
			System.out.println("FAIL : " + testName + " has errors (see " + logError + " for more informations)");
			e.printStackTrace();
			// on retourne au point de départ
			state.getWebDriver().get(Urls.getBaseUrl());
		}
	}
}
