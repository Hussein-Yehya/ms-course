package com.huyehya.hrpayroll.services;

import com.huyehya.hrpayroll.entities.Payments;
import com.huyehya.hrpayroll.entities.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentsService {

    @Value("${hr-worker.host}")
    private String workerHost;

    @Autowired
    private RestTemplate restTemplate;

    public Payments getPayments(Long workerId, Integer days){
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("id", String.valueOf(workerId));

        Worker worker = restTemplate.getForObject(workerHost.concat("/workers/{id}"), Worker.class, uriVariables);

        return Payments.builder().name(worker.getName()).dailyIncome(worker.getDailyIncome()).days(days).build();
    }
}
