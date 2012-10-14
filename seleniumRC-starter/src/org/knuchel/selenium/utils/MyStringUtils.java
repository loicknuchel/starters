package org.knuchel.selenium.utils;

public class MyStringUtils {
	public static String clean(String text) {
		return text.replaceAll("\t", " ").replaceAll("\r", " ").replaceAll("\n", " ").replaceAll(" +", " ").trim();
	}

	public static String convert(Throwable e) {
		StringBuilder sb = new StringBuilder();
		sb.append(e.toString() + "\n");
		for (StackTraceElement stackTrace : e.getStackTrace()) {
			sb.append("\t" + stackTrace.toString() + "\n");
		}
		if (e.getCause() != null) {
			Throwable cause = e.getCause();
			sb.append("Caused by: " + convert(cause));
		}
		return sb.toString();
	}

}
