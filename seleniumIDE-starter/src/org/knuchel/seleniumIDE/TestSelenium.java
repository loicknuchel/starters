package org.knuchel.seleniumIDE;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestSelenium {
	private WebDriver driver;
	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "http://localhost:9000";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testSelenium() throws Exception {
		driver.get(baseUrl + "/computers");
		driver.findElement(By.id("add")).click();
		driver.findElement(By.id("name")).clear();
		driver.findElement(By.id("name")).sendKeys("coucou");
		driver.findElement(By.id("introduced")).clear();
		driver.findElement(By.id("introduced")).sendKeys("1900-01-01");
		driver.findElement(By.id("discontinued")).clear();
		driver.findElement(By.id("discontinued")).sendKeys("2000-12-12");
		new Select(driver.findElement(By.id("company_id"))).selectByVisibleText("Amstrad");
		driver.findElement(By.cssSelector("input.btn.primary")).click();
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
