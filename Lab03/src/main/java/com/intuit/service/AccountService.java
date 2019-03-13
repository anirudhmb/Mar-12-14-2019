package com.intuit.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intuit.dao.AccountRepository;
import com.intuit.dao.StatementRepository;
import com.intuit.domain.Account;
import com.intuit.domain.Statement;
import com.intuit.service.exception.AccountNotFoundException;

@Service
public class AccountService {
	
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private StatementRepository statementRepository;
	
	@Transactional
	public void deposit(int accountNumber,int amount, String type) {
		Optional<Account> optionalAccount  = accountRepository.findById(accountNumber);
		if(optionalAccount.isPresent()) {
			Account account = optionalAccount.get();
			account.setBalance(account.getBalance() + amount);
			accountRepository.save(account);
			createStatement(accountNumber, amount, type);
		}
		else {
			throw new AccountNotFoundException("Account number: " + accountNumber + " is not present");
		}
	 }
	
	@Transactional
	public void withdraw(int accountNumber,int amount, String type) {
			Optional<Account> optionalAccount  = accountRepository.findById(accountNumber);
			if(optionalAccount.isPresent()) {
				Account account = optionalAccount.get();
				account.setBalance(account.getBalance() - amount);
				accountRepository.save(account);
				createStatement(accountNumber, amount, type);
			}
			else {
				throw new AccountNotFoundException("Account number: " + accountNumber + " is not present");
			}

	 }

	private void createStatement(int accountNumber, int amount, String type) {
		Statement statement = new Statement(accountNumber, type, amount);
		statementRepository.save(statement);
	}
}
