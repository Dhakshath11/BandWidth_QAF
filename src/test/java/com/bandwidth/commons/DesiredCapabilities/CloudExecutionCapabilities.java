package com.bandwidth.commons.DesiredCapabilities;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.bandwidth.commons.FrameworkGlobalVariables;

public class CloudExecutionCapabilities {
	public DesiredCapabilities getDesiredCapabilities() {
		DesiredCapabilities cap = new DesiredCapabilities();
		String browser = FrameworkGlobalVariables.BROWSER;

		// cap.setCapability("build", "LambdaTest Cross Browser Suite");
		// cap.setCapability("name", "CrossBrowserTest");
		//cap.setCapability("network", true);
		//cap.setCapability("console", true);
		//cap.setCapability("geoLocation", "IN");
		cap.setCapability("browserVersion", "latest");
		//cap.setCapability("screenResolution","1920x1080");

		switch (browser.toLowerCase()) {
		case "chrome":
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--headless");
			chromeOptions.addArguments("--incognito");
			chromeOptions.addArguments(
					"--user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/135.0.7049.85 Safari/537.36");
			chromeOptions.addArguments("--window-size=1080,720");

			cap.setBrowserName("Chrome");
			cap.merge(chromeOptions);
			break;

		case "edge":
			EdgeOptions edgeOptions = new EdgeOptions();
			edgeOptions.addArguments("--start-maximized");
			cap.setBrowserName("MicrosoftEdge");
			cap.merge(edgeOptions);
			break;

		case "safari":
			cap.setBrowserName("safari");
			break;

		case "firefox":
			FirefoxOptions firefoxOptions = new FirefoxOptions();
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
