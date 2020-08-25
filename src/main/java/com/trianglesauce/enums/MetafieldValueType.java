package com.trianglesauce.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum MetafieldValueType {
	STRING("string"),
	INTEGER("integer"),
	JSON_STRING("json_string");

	private final String code;

	MetafieldValueType(String code) {
		this.code = code;
	}

	@JsonValue
	public String getCode() {
		return code;
	}
}
