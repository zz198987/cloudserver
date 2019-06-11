package com.for20k.biz01.controller;

import com.for20k.biz01.service.HystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import rx.Subscriber;

@RequestMapping("/hystrix")
@RestController
public class HystrixController {

    @Autowired
    HystrixService hystrixService;

    @RequestMapping("/observe")
    @ResponseBody
    public void observe()
    {
        hystrixService.rpcObserve().subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                System.out.println("完成");
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onNext(String s) {
                System.out.println("接收到了"+s);
            }
        });
    }
}
