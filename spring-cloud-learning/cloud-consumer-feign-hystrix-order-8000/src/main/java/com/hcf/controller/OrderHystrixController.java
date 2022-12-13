package com.hcf.controller;

import com.hcf.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@DefaultProperties(defaultFallback = "globalFallback")
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    /**
     * normal api
     * @param id id
     * @return response message
     */
    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    String paymentInfoOk(@PathVariable("id") Integer id){
         return "Order: "+paymentHystrixService.paymentInfoOk(id);
    }

    /**
     * timeout api
     * @param id id
     * @return response message
     */
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    @HystrixCommand
//    @HystrixCommand(fallbackMethod = "paymentTimeOutFallback",commandProperties={
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3500")
//    })
    String paymentTimeOut(@PathVariable("id") Integer id){
        return "0rder: "+paymentHystrixService.paymentTimeOut(id);
    }

    public String paymentTimeOutFallback(@PathVariable("id") Integer id){
        return "Order handler: ";
    }

    public String globalFallback(){
        return "globalFallback: ";
    }
}
