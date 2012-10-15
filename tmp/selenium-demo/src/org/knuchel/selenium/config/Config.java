package org.knuchel.selenium.config;

import org.knuchel.selenium.beans.Env;

public class Config {
	public static String SEP = "\\";
	public static Env ENV = Env.LOCAL;
	public static String DRIVER = Driver.CHROME;
	public static String ASSETS = "C:" + SEP + "tmp";

	public static class LocalPathTo {
		// can be downloaded here :
		// http://code.google.com/p/selenium/wiki/ChromeDriver
		public static final String CHROME_DRIVER = "C:" + SEP + "Tools" + SEP + "selenium" + SEP + "chromedriver.exe";
		// can be downloaded here :
		// http://code.google.com/p/selenium/wiki/InternetExplorerDriver
		public static final String IE_DRIVER = "C:" + SEP + "Tools" + SEP + "selenium" + SEP + "IEDriverServer.exe";
		public static final String FIREFOX_BROWSER = "C:" + SEP + "Program Files" + SEP + "Mozilla Firefox" + SEP + "firefox.exe";
	}

	public static class Driver {
		public static final String CHROME = "chrome";
		public static final String FIREFOX = "firefox";
		public static final String OPERA = "opera";
		public static final String IE = "ie";
	}
}
