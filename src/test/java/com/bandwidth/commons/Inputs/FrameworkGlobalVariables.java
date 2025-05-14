package com.bandwidth.commons.Inputs;

public class FrameworkGlobalVariables {
	public static String LT_USERNAME = "";
	public static String LT_ACCESS_KEY = "";
	public static String LT_GRID_URL = "@hub.lambdatest.com/wd/hub";
	public static String HUB_URL = "http://localhost:4444/wd/hub";

	public static void loadLTEnvVariables() {
		// First check System environment variables
		String username = System.getenv("LT_USERNAME");
		String accessKey = System.getenv("LT_ACCESS_KEY");

		// If not found in environment, check JVM system properties
		if (username == null || username.isEmpty()) {
			username = System.getProperty("LT_USERNAME", "");
		}

		if (accessKey == null || accessKey.isEmpty()) {
			accessKey = System.getProperty("LT_ACCESS_KEY", "");
		}

		LT_USERNAME = username;
		LT_ACCESS_KEY = accessKey;
	}
}