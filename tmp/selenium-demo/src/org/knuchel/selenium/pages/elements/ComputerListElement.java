package org.knuchel.selenium.pages.elements;

import java.util.List;

import org.knuchel.selenium.beans.Computer;
import org.knuchel.selenium.extentions.MyBy;
import org.knuchel.selenium.extentions.MyWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ComputerListElement extends MyAbstractElement {
	private List<WebElement> elements;

	public ComputerListElement(WebElement webElement) {
		super(webElement);
		if (!webElement.getTagName().equals("tr")) {
			throw new IllegalArgumentException("Element is a <" + webElement.getTagName() + "> tag instead of a <tr> tag !");
		}
	}

	@Override
	public void loadComponent(WebElement webElement) {
		if (webElement instanceof MyWebElement) {
			this.component = (MyWebElement) webElement;
		} else {
			this.component = new MyWebElement(webElement);
		}
		this.elements = this.component.findElements(MyBy.tagName("td"));
	}

	public void edit() {
		elements.get(0).findElement(By.tagName("a")).click();
	}

	public String getName() {
		return elements.get(0).getText();
	}

	public String getIntroduced() {
		return elements.get(1).getText();
	}

	public String getDiscontinued() {
		return elements.get(2).getText();
	}

	public String getCompany() {
		return elements.get(3).getText();
	}

	public Computer getComputer() {
		return new Computer(getName(), getIntroduced(), getDiscontinued(), getCompany());
	}
}
