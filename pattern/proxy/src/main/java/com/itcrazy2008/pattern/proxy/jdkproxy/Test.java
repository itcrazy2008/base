//package com.itcrazy2008.pattern.proxy.jdkproxy;
//
////JDK动态代理 一定要有接口 利用反射来现的，所以性能会有损耗
//public class Test {
//  public static void main(String[] args) {
//    JdkProxy jdkProxy = new JdkProxy();
//    IPersion proxyInstance = (IPersion)jdkProxy.createPorxyInstance(new Zhangsan());
//    String result = proxyInstance.findLove();
//    System.out.println(result);
//
//    IPersion jiuban = (IPersion)jdkProxy.createPorxyInstance(new Liuban());
//    String result1 = jiuban.findLove();
//    System.out.println(result1);
//  }
//}
