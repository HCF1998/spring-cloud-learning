package com.hcf.springcloudlearning.service.impl;

import com.hcf.springcloudlearning.dao.PaymentDao;
import com.hcf.springcloudlearning.entities.Payment;
import com.hcf.springcloudlearning.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;


    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
