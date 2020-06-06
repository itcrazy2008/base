package com.itcrazy2008.jol;

import java.util.concurrent.Callable;

import org.openjdk.jol.info.ClassLayout;

public class TestSync {
    public static void main(String[] args) {
        Object obj = new Object();
        synchronized (obj){
            System.out.println(ClassLayout.parseInstance(obj).toPrintable());
        }
    }
}
