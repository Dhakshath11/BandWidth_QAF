package com.bandwidth.commons;

public class TestCaseInputs {

	private static ThreadLocal<String> browser = new ThreadLocal<>();
	private static ThreadLocal<String> env = new ThreadLocal<>();
	private static ThreadLocal<Boolean> remoteExecution = new ThreadLocal<>();

	public static void setBrowser(String value) {
		browser.set(value);
	}

	public static String getBrowser() {
		return browser.get();
	}

	public static void setEnv(String value) {
		env.set(value);
	}

	public static String getEnv() {
		return env.get();
	}

	public static void setRemoteExecution(boolean value) {
		remoteExecution.set(value);
	}

	public static boolean getRemoteExecution() {
		return remoteExecution.get();
	}

	public static void clear() {
		browser.remove();
		env.remove();
	}
}
