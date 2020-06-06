package com.itcrazy2008.pattern.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxy implements InvocationHandler {

  private Object target;

  public Object createPorxyInstance(Object target){
    this.target = target;
    Object proxyInstance = (Object)Proxy
        .newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    return proxyInstance;
  }

  private void after() {
    System.out.println("开始愉快的玩耍了");
  }

  private void before() {
    System.out.println("开始物色");
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    before();
    Object result = method.invoke(target,args);
    after();
    return result;
  }
}
