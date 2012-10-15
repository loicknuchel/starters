package org.knuchel.selenium.pages;

import org.knuchel.selenium.extentions.MyWebDriver;
import org.knuchel.selenium.pages.global.State;

public abstract class MyAbstractPage {
	protected MyWebDriver webDriver;
	protected State state;

	public MyAbstractPage(MyWebDriver webDriver) {
		this.webDriver = webDriver;
		this.state = State.getInstance();
	}
	
	public abstract void loadDatas();

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
