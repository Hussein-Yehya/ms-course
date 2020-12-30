package com.huyehya.hrpayroll.entities;

import lombok.*;

@Builder
@Getter
@Setter
public class Payments {

    private String name;
    private Double dailyIncome;
    private Integer days;

    public double getTotal() {
        return days * dailyIncome;
    }
}
