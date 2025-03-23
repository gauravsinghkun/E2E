package com.google.error;

import org.springframework.boot.context.properties.ConfigurationProperties;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ConfigurationProperties(prefix = "com.google.")
@ToString
@NoArgsConstructor
public class ErrorDetails {

	private Integer errorId;
	private String errorMessage;
	private String errorOriginator;

	public Integer getErrorId() {
		return errorId;
	}

	public void setErrorId(Integer errorId) {
		this.errorId = errorId;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
