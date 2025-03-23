package com.zomato.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class AccountDetails {

	private Integer accountId;
	private String googleAccountHolderName;
	private double accountBalance;
	private Integer mpin;
	private Character gender;
}
