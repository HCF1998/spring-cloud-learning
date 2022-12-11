package com.hcf.controller;

import com.hcf.commom.CommonResult;
import com.hcf.entities.Payment;
import com.hcf.service.PaymentServiceFeign;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderController {

    @Resource
    private PaymentServiceFeign paymentServiceFeign;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return paymentServiceFeign.getPaymentById(id);
    }

}
