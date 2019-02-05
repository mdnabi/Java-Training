package com.lti.training.test;

import java.util.Scanner;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lti.training.dao.CarPartsDaoImpl1;
import com.lti.training.exception.DataAccessException;
import com.lti.training.main.CarPart;


public class TestCarPart {
	
	@Test
	public void addPart() throws DataAccessException {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		CarPartsDaoImpl1 car = (CarPartsDaoImpl1) context.getBean("carPartDao1");
		
		
		CarPartsDaoImpl1 carPart = new CarPartsDaoImpl1();
		CarPart part = new CarPart();
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the name, car model, part no, price and quantity: ");
		String partName = input.next();
		String carModel = input.next();
		int partNo = input.nextInt();
		double price = input.nextDouble();
		int quantity = input.nextInt();
				
		part.setPartName(partName);
		part.setCarModel(carModel);
		part.setPartNo(partNo);
		part.setPrice(price);
		part.setQuantity(quantity);
		
		car.addNewPart(part);
	}
}
