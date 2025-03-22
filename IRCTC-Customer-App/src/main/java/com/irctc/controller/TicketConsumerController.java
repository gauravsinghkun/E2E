package com.irctc.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import com.irctc.Model.Ticket;

@Controller
@ResponseBody
public class TicketConsumerController {

	public static final String hostname = "http://localhost:9999/";

	@GetMapping("/getAllTickets")
	public ResponseEntity<List<Ticket>> getAllTickets() {
		WebClient webClient = WebClient.create();
		List<Ticket> allTickets = webClient.get().uri(hostname + "getAllTickets").accept(MediaType.APPLICATION_JSON)
				.retrieve().bodyToMono(List.class).block();
		return new ResponseEntity<List<Ticket>>(allTickets, HttpStatus.OK);
	}

	@PostMapping("/save")
	public ResponseEntity<Ticket> saveTicket(@RequestBody Ticket ticket) {
		WebClient webClient = WebClient.create();
		Ticket ticket_2 = webClient.post().uri(hostname+"save")
		         .body(BodyInserters.fromObject(ticket))
		         .accept(MediaType.APPLICATION_JSON)
		         .retrieve()
		         .bodyToMono(Ticket.class).
		         block();
		return new ResponseEntity<Ticket>(ticket_2, HttpStatus.OK);
	}

	/*
	 * 
	 * @SuppressWarnings("unchecked")
	 * 
	 * @GetMapping("/getAllTickets") public ResponseEntity<List<Ticket>>
	 * getAllTickets() {
	 * System.out.println("TicketConsumerController.getAllTickets()"); String url =
	 * hostname + "getAllTickets"; System.out.println(url); RestTemplate
	 * restTemplate = new RestTemplate(); ResponseEntity<List> responseEntity =
	 * restTemplate.getForEntity(url, List.class); return new
	 * ResponseEntity<List<Ticket>>(responseEntity.getBody(), HttpStatus.OK); }
	 * 
	 * @GetMapping("/save") public ResponseEntity<Ticket> saveTicket() { String url
	 * = hostname + "save"; HttpHeaders httpHeaders = new HttpHeaders(); String body
	 * =
	 * "{\n    \"ticketNumber\": null,\n    \"ticketPrice\": 12072,\n    \"pnrNumber\":56,\n   "
	 * +
	 * " \"ticketJourneyKm\": 13293.21,\n    \"isThirdPartyIssued\": \"Y\",\n    \"phoneNumbers\": [\n       "
	 * + " \"13545\",\n        \"602\"\n    ]\n}";
	 * 
	 * HttpEntity<String> httpEntity = new HttpEntity<>(body, httpHeaders);
	 * RestTemplate restTemplate = new RestTemplate(); ResponseEntity<Ticket>
	 * responseEntity = restTemplate.postForEntity(url, httpEntity, Ticket.class);
	 * Ticket savedTicket = responseEntity.getBody(); return new
	 * ResponseEntity<Ticket>(savedTicket, HttpStatus.OK); }
	 * 
	 */
}
