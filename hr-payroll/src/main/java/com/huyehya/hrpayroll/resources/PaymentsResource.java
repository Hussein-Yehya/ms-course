package com.huyehya.hrpayroll.resources;

import com.huyehya.hrpayroll.entities.Payment;
import com.huyehya.hrpayroll.services.PaymentsService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value ="/payments")
public class PaymentsResource {

    @Autowired
    private PaymentsService paymentsService;

    @HystrixCommand(fallbackMethod = "getPaymentAlternative")
    @GetMapping(value = "/{workerId}/days/{days}")
    public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable Integer days){
        return ResponseEntity.ok(paymentsService.getPayments(workerId, days));
    }

    public ResponseEntity<Payment> getPaymentAlternative(Long workerId, Integer days){
        Payment payment = Payment.builder().name("Brann").dailyIncome(400.0).days(20).build();
        return ResponseEntity.ok(payment);
    }
}
