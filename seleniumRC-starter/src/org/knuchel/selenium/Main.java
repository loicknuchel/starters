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
		try {
			State state = State.getInstance();
			state.setWebDriver(webDriver);
			webDriver.get(Urls.getBaseUrl());
			webDriver.get("https://github.com/loicknuchel");
			webDriver.takeScreenshot();

			tests(webDriver);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			webDriver.quit();
		}

		// try {
		// WebDriver driver = new RemoteWebDriver(new URL("https://github.com/loicknuchel"), DesiredCapabilities.firefox());
		// driver.get("http://www.google.com");
		// WebDriver augmentedDriver = new Augmenter().augment(driver);
		// File screenshot = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
		// } catch (MalformedURLException e) {
		// e.printStackTrace();
		// }

		// WebDriver driver = DriverFactory.getChromeDriver().getWebDriver();
		// driver.get("http://www.google.com/");
		// File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// // Now you can do whatever you need to do with it, for example copy somewhere
		// try {
		// FileUtils.copyFile(scrFile, new File("c:\\tmp\\screenshot.png"));
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

	}

	public static void tests(MyWebDriver webdriver) {

	}
}
