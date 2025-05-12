package com.bandwidth_QAF.stepdefs;

import com.qmetry.qaf.automation.step.QAFTestStepListener;
import com.qmetry.qaf.automation.step.StepExecutionTracker;
import com.qmetry.qaf.automation.ui.webdriver.CommandTracker;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebDriverCommandListener;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;

public class Hooks implements QAFTestStepListener, QAFWebDriverCommandListener {

    @Override
    public void onFailure(StepExecutionTracker stepExecutionTracker) {

    }

    @Override
    public void beforExecute(StepExecutionTracker stepExecutionTracker) {
        //System.out.println("==============  Step : " + stepExecutionTracker.getScenario().getId().split("=")[1].split("@")[0].split("BDD-")[1] + " >>> " + stepExecutionTracker.getStep().getDescription() + " ==============");
    }

    @Override
    public void afterExecute(StepExecutionTracker stepExecutionTracker) {

    }

    @Override
    public void beforeCommand(QAFExtendedWebDriver driver, CommandTracker commandHandler) {

    }

    @Override
    public void afterCommand(QAFExtendedWebDriver driver, CommandTracker commandHandler) {

    }

    @Override
    public void onFailure(QAFExtendedWebDriver driver, CommandTracker commandHandler) {

    }

    @Override
    public void beforeInitialize(Capabilities desiredCapabilities) {

    }

    @Override
    public void onInitialize(QAFExtendedWebDriver driver) {
        String name = "Chrome BDD - Test"; // TODO: Pass the Name from LambdaTest key or Pass Tag name from BDD Step
        System.out.println("Setting LambaTest Test Name : " + name);
        lambdaHook_SetTestName(driver, name);
    }

    @Override
    public void onInitializationFailure(Capabilities desiredCapabilities, Throwable t) {

    }

    private void lambdaHook_SetTestName(QAFExtendedWebDriver driver, String name) {
        try {
            driver.executeScript("lambda-name=" + name);
        } catch (Exception e) {
            System.out.println("Lambda Hook Error for Test Name: " + e.getLocalizedMessage());
        }
    }
}