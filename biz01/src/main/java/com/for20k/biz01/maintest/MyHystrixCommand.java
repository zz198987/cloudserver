package com.for20k.biz01.maintest;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class MyHystrixCommand extends HystrixCommand<String> {

    private String name;
     MyHystrixCommand(String name) {
         super(HystrixCommandGroupKey.Factory.asKey(name));
        this.name = name;
    }

    @Override
    protected String run() throws Exception {
        int i=1/0;
        return ""+i;
    }


    @Override
    protected String getFallback() {
        return "shit happened";
    }
}
