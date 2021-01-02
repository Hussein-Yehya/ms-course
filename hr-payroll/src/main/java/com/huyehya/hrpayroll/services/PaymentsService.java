package com.huyehya.hrpayroll.services;

import com.huyehya.hrpayroll.entities.Payment;
import com.huyehya.hrpayroll.entities.Worker;
import com.huyehya.hrpayroll.feignclients.WorkerFeignClient;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


@Service
public class PaymentsService {

    @Autowired
    private WorkerFeignClient workerFeignClient;

    public Payment getPayments(Long workerId, Integer days) {
        Worker worker = workerFeignClient.findById(workerId).getBody();
        return Payment.builder().name(worker.getName()).dailyIncome(worker.getDailyIncome()).days(days).build();
    }
}
