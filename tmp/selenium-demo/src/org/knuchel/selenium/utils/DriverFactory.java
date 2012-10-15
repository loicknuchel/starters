package org.knuchel.selenium.utils;

import java.io.File;
import java.util.Arrays;

import org.knuchel.selenium.config.Config;
import org.knuchel.selenium.extentions.MyWebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.opera.core.systems.OperaDriver;
import com.opera.core.systems.arguments.OperaArgument;

public class DriverFactory {
	public static MyWebDriver getDriver() {
		if (Config.DRIVER.equals(Config.Driver.CHROME)) {
			return getChromeDriver();
		} else if (Config.DRIVER.equals(Config.Driver.FIREFOX)) {
			return getFirefoxDriver();
		} else if (Config.DRIVER.equals(Config.Driver.OPERA)) {
			return getOperaDriver();
		} else if (Config.DRIVER.equals(Config.Driver.IE)) {
			return getIeDriver();
		} else {
			throw new IllegalStateException("Unknown driver " + Config.DRIVER);
		}
	}

	public static MyWebDriver getChromeDriver() {
		// see http://code.google.com/p/selenium/wiki/ChromeDriver
		System.setProperty("webdriver.chrome.driver", Config.LocalPathTo.CHROME_DRIVER);
		ChromeOptions opts = new ChromeOptions();
		opts.addArguments(Arrays.asList("--start-maximized"));
		WebDriver webDriver = new ChromeDriver(opts);
		return new MyWebDriver(webDriver);
	}

	public static MyWebDriver getFirefoxDriver() {
		// see http://code.google.com/p/selenium/wiki/FirefoxDriver
		File firefox = new File(Config.LocalPathTo.FIREFOX_BROWSER);
		FirefoxProfile firefoxProfile = new FirefoxProfile();
		WebDriver webDriver = new FirefoxDriver(new FirefoxBinary(firefox), firefoxProfile);
		// WebDriver webDriver = new FirefoxDriver();
		return new MyWebDriver(webDriver);
	}

	public static MyWebDriver getOperaDriver() {
		// POM dependency : see http://seleniumhq.org/docs/03_webdriver.html#java and http://code.google.com/p/selenium/wiki/OperaDriver
		OperaDriver webDriver = new OperaDriver();
		return new MyWebDriver(webDriver);
	}

	public static MyWebDriver getIeDriver() {
		// see http://code.google.com/p/selenium/wiki/InternetExplorerDriver
		InternetExplorerDriver webDriver = new InternetExplorerDriver();
		return new MyWebDriver(webDriver);
		// throw new IllegalStateException("IeDriver is not implemented !");
	}
}
