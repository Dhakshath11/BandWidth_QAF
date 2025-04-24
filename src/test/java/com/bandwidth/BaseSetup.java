package com.bandwidth;

import org.openqa.selenium.WebDriver;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.Status;
import com.bandwidth.commons.TestCaseInputs;
import com.bandwidth.commons.Driver.WebDriverFactory;
import com.bandwidth.commons.Report.TestListener;

public class BaseSetup {

	protected ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	@Parameters("browser")
	@BeforeMethod
	public void setup(String browser) throws Exception {
		try {
			String env = System.getProperty("env", "LAMBDATEST");
			String remoteExecution = System.getProperty("RemoteExecution", "true");
			TestListener.startTest(browser.toUpperCase() + " Test");

			TestListener.getTest().log(Status.INFO,
					"Starting Test for " + browser.toUpperCase() + " browser in " + env + " environment");
			TestListener.getTest().log(Status.INFO, "Remote Execution : " + remoteExecution);

			TestCaseInputs.setBrowser(browser);
			TestCaseInputs.setEnv(env);
			TestCaseInputs.setRemoteExecution((Boolean.parseBoolean(remoteExecution)));

			driver.set(WebDriverFactory.createInstance());
			if (driver.get() == null)
				throw new SkipException("Driver is NULL. Execution skipped");
			TestListener.getTest().log(Status.PASS, "Driver has been Created");
		} catch (Exception e) {
			System.out.println("Unable to create Driver: " + e.getLocalizedMessage());
			TestListener.getTest().log(Status.SKIP, "Unable to create Driver: " + e.getMessage());
			throw new SkipException("Unable to create Driver.\n" + e.getLocalizedMessage());
		}
	}

	protected WebDriver getDriver() {
		return driver.get();
	}

	@AfterMethod
	public void tearDown() {
		if (driver.get() != null)
			driver.get().quit();
		TestCaseInputs.clear();
		TestListener.getTest().log(Status.INFO, "Ending Test");
	}
}
