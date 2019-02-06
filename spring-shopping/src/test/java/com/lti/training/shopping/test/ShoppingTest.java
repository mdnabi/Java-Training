package com.lti.training.shopping.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lti.training.dao.GenericRepository;
import com.lti.training.dto.ShoppingDTO;
import com.lti.training.entity.Product;
import com.lti.training.service.ShoppingService;

public class ShoppingTest {
	
	@Test
	public void addProduct() {
		Product product = new Product();
		product.setName("Moto E4");
		product.setPrice(8500);
		product.setStock(10);
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		GenericRepository generic =  context.getBean(GenericRepository.class);
		generic.store(product);
	}
	
	@Test
	public void placeOrder() {
		ShoppingDTO dto = new ShoppingDTO();
		dto.setProductId(141);
		dto.setPaymentMode("Debit Card");
		dto.setQuantity(1);		
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		ShoppingService service = context.getBean(ShoppingService.class);
		service.placeOrder(dto);
	}
}
