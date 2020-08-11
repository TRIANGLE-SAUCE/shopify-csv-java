package com.trianglesauce.util;

public class Assert {

	private Assert() {}

	public static void notNull(Object obj, String message) {
		if (obj == null) {
			throw new IllegalArgumentException(message);
		}
	}
}
