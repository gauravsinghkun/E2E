package com.irctc.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Ticket {

	private Integer ticketNumber;
	private double ticketPrice;
	private String pnrNumber;
	private double ticketJourneyKm;
	private Character isThirdPartyIssued;
	private Integer[] phoneNumbers;
}
