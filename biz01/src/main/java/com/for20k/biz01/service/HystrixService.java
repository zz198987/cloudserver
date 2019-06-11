package com.for20k.biz01.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import rx.Observable;
import rx.Subscriber;


import java.util.concurrent.Future;

@Service
public class HystrixService {

    @Autowired
    RestTemplate restTemplate;


    @HystrixCommand(fallbackMethod = "fallmethod")
    public String rpc()
    {
        return restTemplate.getForObject("a",String.class);
    }

    @HystrixCommand(fallbackMethod = "fallmethod")
    public Future<String> rpcAsync()
    {
        return new AsyncResult<String>() {
            @Override
            public String invoke() {
                return restTemplate.getForObject("a",String.class);
            }
        };
    }

    @HystrixCommand(fallbackMethod = "fallmethod")
    public Observable<String> rpcObserve()
    {
        return  Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                System.out.println("i am in call");
                String result = restTemplate.getForObject("a",String.class);
                subscriber.onCompleted();
                subscriber.onNext(result);
            }
        });
    }

    public String fallmethod()
    {
        return "shit,error!";
    }

}
