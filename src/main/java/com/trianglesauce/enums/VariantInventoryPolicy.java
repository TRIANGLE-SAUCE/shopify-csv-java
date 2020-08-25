package com.trianglesauce.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum VariantInventoryPolicy {
	DENY("deny"),
	CONTINUE("continue");

	private final String code;

	VariantInventoryPolicy(String code) {
		this.code = code;
	}

	@JsonValue
	public String getCode() {
		return code;
	}
}
