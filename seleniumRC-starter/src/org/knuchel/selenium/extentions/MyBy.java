package org.knuchel.selenium.extentions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

public class MyBy extends By {
	private By by;

	public MyBy(By by) {
		this.by = by;
	}

	public static MyBy className(String className) {
		return new MyBy(By.className(className));
	}

	public static MyBy cssSelector(String selector) {
		return new MyBy(By.cssSelector(selector));
	}

	public static MyBy id(String id) {
		return new MyBy(By.id(id));
	}

	public static MyBy linkText(String linkText) {
		return new MyBy(By.linkText(linkText));
	}

	public static MyBy name(String name) {
		return new MyBy(By.name(name));
	}

	public static MyBy partialLinkText(String linkText) {
		return new MyBy(By.partialLinkText(linkText));
	}

	public static MyBy tagName(String name) {
		return new MyBy(By.tagName(name));
	}

	public static MyBy xpath(String xpathExpression) {
		return new MyBy(By.xpath(xpathExpression));
	}

	@Override
	public List<WebElement> findElements(SearchContext context) {
		return by.findElements(context);
	}

	@Override
	public String toString() {
		String ret = by.toString();
		ret = ret.replaceAll("By.className: ", ".");
		ret = ret.replaceAll("By.id: ", "#");
		ret = ret.replaceAll("By.tagName: ", "");
		return ret;
	}

	// public static void main(String[] args) {
	// test(By.className("toto"));
	// test(By.cssSelector("toto"));
	// test(By.id("toto"));
	// test(By.linkText("toto"));
	// test(By.name("toto"));
	// test(By.partialLinkText("toto"));
	// test(By.tagName("toto"));
	// test(By.xpath("toto"));
	// }
	//
	// public static void test(By by) {
	// System.out.println("  By: " + by.toString());
	// System.out.println("MyBy: " + new MyBy(by).toString());
	// }
}
