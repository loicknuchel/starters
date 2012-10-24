package org.knuchel.selenium.extentions;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.knuchel.selenium.config.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyWebDriver implements WebDriver, JavascriptExecutor {
	private WebDriver webDriver;
	private JavascriptExecutor js;
	private TakesScreenshot screenshot;

	public MyWebDriver(WebDriver webDriver) {
		this.webDriver = webDriver;
		this.js = (JavascriptExecutor) webDriver;
		this.screenshot = (TakesScreenshot) webDriver;
	}

	public void get(String url) {
		webDriver.get(url);
	}

	public String getCurrentUrl() {
		return webDriver.getCurrentUrl();
	}

	public String getTitle() {
		return webDriver.getTitle();
	}

	public List<WebElement> findElements(By by) {
		return webDriver.findElements(by);
	}

	public MyWebElement findElement(By by) {
		return new MyWebElement(webDriver.findElement(by));
	}

	public MyWebElement findElement(String selector) {
		// TODO
		throw new IllegalStateException("not implemented !");
	}

	public String getPageSource() {
		return webDriver.getPageSource();
	}

	public void close() {
		webDriver.close();
	}

	public void quit() {
		webDriver.quit();
	}

	public Set<String> getWindowHandles() {
		return webDriver.getWindowHandles();
	}

	public String getWindowHandle() {
		return webDriver.getWindowHandle();
	}

	public TargetLocator switchTo() {
		return webDriver.switchTo();
	}

	public Navigation navigate() {
		return webDriver.navigate();
	}

	public Options manage() {
		return webDriver.manage();
	}

	public void takeScreenshot(String path) throws IOException {
		File scrFile = screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(path));
	}

	public void takeScreenshot() throws IOException {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss.S");
		takeScreenshot(Config.ASSETS + "\\screenshot_" + df.format(new Date()) + ".png");
	}

	public Object executeScript(String script, Object... args) {
		return js.executeScript(script, args);
	}

	public Object executeAsyncScript(String script, Object... args) {
		return js.executeAsyncScript(script, args);
	}

	public void scrollTop() {
		js.executeScript("window.scrollTo(0,0);", new Object[] {});
	}

	public WebDriver getWebDriver() {
		return webDriver;
	}

	public JavascriptExecutor getJavascriptExecutor() {
		return js;
	}

	public TakesScreenshot getScreenshotDriver() {
		return screenshot;
	}

	@Override
	public String toString() {
		return webDriver.toString();
	}
}
