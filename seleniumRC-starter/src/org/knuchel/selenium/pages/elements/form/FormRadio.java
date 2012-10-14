package org.knuchel.selenium.pages.elements.form;

import java.util.List;

import org.knuchel.selenium.extentions.MyWebElement;
import org.knuchel.selenium.pages.elements.MyAbstractElement;
import org.openqa.selenium.WebElement;

public class FormRadio extends MyAbstractElement {
	private List<MyWebElement> components;

	public FormRadio(List<MyWebElement> webElements) {
		super(null);
		loadComponent(webElements);
	}

	public void loadComponent(WebElement webElement) {
		throw new IllegalAccessError("This method is not used !");
	}

	public void loadComponent(List<MyWebElement> webElements) {
		if (webElements != null) {
			int i = 0;
			for (MyWebElement element : webElements) {
				if (!("input".equalsIgnoreCase(element.getTagName()) && "radio".equalsIgnoreCase(element.getAttribute("type")))) {
					throw new IllegalArgumentException("Element " + i + " is not a radio (it's a " + element.getTagName() + ") !");
				}
				i++;
			}
		}
		this.components = webElements;
	}

	public void setById(int index) {
		if (index < 0 || index >= components.size()) {
			throw new IllegalArgumentException("index (" + index + ") must be in 0 and " + components.size() + "");
		}
		int i = 0;
		for (MyWebElement elt : components) {
			if (i == index) {
				elt.click();
				break;
			}
			i++;
		}
	}

	public void setByValue(String value) {
		for (MyWebElement elt : components) {
			if (value.equals(elt.getAttribute("value"))) {
				elt.click();
				break;
			}
		}
	}

	public String getValue() {
		for (MyWebElement elt : components) {
			if (elt.isSelected()) {
				return elt.getAttribute("value");
			}
		}
		return null;
	}

	public List<MyWebElement> getElements() {
		return components;
	}
}
