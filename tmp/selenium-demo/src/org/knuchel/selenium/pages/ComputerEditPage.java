package org.knuchel.selenium.pages;

import org.knuchel.selenium.extentions.MyWebDriver;
import org.knuchel.selenium.extentions.MyWebElement;
import org.knuchel.selenium.pages.elements.form.FormBtn;
import org.openqa.selenium.By;

public class ComputerEditPage extends ComputerPage {

	public ComputerEditPage(MyWebDriver webDriver) {
		super(webDriver);
	}

	public ComputerListPage delete() {
		MyWebElement globalPage = DOM.getGlobalPage(webDriver);
		MyWebElement computerDeleteForm = DOM.getComputerDeleteForm(globalPage);
		FormBtn computerDeleteBtn = DOM
				.getComputerDeleteBtn(computerDeleteForm);
		computerDeleteBtn.click();
		return new ComputerListPage(webDriver);
	}

	public static class DOM {
		public static MyWebElement getGlobalPage(MyWebDriver webDriver) {
			return webDriver.findElement(By.tagName("body"));
		}

		public static MyWebElement getComputerDeleteForm(MyWebElement globalPage) {
			return globalPage.findElement(".topRight");
		}

		public static FormBtn getComputerDeleteBtn(
				MyWebElement computerDeleteForm) {
			return new FormBtn(computerDeleteForm.findElement("input"));
		}
	}
}
