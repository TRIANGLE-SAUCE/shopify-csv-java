package com.trianglesauce.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

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

}
