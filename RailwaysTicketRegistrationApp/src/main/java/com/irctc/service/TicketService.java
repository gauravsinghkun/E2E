package com.irctc.service;

import java.util.List;
import com.irctc.entity.Ticket;

public interface TicketService {

	public abstract List<Ticket> getAllTickets();

	public abstract Ticket findByPnrNumber(String pnrNumber);

	public abstract List<Ticket> getThirdPartyTickets(Character isThidParty);

	public abstract Ticket saveTicket(Ticket ticket);

	public abstract String deleteBooking(Ticket ticket);
}
