package org.knuchel.selenium.extentions;

import java.util.ArrayList;
import java.util.List;

import org.knuchel.selenium.utils.MyStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;


public class MyWebElement implements WebElement {
	protected WebElement webElement;
	private static final int DEFAULT_TIMEOUT_MILLIS = 5000;

	public MyWebElement(WebElement webElement) {
		this.webElement = webElement;
	}

	@Override
	public void click() {
		try {
			webElement.click();
		} catch (WebDriverException e) {
			throw new WebDriverException("can't click WebElement[" + toString() + "]", e);
		}
	}

	@Override
	public void submit() {
		webElement.submit();
	}

	@Override
	public void sendKeys(CharSequence... keysToSend) {
		webElement.sendKeys(keysToSend);
	}

	@Override
	public void clear() {
		webElement.clear();
	}

	public void clearAndSendKeys(CharSequence... keysToSend) {
		webElement.clear();
		webElement.sendKeys(keysToSend);
	}

	@Override
	public String getTagName() {
		return webElement.getTagName();
	}

	@Override
	public String getAttribute(String name) {
		return webElement.getAttribute(name);
	}

	@Override
	public boolean isSelected() {
		return webElement.isSelected();
	}

	@Override
	public boolean isEnabled() {
		return webElement.isEnabled();
	}

	@Override
	public String getText() {
		return MyStringUtils.clean(webElement.getText());
	}

	@Override
	public List<WebElement> findElements(By by) {
		return webElement.findElements(by);
	}

	@Override
	public MyWebElement findElement(By by) {
		try {
			return new MyWebElement(webElement.findElement(by));
		} catch (NoSuchElementException e) {
			throw new NoSuchElementException("can't findElement " + by + " in WebElement[" + toString() + "]", e);
		} catch (StaleElementReferenceException e) {
			throw new StaleElementReferenceException("WebElement[" + toString() + "] has been removed (unable to find " + by + ")", e);
		}
	}

	/**
	 * <p>
	 * this method will parse the selector and successivly call findElement(By by) with appropriate By clause.
	 * </p>
	 * Examples: <blockquote>
	 * 
	 * <pre>
	 * findElement(&quot;body #blockid table .class&quot;)
	 * </pre>
	 * 
	 * </blockquote>
	 * 
	 * @param selector
	 *            can be composed with ids (#id), css classes (.class) and tags name (tag) separated with spaces.
	 * @return
	 */
	public MyWebElement findElement(String selector) {
		String[] split = selector.split(" ");
		if (split != null && split.length > 0) {
			try {
				MyWebElement elt = this;
				for (String by : split) {
					if (by.startsWith("#")) {
						elt = elt.findElement(By.id(by.substring(1)));
					} else if (by.startsWith(".")) {
						elt = elt.findElement(By.className(by.substring(1)));
					} else {
						elt = elt.findElement(By.tagName(by));
					}
				}
				return elt;
			} catch (NoSuchElementException e) {
				throw new NoSuchElementException("can't findElement " + selector, e);
			}
		}
		throw new NoSuchElementException("wrong value for selector : (" + selector + ")");
	}

	@Override
	public boolean isDisplayed() {
		try {
			return webElement.isDisplayed();
		} catch (StaleElementReferenceException e) {
			throw new StaleElementReferenceException("tagetted element has been removed", e);
		}
	}

	@Override
	public Point getLocation() {
		return webElement.getLocation();
	}

	@Override
	public Dimension getSize() {
		return webElement.getSize();
	}

	@Override
	public String getCssValue(String propertyName) {
		return webElement.getCssValue(propertyName);
	}

	public static void waitFor(WebDriver element, By by) {
		waitFor(new MyWebElement(element.findElement(By.tagName("html"))), by);
	}

	public static void waitFor(MyWebElement element, By by) {
		waitFor(new MyWebElement(element.findElement(By.tagName("html"))), by, DEFAULT_TIMEOUT_MILLIS);
	}
	
	public static void waitFor(MyWebElement element, By by, int timeoutMillis) {
		long end = System.currentTimeMillis() + timeoutMillis;
		MyWebElement result = null;
		while (System.currentTimeMillis() < end) {
			try {
				result = element.findElement(by);
				if (result.isDisplayed()) {
					break;
				}
			} catch (NoSuchElementException e) {
				// nothing to do
			}
		}
	}

	public WebElement getWebElement() {
		return webElement;
	}

	public static List<MyWebElement> convert(List<WebElement> webElements) {
		List<MyWebElement> ret = new ArrayList<MyWebElement>();
		if (webElements != null) {
			for (WebElement webElement : webElements) {
				ret.add(new MyWebElement(webElement));
			}
		}
		return ret;
	}

	public static MyWebElement getGlobalPage(WebDriver webdriver) {
		try {
			return new MyWebElement(webdriver.findElement(By.tagName("html")));
		} catch (NoSuchElementException e) {
			throw new NoSuchElementException("Can't get page from WebDriver : Unexpected error !!!");
		} catch (UnhandledAlertException e) {
			throw e;
		}
	}

	@Override
	public String toString() {
		String ret = webElement.toString();
		if (ret.contains("[")) {
			ret = webElementToStringformat(ret);
			ret += " -> <" + webElement.getTagName() + ">" + webElement.getText() + "</" + webElement.getTagName() + ">";
		}
		return ret;
	}

	private static String webElementToStringformat(String ts) {
		String noCloseCrochet = "[^\\]]";
		String noCrochet = "[^\\[\\]]";
		// suppression de : [ChromeDriver: chrome on XP (534e0e7461024c612f331e8adedc213e)]
		ts = ts.replaceAll("\\[(" + noCrochet + "*)\\]", "");
		// formatage des class name
		while (ts.contains("-> class name:")) {
			ts = ts.replaceAll("\\[(.*) -> class name: (" + noCloseCrochet + "*)\\]", "$1 .$2");
		}
		// formatage des id
		while (ts.contains("-> id:")) {
			ts = ts.replaceAll("\\[(.*) -> id: (" + noCloseCrochet + "*)\\]", "$1 #$2");
		}
		// formatage des tag name
		while (ts.contains("-> tag name:")) {
			ts = ts.replaceAll("\\[(.*) -> tag name: (" + noCloseCrochet + "*)\\]", "$1 $2");
		}
		// suppression des crochets superflux
		while (ts.contains("[")) {
			ts = ts.replaceAll("\\[(.*)\\]", "$1");
		}
		ts = ts.trim();
		return ts;
	}
}
