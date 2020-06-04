package com.haha.springcloud.service.impl;

import com.haha.springcloud.dao.PaymentDao;
import com.haha.springcloud.entities.Payment;
import com.haha.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {


    // @Resource也可以 ，javax的注解
    @Autowired
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
