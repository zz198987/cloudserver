package com.for20k.biz01.controller;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("biz02")
public interface Feignclient {

    @RequestMapping("/remote/invoke")
    public String get();

    @RequestMapping("/remote/get/{num}")
    public String get(@PathVariable("num") String num);
}
