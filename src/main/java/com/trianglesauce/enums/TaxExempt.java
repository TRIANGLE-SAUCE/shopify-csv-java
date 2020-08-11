package com.trianglesauce.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TaxExempt {
	YES("yes"),
	NO("no");

	TaxExempt(String code) {
		this.code = code;
	}

	private final String code;

	@JsonValue
	public String getCode() {
		return code;
	}
}
