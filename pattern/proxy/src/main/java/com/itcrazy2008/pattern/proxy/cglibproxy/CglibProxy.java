package com.itcrazy2008.pattern.proxy.cglibproxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;


public class CglibProxy implements MethodInterceptor {

  //创建代理对象
  public Object createPorxyInstance(Class targetClass){
    Enhancer enhancer = new Enhancer();
    enhancer.setSuperclass(targetClass);
    enhancer.setCallback(this);
    return enhancer.create();
  }

  @Override
  public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
    before();
    Object result = methodProxy.invokeSuper(o,objects);
    after();
    return result;
  }

  private void after() {
    System.out.println("Cglib开始愉快的玩耍了");
  }

  private void before() {
    System.out.println("Cglib开始物色");
  }
}
