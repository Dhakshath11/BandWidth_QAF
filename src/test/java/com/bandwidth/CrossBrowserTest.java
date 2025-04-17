package com.bandwidth;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.SkipException;
import org.testng.annotations.*;

import com.bandwidth.commons.FrameworkGlobalVariables;
import com.bandwidth.commons.Driver.WebDriverFactory;

public class CrossBrowserTest {

	WebDriver driver;

	@Parameters({ "browser", "hubURL" })
	@BeforeMethod
	public void setup(String browser, String hubURL) throws Exception {
		FrameworkGlobalVariables.BROWSER = browser;
		FrameworkGlobalVariables.EXECUTION_ENV = "LAMBDATEST";
		driver = WebDriverFactory.createInstance(browser, hubURL);

		if (driver == null)
			throw new SkipException("Driver is NULL. Execution skipped");
	}

	@Test
	public void launchSiteAndClick() throws InterruptedException {
		driver.get("https://example.com");
		Thread.sleep(3000);
		driver.findElement(By.tagName("a")).click(); // Update selector as needed
		Thread.sleep(5000);
	}

	@AfterMethod
	public void tearDown() {
		if (driver != null)
			driver.quit();
	}
}
