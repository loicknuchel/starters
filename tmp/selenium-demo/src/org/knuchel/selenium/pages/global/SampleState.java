package org.knuchel.selenium.pages.global;

import org.knuchel.selenium.extentions.MyWebDriver;
import org.knuchel.selenium.pages.MyAbstractPage;

/**
 * This is a sample class
 * 
 * @author knuchel
 * 
 */
public class SampleState implements ILoadState {
	private MyAbstractPage page;

	public SampleState(MyAbstractPage page) {
		this.page = page;
	}

	@Override
	public void load(State state, MyWebDriver webdriver) {
		// TODO load all sections needed for the page
	}

	@Override
	public MyAbstractPage getPage() {
		return page;
	}

}
