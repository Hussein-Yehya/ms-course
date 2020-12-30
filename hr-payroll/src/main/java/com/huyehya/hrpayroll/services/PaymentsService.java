package com.huyehya.hrpayroll.services;

import com.huyehya.hrpayroll.entities.Payments;
import org.springframework.stereotype.Service;

@Service
public class PaymentsService {

    public Payments getPayments(Long workerId, Integer days){
        return Payments.builder().name("Bob").dailyIncome(120.0).days(days).build();
    }
}
