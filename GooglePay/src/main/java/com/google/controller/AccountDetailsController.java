package com.google.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.google.accountService.AccountService;
import com.google.entity.AccountDetails;
import com.google.exception.AccountNotExistException;
import com.google.exception.NoAccountsInDBException;

@Controller
@ResponseBody
@RequestMapping("/api/v3/account")
public class AccountDetailsController {

	@Autowired
	private AccountService service;

	@GetMapping("/getAllAccounts")
	public ResponseEntity<List<AccountDetails>> getAllAccounts() {
		List<AccountDetails> allAccounts = service.getAllAccounts();
		if (allAccounts.isEmpty())
			throw new NoAccountsInDBException("No Account info in DB");
		return new ResponseEntity<List<AccountDetails>>(allAccounts, HttpStatus.OK);
	}

	@GetMapping("/getAccountRecordByAccountId")
	public ResponseEntity<AccountDetails> getAccountRecordByAccountId(@RequestParam("accountId") Integer id) {
		AccountDetails accountRecordByAccountId = service.getAccountRecordByAccountId(id);
		if (accountRecordByAccountId == null)
			throw new AccountNotExistException("No Account info for id :: " + id);
		return new ResponseEntity<AccountDetails>(accountRecordByAccountId, HttpStatus.OK);
	}

	@GetMapping("/accountBalance/{accountBalance}")
	public ResponseEntity<List<AccountDetails>> accountBalance(@PathVariable("accountBalance") double balance) {
		return new ResponseEntity<List<AccountDetails>>(service.accountBalance(balance), HttpStatus.OK);
	}

	@PostMapping("/save")
	public ResponseEntity<AccountDetails> saveAccountDetails(@RequestBody AccountDetails details) {
		System.out.println("AccountDetailsController.saveAccountDetails()");
		return new ResponseEntity<AccountDetails>(service.saveAccountDetails(details), HttpStatus.CREATED);
	}
}
