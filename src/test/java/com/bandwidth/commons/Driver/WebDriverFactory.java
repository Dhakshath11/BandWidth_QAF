package com.bandwidth.commons.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.SkipException;

import com.bandwidth.commons.FrameworkGlobalVariables;

import java.net.URL;

public class WebDriverFactory {

	public static WebDriver createInstance(String browser, String hubURL) throws Exception {

		if (FrameworkGlobalVariables.EXECUTION_ENV.equalsIgnoreCase("LOCAL")) {
			DesiredCapabilities cap = new DesiredCapabilities();

			switch (browser.toLowerCase()) {
			case "chrome":
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("--headless");
				chromeOptions.addArguments("--incognito");
				chromeOptions.addArguments(
						"--user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/135.0.7049.85 Safari/537.36");
				chromeOptions.addArguments("--window-size=1080,720");

				cap.setBrowserName("chrome");
				cap.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
				break;

			case "edge":
				EdgeOptions edgeOptions = new EdgeOptions();
				edgeOptions.addArguments("start-maximized");

				cap.setBrowserName("MicrosoftEdge");
				cap.setCapability(EdgeOptions.CAPABILITY, edgeOptions);
				break;

			case "safari":
				if (!System.getProperty("os.name").toLowerCase().contains("mac")) {
					throw new SkipException("Safari is only supported on macOS.");
				}
				cap.setBrowserName("safari");
				break;

			case "firefox":
				throw new SkipException("Firefox is not installed in your system.");

			default:
				throw new IllegalArgumentException("Unsupported browser: " + browser);
			}

			return new RemoteWebDriver(new URL(hubURL), cap);
		} else if (FrameworkGlobalVariables.EXECUTION_ENV.equalsIgnoreCase("LAMBDATEST")) {
			return null;

		} else {
			System.out.println(FrameworkGlobalVariables.EXECUTION_ENV + " is not a supported type of environment.");
			return null;
		}
	}

}
