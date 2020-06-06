package com.itcrazy2008.pattern.proxy.jdkproxy;

public class Zhangsan implements IPersion{
  @Override
  public String findLove() {
    System.out.println("张三要找白富美。");
    return "找到了，返回结果。";
  }
}
