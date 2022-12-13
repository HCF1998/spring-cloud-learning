package com.hcf.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

/**
 * @author hcf
 */
@Service
public class PaymentService {
    /**
     * 正常返回
     */
    public String paymentInfoOk(Integer id) {
        return "OK: " + Thread.currentThread().getName() + " id=" + id;
    }

    @HystrixCommand(fallbackMethod = "paymentInfoTimeOutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String paymentInfoTimeOut(Integer id) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "TIMEOUT: " + Thread.currentThread().getName() + " id=" + id;
    }

    public String paymentInfoTimeOutHandler(Integer id){
        return "HANDLER: " + Thread.currentThread().getName() + " id=" + id;
    }
}
