package com.trianglesauce.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum CancelReason {
	CUSTOMER("customer"),
	FRAUD("fraud"),
	INVENTORY("inventory"),
	DECLINED("declined"),
	OTHER("other");

	private final String code;

	CancelReason(String code) {
		this.code = code;
	}

	@JsonValue
	public String getCode() {
		return code;
	}
}
