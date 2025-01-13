package com.personal.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.personal.account.dto.request.AccountRequest;
import com.personal.account.dto.request.CreateAccountRequest;
import com.personal.account.dto.request.TransferAccountRequest;
import com.personal.account.dto.response.CreateAccountResponse;
import com.personal.account.dto.response.TransferAccountResponse;
import com.personal.account.service.AccountService;

@RestController
@RequestMapping("/bank")
public class AccountController {
	
	@Autowired
	private AccountService accountService;

	@PostMapping("/create/account")
	public ResponseEntity<CreateAccountResponse> createAccount(@RequestBody CreateAccountRequest account){
		return ResponseEntity.ok(accountService.createAccount(account));
	}
	
	@PostMapping("/transfer/account")
	public ResponseEntity<TransferAccountResponse> transferToAccount(@RequestBody TransferAccountRequest transferReq){
		return ResponseEntity.ok(accountService.transferToAccount(transferReq));
	}
	
	@GetMapping("/account")
	public ResponseEntity<String> getAccount(@RequestBody AccountRequest account){
		return ResponseEntity.ok("good");
	}

}
