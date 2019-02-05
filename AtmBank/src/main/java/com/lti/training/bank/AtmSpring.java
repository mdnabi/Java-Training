package com.lti.training.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component("asi")
public class AtmSpring implements AtmSpringInterface {

	@Autowired
	@Qualifier("bs") 
	private BankSpring bankSpring;
	
	public void atmspring(int acno, double balance, double amount) {
		System.out.println("Bank Account Loaded");
		bankSpring.withdraw(acno, balance, amount);
		
	}
	
}
