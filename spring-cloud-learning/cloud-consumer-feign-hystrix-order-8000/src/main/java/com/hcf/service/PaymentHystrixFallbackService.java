package com.hcf.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentHystrixFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfoOk(Integer id) {
        return "globalFallback service message: ok method";
    }

    @Override
    public String paymentTimeOut(Integer id) {
        return "globalFallback service message: timeOut method";
    }
}
