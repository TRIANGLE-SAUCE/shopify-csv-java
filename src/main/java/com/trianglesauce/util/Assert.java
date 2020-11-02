package com.trianglesauce.util;

import com.trianglesauce.exception.NotPositiveNumberException;

import java.math.BigDecimal;

public class Assert {

	private Assert() {}

	public static void notNull(Object obj, String message) {
		if (obj == null) {
			throw new IllegalArgumentException(message);
		}
	}

	public static void positive(BigDecimal target, String message) {
		if (target.compareTo(BigDecimal.ZERO) <= 0) {
			throw new NotPositiveNumberException(message);
		}
	}

	public static void positive(Integer target, String message) {
		if (target <= 0) {
			throw new NotPositiveNumberException(message);
		}
	}
}
