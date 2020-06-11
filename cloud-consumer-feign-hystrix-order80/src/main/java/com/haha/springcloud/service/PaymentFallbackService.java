package com.haha.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentHystrixService {

    @Override
    public String paymentInfo_OK(Integer id) {
        return "失败了啊啊啊啊啊";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "失败了aaaaaaa";
    }
}
