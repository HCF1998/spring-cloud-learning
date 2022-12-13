package com.hcf.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author hcf
 */
@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT",fallback = PaymentHystrixFallbackService.class)
public interface PaymentHystrixService {

    /**
     * normal api
     * @param id id
     * @return response message
     */
    @GetMapping("/payment/hystrix/ok/{id}")
    String paymentInfoOk(@PathVariable("id") Integer id);

    /**
     * timeout api
     * @param id id
     * @return response message
     */
    @GetMapping("/payment/hystrix/timeout/{id}")
    String paymentTimeOut(@PathVariable("id") Integer id);
}
