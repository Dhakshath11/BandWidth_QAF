package com.bandwidth;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.bandwidth.commons.Driver.BaseSetup;
import com.bandwidth.commons.Report.TestListener;

public class CrossBrowserTest extends BaseSetup {

    private WebDriver driver;

    @Test
    public void launchSiteAndClick() {
        try {
            driver = getDriver();
            driver.get("https://example.com");
            TestListener.getTest().log(Status.PASS, "Navigated to Website");
            Thread.sleep(3000);
            driver.findElement(By.tagName("a")).click(); // Update selector as needed
            TestListener.getTest().log(Status.PASS, "Clicked on Element");
            Thread.sleep(5000);
            lambdaHook_TestStatus("passed");
        } catch (Exception e) {
            System.out.println("Tested Failed ==> " + e.getMessage());
            lambdaHook_TestStatus("failed");
        }


    }

}
