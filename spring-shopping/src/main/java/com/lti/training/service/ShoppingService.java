package com.lti.training.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.training.dao.DetailsRepository;
import com.lti.training.dao.GenericRepository;
import com.lti.training.dto.ShoppingDTO;
import com.lti.training.entity.Order;
import com.lti.training.entity.Payment;
import com.lti.training.entity.Product;

@Service
public class ShoppingService {

	@Autowired
	private GenericRepository genericRepository;
	
	@Transactional
	public void placeOrder(ShoppingDTO shoppingDTO) {
		Product product = genericRepository.fetchById(Product.class, shoppingDTO.getProductId());
		double totalAmount = product.getPrice() * shoppingDTO.getQuantity();
		
		//Updating tables on user purchase
		Order order = new Order();
		order.setAmount(totalAmount);
		order.setDate(new Date());
		genericRepository.store(order);
		
		Payment payment = new Payment();
		payment.setAmount(totalAmount);
		payment.setMode(shoppingDTO.getPaymentMode());
		genericRepository.store(payment);
		
		product.setStock(product.getStock() - shoppingDTO.getQuantity());
		genericRepository.store(product);
		
	}

}
