package com.google.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "AccountDetails")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class AccountDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer accountId;
	@Column(length = 30)
	private String googleAccountHolderName;
    @Column(length = 40)
	private double accountBalance;
    @Column(length = 4)
	private Integer mpin;
	private Character gender;
}
