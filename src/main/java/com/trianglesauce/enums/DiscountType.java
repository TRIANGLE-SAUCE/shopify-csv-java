package com.trianglesauce.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum DiscountType {
	FIXED_AMOUNT("fixed_amount"),
	PERCENTAGE("percentage"),
	SHIPPING("shipping");

	private final String code;

	DiscountType(String code) {
		this.code = code;
	}

	@JsonValue
	public String getCode() {
		return code;
	}
}
