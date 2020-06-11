package com.haha.springcloud.service;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {

    /**
     * 正常访问
     *
     * @param id
     * @return
     */
    public String paymnetInfo_OK(Integer id) {
        return "线程池" + Thread.currentThread().getName() + " paymentInfo_OK,id:   " + id;
    }

    /**
     * 超时访问
     *
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "500")  //3秒钟以内就是正常的业务逻辑
    })
    public String paymentInfo_Timeout(Integer id) {

//        int age = 10/0;
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池" + Thread.currentThread().getName() + " paymentInfo_Timeout,id:   " + id;
    }

    /**
     * hystrix fallback
     *
     * @param id
     * @return
     */
    public String paymentInfo_TimeoutHandler(Integer id) {
        return "超时或运行异常咯，id:" + id;
    }
}
