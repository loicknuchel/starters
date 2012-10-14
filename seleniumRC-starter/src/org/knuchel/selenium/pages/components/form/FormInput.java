package org.knuchel.selenium.pages.components.form;

import java.util.Arrays;

import org.knuchel.selenium.extentions.MyWebElement;
import org.knuchel.selenium.pages.components.MyAbstractComponent;
import org.openqa.selenium.WebElement;

public class FormInput extends MyAbstractComponent {

	public FormInput(MyWebElement webElement) {
		super(webElement);
	}

	public void loadComponent(WebElement webElement) {
		if (!"textarea".equalsIgnoreCase(webElement.getTagName())
				&& (!"input".equalsIgnoreCase(webElement.getTagName()) || Arrays.binarySearch(new String[] { "hidden", "file", "image", "checkbox", "radio",
						"submit", "reset" }, webElement.getAttribute("type")) >= 0)) {
			throw new IllegalArgumentException("Element is not a input text (or textarea) (it's a " + webElement.getTagName() + ") !");
		}
		this.component = new MyWebElement(webElement);
	}

	public void setValue(String val) {
		// tab key is added to move the focus out of the element
		component.clearAndSendKeys(val + "\t");
	}

	public void sendKeys(CharSequence... val) {
		component.sendKeys(val);
	}

	public String getValue() {
		return component.getAttribute("value");
	}

	public void clear() {
		component.clear();
	}

	public MyWebElement getElement() {
		return component;
	}
}
