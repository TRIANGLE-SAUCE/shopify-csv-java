package com.trianglesauce.enums;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class AcceptsMarketingTest {

	@ParameterizedTest
	@MethodSource("getCodeArgs")
	void getCode(AcceptsMarketing acceptsMarketing, String code) {
		Assertions.assertThat(acceptsMarketing)
				.extracting(AcceptsMarketing::getCode)
				.isEqualTo(code);
	}

	static Stream<Arguments> getCodeArgs() {
		return Stream.of(
				Arguments.of(AcceptsMarketing.YES, "yes"),
				Arguments.of(AcceptsMarketing.NO, "no"));
	}

}
