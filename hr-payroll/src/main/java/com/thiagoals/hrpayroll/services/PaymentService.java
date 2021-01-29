package com.thiagoals.hrpayroll.services;

import org.springframework.stereotype.Service;

import com.thiagoals.hrpayroll.entities.Payment;

@Service
public class PaymentService {
	public Payment getPayment(Long workerId, Integer days) {
		return new Payment("Bob", 200.00, days);
	}
}
