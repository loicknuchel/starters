package org.knuchel.selenium.pages.global;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.knuchel.selenium.config.Config;
import org.knuchel.selenium.config.Urls;
import org.knuchel.selenium.extentions.MyWebDriver;
import org.knuchel.selenium.pages.ComputerEditPage;
import org.knuchel.selenium.pages.ComputerListPage;
import org.knuchel.selenium.pages.ComputerPage;
import org.knuchel.selenium.pages.MyAbstractPage;
import org.knuchel.selenium.utils.MyStringUtils;

public class State {
	private static State INSTANCE = new State();
	private MyWebDriver webDriver;

	private State() {
	}

	public static State getInstance() {
		return INSTANCE;
	}

	public void setWebDriver(MyWebDriver webdriver) {
		this.webDriver = webdriver;
	}

	public MyWebDriver getWebDriver() {
		isWebDriver();
		return webDriver;
	}

	public MyAbstractPage getPage() {
		String url = webDriver.getCurrentUrl();
		if (Urls.isComputerListUrl(url)) {
			return new ComputerListPage(webDriver);
		} else if (Urls.isNewComputerUrl(url)) {
			return new ComputerPage(webDriver);
		} else if (Urls.isComputerUrl(url)) {
			return new ComputerEditPage(webDriver);
		}
		throw new IllegalStateException("Unknown state !");
	}

	public String logError(Exception e) {
		isWebDriver();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss.S");
		String fileName = Config.ASSETS + "\\error_" + df.format(new Date());
		String ret = fileName + ".txt";
		try {
			webDriver.takeScreenshot(fileName + ".png");
			FileUtils.writeStringToFile(new File(fileName + ".txt"), MyStringUtils.convert(e));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return ret;
	}

	private void isWebDriver() {
		if (webDriver == null) {
			throw new IllegalStateException("You have to set a webdriver before using this class !");
		}
	}
}
