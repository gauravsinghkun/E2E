package com.irctc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.irctc.entity.Ticket;
import com.irctc.exception.NoThirdPartyTicketsException;
import com.irctc.exception.NoTicketsInDBException;
import com.irctc.exception.PnrInvalidException;
import com.irctc.exception.TicketBookingException;
import com.irctc.service.TicketService;

@Controller
@ResponseBody
public class TicketController {

	@Autowired
	private TicketService service;

	@GetMapping("/getAllTickets")
	public ResponseEntity<List<Ticket>> getAllTickets() {
		List<Ticket> allTickets = service.getAllTickets();
		if (allTickets == null)
			throw new NoTicketsInDBException("No tickets available in DB-collection");
		System.out.println(allTickets);
		return new ResponseEntity<>(service.getAllTickets(), HttpStatus.OK);
	}

	@GetMapping("/findByPnrNumber")
	public ResponseEntity<Ticket> findByPnrNumber(@RequestParam String pnrNumber) {
		Ticket ticketByPnrNumber = service.findByPnrNumber(pnrNumber);
		if (ticketByPnrNumber == null)
			throw new PnrInvalidException("PNR is invalid , pls try with valid PNR Number");
		return new ResponseEntity<Ticket>(ticketByPnrNumber, HttpStatus.OK);
	}

	@GetMapping("/getThirdPartyTickets/{isThidParty}")
	public ResponseEntity<List<Ticket>> getThirdPartyTickets(@PathVariable Character isThidParty) {
		List<Ticket> thirdPartyTickets = service.getThirdPartyTickets(isThidParty);
		if (thirdPartyTickets == null)
			throw new NoThirdPartyTicketsException("No 3P items available ");
		return new ResponseEntity<List<Ticket>>(thirdPartyTickets, HttpStatus.OK);
	}

	@PostMapping("/save")
	public ResponseEntity<Ticket> saveTicket(@RequestBody Ticket ticket) {
		System.out.println("TicketController.saveTicket()");
		Ticket saveTicket = service.saveTicket(ticket);
		if (saveTicket == null)
			throw new TicketBookingException("Ticket Booking failed");
		return new ResponseEntity<Ticket>(saveTicket, HttpStatus.CREATED);
	}

	@DeleteMapping("/deleteTicket")
	public ResponseEntity<String> deleteTicket(@RequestBody Ticket ticket) {
		service.deleteBooking(ticket);
		return new ResponseEntity<String>("Booking deleted with ticket Number :: " + ticket.getTicketNumber(),
				HttpStatus.CREATED);
	}
}
