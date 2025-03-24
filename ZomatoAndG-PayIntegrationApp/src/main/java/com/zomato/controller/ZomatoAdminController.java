package com.zomato.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.zomato.model.AccountDetails;

@RestController
@RequestMapping("/api/v4/gpay/accounts")
public class ZomatoAdminController {

	public static final String hostName = "http://localhost:9999/api/v3/account";

	@GetMapping("/getAllAccounts")
	public ResponseEntity<List<AccountDetails>> getAllAccounts() {
		System.out.println("ZomatoAdminController.getAllAccounts()");
		WebClient webClient = WebClient.create();
		List allAccountsList = webClient.get().uri(hostName + "/getAllAccounts").accept(MediaType.APPLICATION_JSON)
				.retrieve().bodyToMono(List.class).block();

		return new ResponseEntity<List<AccountDetails>>(allAccountsList, HttpStatus.OK);
	}

	@GetMapping("/getAccountRecordByAccountId")
	public ResponseEntity<AccountDetails> getAccountRecordByAccountId(@RequestParam("accountId") Integer id) {
		WebClient webClient = WebClient.create();
		HashMap<String, Integer> hashMap = new HashMap<>();
		hashMap.put("accountId", 4);
		AccountDetails accountDetails = webClient.get().uri(hostName + "/getAccountRecordByAccountId", hashMap)
				.accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(AccountDetails.class).block();

		return new ResponseEntity<AccountDetails>(accountDetails, HttpStatus.OK);
	}

	@GetMapping("/accountBalance/{accountBalance}")
	public ResponseEntity<List<AccountDetails>> accountBalance(@PathVariable("accountBalance") double balance) {
		RestTemplate restTemplate = new RestTemplate();
		Map<Object, Object> hashMap = new HashMap<>();
		hashMap.put("accountBalance", balance);
		ResponseEntity<List> responseEntity = restTemplate.getForEntity(hostName + "/accountBalance/{accountBalance}",
				List.class, hashMap);
		return new ResponseEntity<List<AccountDetails>>(responseEntity.getBody(), HttpStatus.OK);
	}

	@PostMapping("/save")
	public ResponseEntity<AccountDetails> saveAccountDetails(@RequestBody AccountDetails accountDetails) {
		WebClient webClient = WebClient.create();
		AccountDetails details = webClient.post().uri(hostName + "/save").body(BodyInserters.fromValue(accountDetails))
				.accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(AccountDetails.class).block();

		return new ResponseEntity<AccountDetails>(details, HttpStatus.CREATED);
	}
}
