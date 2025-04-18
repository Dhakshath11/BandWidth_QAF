package com.bandwidth.commons.DesiredCapabilities;

import java.util.HashMap;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariOptions;

import com.bandwidth.commons.TestCaseInputs;

public class CloudExecutionCapabilities {
	public DesiredCapabilities getDesiredCapabilities() {
		DesiredCapabilities cap = new DesiredCapabilities();
		String browser = TestCaseInputs.getBrowser();
		System.out.println(browser);

		// === Common Capabilities ===
		HashMap<String, Object> ltOptions = new HashMap<String, Object>();
		ltOptions.put("build", "LambdaTest Cross Browser Suite");
		ltOptions.put("name", "CrossBrowserTest");
		ltOptions.put("browserVersion", "latest");
		ltOptions.put("network", true);
		ltOptions.put("console", true);
		ltOptions.put("geoLocation", "IN");
		ltOptions.put("screenResolution", "2560x1440");
		ltOptions.put("selenium_version", "4.0.0");
		cap.setCapability("LT:Options", ltOptions);

		switch (browser.toLowerCase()) {
		case "chrome":
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.setPlatformName("Windows 11");
			chromeOptions.addArguments("--headless");
			chromeOptions.addArguments("--incognito");
			chromeOptions.addArguments(
					"--user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/135.0.7049.85 Safari/537.36");
			chromeOptions.addArguments("--window-size=1080,720");
			cap.setBrowserName("chrome");
			cap.merge(chromeOptions);
			break;

		case "edge":
			EdgeOptions edgeOptions = new EdgeOptions();
			edgeOptions.setPlatformName("Windows 10");
			edgeOptions.addArguments("--window-size=1080,720");
			cap.setBrowserName("MicrosoftEdge");
			cap.merge(edgeOptions);
			break;

		case "safari":
			SafariOptions safariOptions = new SafariOptions();
			safariOptions.setPlatformName("MacOS Sequoia");
			cap.setBrowserName("safari");
			cap.merge(safariOptions);
			break;

		case "firefox":
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.setPlatformName("macOS Monterey");
			firefoxOptions.addArguments("--headless");

			cap.setCapability(FirefoxOptions.FIREFOX_OPTIONS, firefoxOptions);
			cap.setBrowserName("firefox");
			break;

		default:
			throw new IllegalArgumentException("Unsupported browser: " + browser);
		}
		return cap;
	}
}
