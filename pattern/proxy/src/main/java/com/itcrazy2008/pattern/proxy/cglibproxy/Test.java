package com.itcrazy2008.pattern.proxy.cglibproxy;

//CGLIB动态代理 是基于继承来实现的 所以性能会比JDK要好
public class Test {
  public static void main(String[] args) {
    CglibProxy cglibProxy = new CglibProxy();
    Zhangsan proxyInstance = (Zhangsan)cglibProxy.createPorxyInstance(Zhangsan.class);
    String result = proxyInstance.findLove();
    System.out.println(result);

    Liuban jiuban = (Liuban)cglibProxy.createPorxyInstance(Liuban.class);
    String result1 = jiuban.findLove();
    System.out.println(result1);
  }
}
