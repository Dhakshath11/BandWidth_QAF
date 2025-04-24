package com.bandwidth.commons.Report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	private static ExtentReports extent;

	public static ExtentReports getInstance() {
		if (extent == null) {
			String reportPath = System.getProperty("user.dir") + "/ExecutionReport/ExtentReport.html";
			ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
			sparkReporter.config().setReportName("BandWidth Automation Execution");
			sparkReporter.config().setDocumentTitle("Test Results");

			extent = new ExtentReports();
			extent.attachReporter(sparkReporter);
			extent.setSystemInfo("Tester", "Dhakshath Amin");
			extent.setSystemInfo("Environment", System.getProperty("env", "LAMBDATEST"));
		}
		return extent;
	}
}
