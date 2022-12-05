package com.hcf.controller;


import com.hcf.commom.CommonResult;
import com.hcf.entities.Payment;
import com.hcf.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("insert result: " + result);

        if (result > 0) {
            return new CommonResult<>(200, "insert success", result);
        } else {
            return new CommonResult<>(400, "get failure", null);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("get result: " + payment);
        int a = 1;
        if (payment != null) {
            return new CommonResult<>(200, "get success", payment);
        } else {
            return new CommonResult<>(400, "get failure", null);
        }
    }
}
