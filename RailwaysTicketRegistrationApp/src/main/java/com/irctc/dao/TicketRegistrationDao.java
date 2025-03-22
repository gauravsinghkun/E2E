package com.irctc.dao;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.irctc.entity.Ticket;

@Profile("dev")
public interface TicketRegistrationDao extends CrudRepository<Ticket, Integer> {

	@Query("from com.irctc.entity.Ticket")
	public abstract List<Ticket> getAllTickets();

	public abstract Ticket findByPnrNumber(String pnrNumber);

	@Query("from com.irctc.entity.Ticket where isThirdPartyIssued=:isThidParty")
	public abstract List<Ticket> getThirdPartyTickets(Character isThidParty);
}
