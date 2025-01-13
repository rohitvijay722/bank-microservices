package com.personal.account.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.personal.account.dto.request.CreateAccountRequest;
import com.personal.account.dto.request.TransferAccountRequest;
import com.personal.account.dto.response.CreateAccountResponse;
import com.personal.account.dto.response.TransferAccountResponse;
import com.personal.account.entity.AccountEntity;
import com.personal.account.repository.AccountRepository;


@Service
public class AccountService {
	
	@Autowired
	private AccountRepository accountRepository;

	public CreateAccountResponse createAccount(CreateAccountRequest createAccountRequest) {
		AccountEntity accountEntity=new AccountEntity();
		accountEntity.setAccountHolderName(createAccountRequest.getAccountHolderName());
		accountEntity.setAccountNum(createAccountRequest.getAccountNum());
		accountEntity.setBalance(createAccountRequest.getBalance());
		accountEntity.setDateOfBirth(createAccountRequest.getDateOfBirth());
		accountEntity.setMobileNum(createAccountRequest.getMobileNum());
		accountEntity.setMpin(createAccountRequest.getMpin());
		accountEntity.setCreatedAt(LocalDateTime.now());
		accountRepository.save(accountEntity);
		CreateAccountResponse createAccountResponse = new CreateAccountResponse();
		createAccountResponse.setAccountHolderName(accountEntity.getAccountHolderName());
		createAccountResponse.setAccountNum(accountEntity.getAccountNum());
		createAccountResponse.setBalance(accountEntity.getBalance());
		return createAccountResponse;
	}
	
	public TransferAccountResponse transferToAccount(TransferAccountRequest transferAccountRequest) {
		long payeeAccountNum=transferAccountRequest.getPayeeAccountNum();
		long payerAccountNum=transferAccountRequest.getPayerAccountNum();
		Optional<AccountEntity> payer=accountRepository.findById(payerAccountNum);
		if(payer.isEmpty()) {
			throw new RuntimeException("No Payer Account Exist");
		}
		if(!payer.get().getMpin().equalsIgnoreCase(transferAccountRequest.getMpin())) {
			throw new RuntimeException("wrong mpin");
		}
		if(payer.get().getBalance()<transferAccountRequest.getAmount()) {
			throw new RuntimeException("Insufficient Balance");
		}
		Optional<AccountEntity> payee=accountRepository.findById(payeeAccountNum);
		if(payee.isEmpty()) {
			throw new RuntimeException("No Payee Account Exist, user is not in the system");
		}
		AccountEntity payeeEntity=payee.get();
		payeeEntity.setBalance(transferAccountRequest.getAmount()+payee.get().getBalance());
		payeeEntity.setModifiedAt(LocalDateTime.now());
		
		AccountEntity payerEntity=payer.get();
		payerEntity.setBalance(payer.get().getBalance() - transferAccountRequest.getAmount());
		payerEntity.setModifiedAt(LocalDateTime.now());
		
		List<AccountEntity> listOfAccountEntity=new ArrayList<>();
		listOfAccountEntity.add(payerEntity);
		listOfAccountEntity.add(payeeEntity);
		
		accountRepository.saveAll(listOfAccountEntity);
		
		TransferAccountResponse transferAccountResponse = new TransferAccountResponse();
		transferAccountResponse.setMessage("money transferred successful to "+payee.get().getAccountHolderName()+" by "+payer.get().getAccountHolderName());
		transferAccountResponse.setTransferredAmount(transferAccountRequest.getAmount());
		return transferAccountResponse;
	}
	
}
