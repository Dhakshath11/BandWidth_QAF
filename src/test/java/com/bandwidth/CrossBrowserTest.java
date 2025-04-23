package com.bandwidth;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class CrossBrowserTest extends BaseSetup{

	private WebDriver driver;

	@Test
	public void launchSiteAndClick() throws InterruptedException {
		driver = getDriver();
		driver.get("https://example.com");
		Thread.sleep(3000);
		driver.findElement(By.tagName("a")).click(); // Update selector as needed
		Thread.sleep(5000);
	}

}
