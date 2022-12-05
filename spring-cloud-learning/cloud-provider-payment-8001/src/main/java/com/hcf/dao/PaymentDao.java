package com.hcf.dao;

import com.hcf.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author admin
 */
@Mapper
public interface PaymentDao {

    /**
     * 创建
     * @param payment
     * @return
     */
    int create(Payment payment);

    /**
     * 返回
     * @param id
     * @return
     */
    Payment getPaymentById(@Param("id") Long id);
}
