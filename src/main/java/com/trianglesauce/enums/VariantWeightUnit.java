package com.trianglesauce.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum VariantWeightUnit {
	G("g"),
	KG("kg"),
	OZ("oz"),
	LB("lb");

	private final String code;

	VariantWeightUnit(String code) {
		this.code = code;
	}

	@JsonValue
	public String getCode() {
		return code;
	}
}
