package com.hcf.springcloudlearning.service;

import com.hcf.springcloudlearning.entities.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {
    /**
     * 创建
     * @param payment
     * @return
     */
    int create(Payment payment);

    /**
     * 查询返回
     * @param id
     * @return Payment实体
     */
    Payment getPaymentById(@Param("id") Long id);
}
