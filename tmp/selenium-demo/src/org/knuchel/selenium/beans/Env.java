package org.knuchel.selenium.beans;

public enum Env {
	// LOCAL, DEV, TEST, RECETE, PREPROD, PROD
	LOCAL("lcl", "local"), DEV("dev"), TEST("tst", "test"), RECETTE("rct", "recette", "qual"), PREPROD("ppd", "pprd", "preprod"), PROD("prd", "prod",
			"production");

	String[] symbols;

	Env(String... envNames) {
		this.symbols = envNames;
	}

	public static Env getByName(String name) {
		for (Env env : Env.values()) {
			if (env.symbols != null) {
				for (String symbol : env.symbols) {
					if (symbol.equalsIgnoreCase(name)) {
						return env;
					}
				}
			}
		}
		throw new IllegalArgumentException("Impossible to find environment " + name);
	}
}
