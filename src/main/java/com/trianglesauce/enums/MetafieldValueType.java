package com.trianglesauce.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum MetafieldValueType {
	STRING("string"),
	INTEGER("integer"),
	JSON_STRING("json_string");

	MetafieldValueType(String code) {
		this.code = code;
	}

	private final String code;

	@JsonValue
	public String getCode() {
		return code;
	}
}
