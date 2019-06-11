package com.for20k.biz01.maintest;

import rx.Observable;
import rx.Observer;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class TestMyHystrixCommand {
    public static void main(String [] args){
        toObservable();
    }

    public static void sync()
    {
        System.out.println(new MyHystrixCommand("World").execute());
    }
    public static void async()
    {
        Future<String> stringFuture = new MyHystrixCommand("World").queue();
        try {
            System.out.println(stringFuture.get());
            System.out.println("=======over======");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static void observe()
    {
        Observable<String> ho = new MyHystrixCommand("World").observe();
        ho.subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {
                System.out.println("==============onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onNext(String s) {
                System.out.println("=========onNext: " + s);
            }
        });

//        ho.subscribe(new Action1<String>() {
//            @Override
//            public void call(String s) {
//                System.out.println("==================call:" + s);
//            }
//        });
    }

    public static void toObservable()
    {
        Observable<String> ho = new MyHystrixCommand("World").toObservable();
        System.out.println(ho.toBlocking().single());
    }
}
