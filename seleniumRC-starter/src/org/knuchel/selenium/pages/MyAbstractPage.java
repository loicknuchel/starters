package org.knuchel.selenium.pages;

import java.util.ArrayList;
import java.util.List;

import org.knuchel.selenium.config.Config;
import org.knuchel.selenium.extentions.MyBy;
import org.knuchel.selenium.extentions.MyWebDriver;
import org.knuchel.selenium.extentions.MyWebElement;
import org.knuchel.selenium.pages.global.State;

public abstract class MyAbstractPage {
	protected MyWebDriver webdriver;
	protected State state;

	public MyAbstractPage(MyWebDriver webdriver) {
		this.webdriver = webdriver;
		this.state = State.getInstance();
	}

	public MyAbstractPage pause(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return this;
	}

	public static class DOM {
		
	}
}
