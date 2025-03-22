package com.irctc.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import com.irctc.dao.TicketRegistrationDao;
import com.irctc.entity.Ticket;

@Service
@Profile("dev")
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketRegistrationDao dao;

	@Override
	public List<Ticket> getAllTickets() {
		return dao.getAllTickets();
	}

	@Override
	public Ticket findByPnrNumber(String pnrNumber) {
		return dao.findByPnrNumber(pnrNumber);
	}

	@Override
	public List<Ticket> getThirdPartyTickets(Character isThidParty) {
		return dao.getThirdPartyTickets(isThidParty);
	}

	@Override
	public Ticket saveTicket(Ticket ticket) {
		return dao.save(ticket);
	}

	@Override
	public String deleteBooking(Ticket ticket) {
		System.out.println("TicketServiceImpl.deleteBooking()");
		dao.delete(ticket);
		return "Record deleted with booking id :: " + ticket.getTicketNumber();
	}

}
