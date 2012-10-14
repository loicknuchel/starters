package org.knuchel.selenium.utils;

public class MyStringUtils {
	public static String clean(String text) {
		return text.replaceAll("\t", " ").replaceAll("\r", " ").replaceAll("\n", " ").replaceAll(" +", " ").trim();
	}
}
