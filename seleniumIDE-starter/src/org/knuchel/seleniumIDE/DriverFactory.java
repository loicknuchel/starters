package org.knuchel.seleniumIDE;

import java.io.File;
import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {

	public static WebDriver getChromeDriver() {
		// see http://code.google.com/p/selenium/wiki/ChromeDriver
		System.setProperty("webdriver.chrome.driver", "C:\\Tools\\selenium\\chromedriver.exe");
		ChromeOptions opts = new ChromeOptions();
		opts.addArguments(Arrays.asList("--start-maximized"));
		return  new ChromeDriver(opts);
	}

	public static WebDriver getFirefoxDriver() {
		// see http://code.google.com/p/selenium/wiki/FirefoxDriver
		File firefox = new File("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
		FirefoxProfile firefoxProfile = new FirefoxProfile();
		return new FirefoxDriver(new FirefoxBinary(firefox), firefoxProfile);
	}

	public static WebDriver getIeDriver() {
		// see http://code.google.com/p/selenium/wiki/InternetExplorerDriver
		return new InternetExplorerDriver();
	}
}
