package com.hcf.service;

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

    public String paymentInfoTimeOut(Integer id) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "TIMEOUT: " + Thread.currentThread().getName() + " id=" + id;
    }
}
