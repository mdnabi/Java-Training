package com.lti.training.bank;

import org.springframework.stereotype.Component;

@Component("bs")
public class BankSpring implements BankSpringInterface {

	public void withdraw(int acno, double balance, double amount) {
		System.out.println("Your acc no " +acno+ " balance " + balance + " have withdrawn " + amount);
		
	}

}
