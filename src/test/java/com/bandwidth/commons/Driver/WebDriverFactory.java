package com.bandwidth.commons.Driver;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.Status;
import com.bandwidth.commons.DesiredCapabilities.CloudExecutionCapabilities;
import com.bandwidth.commons.DesiredCapabilities.LocalExecutionCapabilities;
import com.bandwidth.commons.Inputs.FrameworkGlobalVariables;
import com.bandwidth.commons.Inputs.TestCaseInputs;
import com.bandwidth.commons.Report.TestListener;

public class WebDriverFactory {

    public static WebDriver createInstance() throws Exception {
        try {
            String env = TestCaseInputs.getEnv();
            TestListener.getTest().log(Status.INFO, "Creating Driver Instance for " + env + "environment");

            if (env.equalsIgnoreCase("LOCAL")) {
                String hubURL = FrameworkGlobalVariables.HUB_URL;
                return new RemoteWebDriver(new URL(hubURL), new LocalExecutionCapabilities().getDesiredCapabilities());

            } else if (env.equalsIgnoreCase("LAMBDATEST")) {
                if (FrameworkGlobalVariables.LT_USERNAME.isEmpty() || FrameworkGlobalVariables.LT_ACCESS_KEY.isEmpty()) {
                    System.out.println("Please set LT_USERNAME & LT_ACCESS_KEY inside FrameworkGlobalVariables. It is recommend to set it from SYSTEM-ENV Variables");
                    return null;
                }
                String gridURL = "https://" + FrameworkGlobalVariables.LT_USERNAME + ":"
                        + FrameworkGlobalVariables.LT_ACCESS_KEY + FrameworkGlobalVariables.LT_GRID_URL;
                return new RemoteWebDriver(new URL(gridURL), new CloudExecutionCapabilities().getDesiredCapabilities());
            } else {
                System.out.println(env + " is not a supported type of environment.");
                return null;
            }
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            return null;
        }
    }

}
