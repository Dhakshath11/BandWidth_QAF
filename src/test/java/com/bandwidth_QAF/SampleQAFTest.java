package com.bandwidth_QAF;

import org.testng.annotations.Test;

import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;

public class SampleQAFTest extends WebDriverTestCase {

    @Test
    public void sampleTest() {
        try {
            QAFExtendedWebDriver driver = getDriver(); // QAF-managed driver
            driver.get("https://example.com");
            System.out.println("Title is: " + driver.getTitle());
            Thread.sleep(5000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}