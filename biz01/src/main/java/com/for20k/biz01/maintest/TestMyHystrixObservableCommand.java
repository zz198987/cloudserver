package com.for20k.biz01.maintest;

import rx.Observable;

import java.util.Iterator;

public class TestMyHystrixObservableCommand {
    public static void main(String[] args) {
        testToObservable();
    }

    public static void testObservable() {
        Observable<String> observable= new MyHystrixObservableCommand("World").observe();

        Iterator<String> iterator = observable.toBlocking().getIterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }


    public static void testToObservable() {
        Observable<String> observable= new MyHystrixObservableCommand("World3").toObservable();
        Iterator<String> iterator = observable.toBlocking().getIterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
