package com.hcf.controller;


import com.hcf.commom.CommonResult;
import com.hcf.entities.Payment;
import com.hcf.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("insert result: " + result);

        if (result > 0) {
            return new CommonResult<>(200, "insert success,server port: " + serverPort, result);
        } else {
            return new CommonResult<>(400, "get failure", null);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("get result: " + payment);
        if (payment != null) {
            return new CommonResult<>(200, "get success,server port: " + serverPort, payment);
        } else {
            return new CommonResult<>(400, "get failure", null);
        }
    }

    @GetMapping("/payment/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("*****service:{}", service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-CONSUMER-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info("*****instance: serviceId = {}  host = {} port = {} uri = {}",
                    instance.getServiceId(),
                    instance.getHost(),
                    instance.getPort(),
                    instance.getUri());
        }
        return discoveryClient;
    }

    @GetMapping("/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }
}
