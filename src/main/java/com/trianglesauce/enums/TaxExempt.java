package com.trianglesauce.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TaxExempt {
	YES("yes"),
	NO("no");

	private final String code;

	TaxExempt(String code) {
		this.code = code;
	}

	@JsonValue
	public String getCode() {
		return code;
	}
}
