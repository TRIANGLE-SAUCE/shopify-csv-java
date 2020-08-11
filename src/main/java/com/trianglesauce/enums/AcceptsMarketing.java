package com.trianglesauce.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum AcceptsMarketing {
	YES("yes"),
	NO("no");

	AcceptsMarketing(String code) {
		this.code = code;
	}

	private final String code;

	@JsonValue
	public String getCode() {
		return code;
	}
}
