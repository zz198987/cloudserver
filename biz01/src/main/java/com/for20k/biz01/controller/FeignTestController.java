package com.for20k.biz01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feign")
public class FeignTestController {

    @Autowired
    Feignclient feignclient;

    @RequestMapping("/get")
    @ResponseBody
    public String get()
    {
        return feignclient.get();
    }
    @RequestMapping("/getnum/{num}")
    @ResponseBody
    public String get(@PathVariable String num)
    {
        return feignclient.get(num);
    }
}
