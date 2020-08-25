package com.trianglesauce.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum AcceptsMarketing {
	YES("yes"),
	NO("no");

	private final String code;

	AcceptsMarketing(String code) {
		this.code = code;
	}

	@JsonValue
	public String getCode() {
		return code;
	}
}
