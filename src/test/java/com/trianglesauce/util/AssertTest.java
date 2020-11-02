package com.trianglesauce.util;

import com.trianglesauce.exception.NotPositiveNumberException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class AssertTest {

	@Nested
	class NotNullTest {
		@Test
		void notNullValue() {
			final String test = "test";
			Assertions.assertThatCode(() -> Assert.notNull(test, "test must not be null."))
					.doesNotThrowAnyException();
		}

		@Test
		void nullValue() {
			final String test = null;
			Assertions.assertThatThrownBy(() -> Assert.notNull(test, "test must not be null."))
					.hasMessage("test must not be null.")
					.isInstanceOf(IllegalArgumentException.class);
		}
	}

	@Nested
	class PositiveTest {
		@Test
		void positiveForBigDecimal() {
			Assertions.assertThatCode(() -> Assert.positive(BigDecimal.ONE, "test must be a positive number."))
					.doesNotThrowAnyException();
		}

		@Test
		void positiveForBigDecimalFail() {
			Assertions.assertThatCode(() -> Assert.positive(BigDecimal.valueOf(-1.0), "test must be a positive number."))
					.hasMessage("test must be a positive number.")
					.isInstanceOf(NotPositiveNumberException.class);
		}

		@Test
		void positiveForInteger() {
			Assertions.assertThatCode(() -> Assert.positive(1, "test must be a positive number."))
					.doesNotThrowAnyException();
		}

		@Test
		void positiveForIntegerFail() {
			Assertions.assertThatCode(() -> Assert.positive(-1, "test must be a positive number."))
					.hasMessage("test must be a positive number.")
					.isInstanceOf(NotPositiveNumberException.class);
		}
	}

}
