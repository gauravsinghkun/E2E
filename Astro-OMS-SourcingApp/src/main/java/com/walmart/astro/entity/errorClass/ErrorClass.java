package com.walmart.astro.entity.errorClass;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ErrorClass {

	private Integer errorValue;
	private String errorMessage;
}
