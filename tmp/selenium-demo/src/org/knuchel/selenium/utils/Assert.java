package org.knuchel.selenium.utils;

public class Assert {
	public static void isEqual(String msg, Object expected, Object current) {
		if (!expected.equals(current)) {
			throw new IllegalStateException("ERROR " + msg + ": expected<" + expected + "> and was<" + current + ">");
		}
	}

	public static void isEqual(Object expected, Object current) {
		isEqual("", expected, current);
	}

	public static void isTrue(String msg, Boolean condition) {
		if (!condition) {
			throw new IllegalStateException("ERROR " + msg + ": condition must be true !");
		}
	}

	public static void isTrue(Boolean condition) {
		isTrue("", condition);
	}
}
