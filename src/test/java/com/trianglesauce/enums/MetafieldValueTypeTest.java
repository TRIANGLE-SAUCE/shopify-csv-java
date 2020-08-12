package com.trianglesauce.enums;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MetafieldValueTypeTest {

	@ParameterizedTest
	@MethodSource("getCodeArgs")
	void getCode(MetafieldValueType metafieldValueType, String code) {
		Assertions.assertThat(metafieldValueType)
				.extracting(MetafieldValueType::getCode)
				.isEqualTo(code);
	}

	static Stream<Arguments> getCodeArgs() {
		return Stream.of(
				Arguments.of(MetafieldValueType.STRING, "string"),
				Arguments.of(MetafieldValueType.INTEGER, "integer"),
				Arguments.of(MetafieldValueType.JSON_STRING, "json_string"));
	}

}
