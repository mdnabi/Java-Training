package com.lti.training.test;

import java.util.List;
import java.util.Scanner;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lti.training.dao.CarPartsDao;
import com.lti.training.dao.CarPartsDaoImpl1;
import com.lti.training.dao.CarPartsDaoImpl2;
import com.lti.training.dao.CarPartsDaoImpl3;
import com.lti.training.exception.DataAccessException;
import com.lti.training.main.CarPart;


public class TestCarPart {
	
	@Test
	public void addPart() throws DataAccessException {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
//		CarPartsDao car = (CarPartsDao) context.getBean("carPartDao1");
//		CarPartsDao car = (CarPartsDao) context.getBean("carPartDao2");
		CarPartsDao car = (CarPartsDao) context.getBean("carPartDao3");

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
	
	@Test
	public void getCarPart() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
//		CarPartsDao car = (CarPartsDao) context.getBean("carPartDao3");
		CarPartsDao car = (CarPartsDao) context.getBean("carPartDao4");
		List<CarPart> list = car.getAvailableParts();
		System.out.println("Part Name\t CarModel\t PartNo\t Price\t Quantity");
		for(CarPart cpart: list) {
			System.out.println(cpart.getPartName() + "\t\t" + cpart.getCarModel() + "\t\t" + cpart.getPartNo() + "\t\t" + cpart.getPrice() + "\t\t" + cpart.getQuantity());
		}
	}
}
