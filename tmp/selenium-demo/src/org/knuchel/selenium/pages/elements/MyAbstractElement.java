package org.knuchel.selenium.pages.elements;

import org.knuchel.selenium.extentions.MyWebElement;
import org.openqa.selenium.WebElement;

public abstract class MyAbstractElement {
	protected MyWebElement component;

	public MyAbstractElement(WebElement webElement) {
		this.component = new MyWebElement(webElement);
		loadComponent(webElement);
	}

	public abstract void loadComponent(WebElement webElement);
}
