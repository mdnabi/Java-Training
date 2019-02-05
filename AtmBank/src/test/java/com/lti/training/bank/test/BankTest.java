package com.lti.training.bank.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lti.training.bank.AtmSpring;

public class BankTest {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		
		AtmSpring atm = (AtmSpring) context.getBean("asi");
		atm.atmspring(100, 25000, 15);
		
	}
}
