package com.trianglesauce.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum LineitemFulfillmentStatus {
	FULFILLED("fulfilled");

	private final String code;

	LineitemFulfillmentStatus(String code) {
		this.code = code;
	}

	@JsonValue
	public String getCode() {
		return code;
	}
}
