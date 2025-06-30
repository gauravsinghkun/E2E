package com.zomato.errorClass;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ErrorClass {

	private Integer errorId;
	private String errorMessage;
}
