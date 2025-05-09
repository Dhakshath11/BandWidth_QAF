package com.bandwidth_QAF.stepdefs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
            System.out.println("Website Loaded => " + driver.findElement(By.tagName("h1")).getText());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @QAFTestStep(stepName = "I Click on {message}")
    public void clickOnElement(String message) {
        try {
            QAFExtendedWebDriver driver = getDriver();
            String element = "//*[contains(text(),'" + message + "')]";
            driver.findElement(By.xpath(element)).click();
            System.out.println("Website Action => Clicked on " + message);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @QAFTestStep(stepName = "{message} is to be visible")
    public void infoLoaded(String message) {
        try {
            QAFExtendedWebDriver driver = getDriver();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            String element = "//*[contains(text(),'" + message + "')]";
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
            System.out.println("Website Present => " + driver.findElement(By.xpath(element)).getText());

            // === TODO : NEED TO FIND TEARDOWN HOOK ===
            lambdaHook_TestStatus(driver, "passed");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void lambdaHook_TestStatus(QAFExtendedWebDriver driver, String status) {
        try {
            ((JavascriptExecutor) driver).executeScript("lambda-status=" + status);
        } catch (Exception e) {
            System.out.println("Lambda Hook Error for Test Status: " + e.getLocalizedMessage());
        }
    }
}