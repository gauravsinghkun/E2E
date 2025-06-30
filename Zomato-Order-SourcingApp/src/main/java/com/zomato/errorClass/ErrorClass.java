package com.zomato.errorClass;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor 
@Getter
@Setter
public class ErrorClass {

	private Integer errorId;
	private String errorMessage;
}
