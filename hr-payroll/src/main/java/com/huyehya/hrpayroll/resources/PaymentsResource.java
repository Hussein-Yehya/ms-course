package com.huyehya.hrpayroll.resources;

import com.huyehya.hrpayroll.services.PaymentsService;
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

    @GetMapping(value = "/{workerId}/days/{days}")
    public ResponseEntity<?> getPayment(@PathVariable Long workerId, @PathVariable Integer days){
        return ResponseEntity.ok(paymentsService.getPayments(workerId, days));
    }
}
