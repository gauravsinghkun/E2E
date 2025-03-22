package com.irctc.entity;

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
@Table(name = "Ticket")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Ticket {

	/*
	 * Identity --> Auto-increment feature  
	 * Increment --> Max(P.K)+1
	 * sequence --> best suited for Oracle
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ticketNumber;
	private double ticketPrice;
	private String pnrNumber;
	private double ticketJourneyKm;
	private Character isThirdPartyIssued;
	private Integer[] phoneNumbers;

}
