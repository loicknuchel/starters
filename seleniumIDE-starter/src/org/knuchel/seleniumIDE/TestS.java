package org.knuchel.seleniumIDE;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestS {
	private WebDriver driver;
	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();
	
	public static void main(String[] args) throws Exception {
		TestS t = new TestS();
		t.setUp();
		t.testS();
		t.tearDown();
	}
	
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "http://blog.lkws.fr/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testS() throws Exception {
		driver.get(baseUrl + "/");
		driver.findElement(By.linkText("Continue reading →")).click();
		driver.findElement(By.linkText("CDO")).click();
		driver.findElement(By.linkText("exact:Replies: 2")).click();
		driver.findElement(By.linkText("Petit journal citoyen")).click();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
}
