package com.bandwidth;

import org.openqa.selenium.WebDriver;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.bandwidth.commons.TestCaseInputs;
import com.bandwidth.commons.Driver.WebDriverFactory;

public class BaseSetup {

	protected ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	@Parameters("browser")
	@BeforeMethod
	public void setup(String browser) throws Exception {
		TestCaseInputs.setBrowser(browser);
		TestCaseInputs.setEnv(System.getProperty("env", "LAMBDATEST"));
		TestCaseInputs.setRemoteExecution((Boolean.parseBoolean(System.getProperty("RemoteExecution", "false"))));
		driver.set(WebDriverFactory.createInstance());

		if (driver.get() == null)
			throw new SkipException("Driver is NULL. Execution skipped");
	}

	protected WebDriver getDriver() {
		return driver.get();
	}

	@AfterMethod
	public void tearDown() {
		if (driver.get() != null)
			driver.get().quit();
		TestCaseInputs.clear();
	}
}
