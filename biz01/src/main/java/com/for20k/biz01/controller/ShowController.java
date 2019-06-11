package com.for20k.biz01.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/show")
public class ShowController {
    @Value("${girl.name}")
    String val;

    @RequestMapping("/test")
    @ResponseBody
    public String test()
    {
        return "hello";
    }

    @RequestMapping("/name")
    @ResponseBody
    public String showname()
    {
        return "hello ," + val;
    }
}
