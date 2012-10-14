package org.knuchel.selenium.pages.elements.bootstrap;

import org.knuchel.selenium.extentions.MyBy;
import org.knuchel.selenium.extentions.MyWebElement;
import org.knuchel.selenium.pages.elements.MyAbstractElement;
import org.openqa.selenium.WebElement;

public class BootstrapModal extends MyAbstractElement {

	public BootstrapModal(MyWebElement webElement) {
		super(webElement);
	}

	public void loadComponent(WebElement webElement) {
		if (!webElement.getAttribute("class").contains("modal")) {
			throw new IllegalArgumentException("Element is not a modal (it has no class modal in " + webElement.getAttribute("class") + ") !");
		}
		this.component = new MyWebElement(webElement);
		MyWebElement footer = getFooter();
		MyWebElement.waitFor(footer, MyBy.tagName("a"));
	}

	public String getTitle() {
		return component.findElement(".model-header h1").getText();
	}

	public MyWebElement getBody() {
		return component.findElement(".modal-body .inner");
	}

	public MyWebElement getFooter() {
		return component.findElement(".modal-footer");
	}

	public MyWebElement getElement() {
		return component;
	}
}
