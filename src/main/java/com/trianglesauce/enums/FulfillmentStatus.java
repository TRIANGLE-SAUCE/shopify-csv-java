package com.trianglesauce.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum FulfillmentStatus {
	FULFILLED("fulfilled"),
	PARTIAL("partial"),
	RESTOCKED("restocked");

	private final String code;

	FulfillmentStatus(String code) {
		this.code = code;
	}

	@JsonValue
	public String getCode() {
		return code;
	}
}
