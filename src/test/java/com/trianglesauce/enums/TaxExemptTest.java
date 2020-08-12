package com.trianglesauce.enums;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class TaxExemptTest {
	
	@ParameterizedTest
	@MethodSource("getCodeArgs")
	void getCode(TaxExempt taxExempt, String code) {
		Assertions.assertThat(taxExempt)
				.extracting(TaxExempt::getCode)
				.isEqualTo(code);
	}

	static Stream<Arguments> getCodeArgs() {
		return Stream.of(
				Arguments.of(TaxExempt.YES, "yes"),
				Arguments.of(TaxExempt.NO, "no"));
	}

}
