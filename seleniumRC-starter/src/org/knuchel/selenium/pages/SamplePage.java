package org.knuchel.selenium.pages;

import org.knuchel.selenium.extentions.MyWebDriver;
import org.knuchel.selenium.extentions.MyWebElement;


public class SamplePage extends MyAbstractPage {
	public SamplePage(MyWebDriver webDriver) {
		super(webDriver);
	}

	public static class DOM {
		public static MyWebElement getGlobalPage(MyWebDriver webDriver) {
			return webDriver.findElement("body");
		}

	}
}
