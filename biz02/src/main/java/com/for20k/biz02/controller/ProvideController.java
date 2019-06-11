package com.for20k.biz02.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/remote")
public class ProvideController {

    @Value("${girl.name}")
    String val;

    @RequestMapping("/invoke")
    @ResponseBody
    public String showname()
    {
        String shit="fuucku!";
        System.out.println("i am invoke ...");
        return shit+" hello , i am biz02 ,i get "+ val ;
    }

    @RequestMapping("/get/{num}")
    @ResponseBody
    public String get(@PathVariable String num)
    {
        return "from biz02 : get "+ num ;
    }
}
