package com.bandwidth_QAF.stepdefs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;

@QAFTestStepProvider
public class StepDefinitions extends WebDriverTestCase {

	@QAFTestStep(stepName = "I want to navigate to website")
	public void navigateToWebsite() {
		try {
			QAFExtendedWebDriver driver = getDriver();
			driver.get("https://example.com");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@QAFTestStep(stepName = "website is loaded")
	public void websiteLoaded() {
		try {
			QAFExtendedWebDriver driver = getDriver();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));
			System.out.println(driver.findElement(By.tagName("h1")).getText());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@QAFTestStep(stepName = "I Click on More Information")
	public void clickOnMoreInfo() {
		try {
			QAFExtendedWebDriver driver = getDriver();
			driver.findElement(By.tagName("a")).click();
			System.out.println("Clicked on Element");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@QAFTestStep(stepName = "More Information is to be visible")
	public void moreInfoLoaded() {
		try {
			QAFExtendedWebDriver driver = getDriver();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h2")));
			System.out.println(driver.findElement(By.tagName("h2")).getText());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
