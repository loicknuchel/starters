package org.knuchel.selenium.test;

import java.util.List;

import org.knuchel.selenium.pages.global.State;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestSimple implements ITestcase {

	/**
	 * This is a simple test with basic selenium interactions
	 */
	public void start() {
		WebDriver webDriver = State.getInstance().getWebDriver().getWebDriver();
		WebElement searchBox = webDriver.findElement(By.id("searchbox"));
		WebElement searchSubmit = webDriver.findElement(By.id("searchsubmit"));
		searchBox.sendKeys("test");
		searchSubmit.click();
		List<WebElement> computers = webDriver.findElement(By.className("computers")).findElement(By.tagName("tbody")).findElements(By.tagName("tr"));

		for (WebElement computer : computers) {
			List<WebElement> computerFields = computer.findElements(By.tagName("td"));
			System.out.println(computerFields.get(0).getText());
		}

		WebElement add = webDriver.findElement(By.id("add"));
		add.click();
		WebElement actions = webDriver.findElement(By.className("actions"));
		WebElement submit = actions.findElement(By.tagName("input"));
		submit.click();
		actions = webDriver.findElement(By.className("actions"));
		WebElement cancel = actions.findElement(By.tagName("a"));
		cancel.click();
	}
}
