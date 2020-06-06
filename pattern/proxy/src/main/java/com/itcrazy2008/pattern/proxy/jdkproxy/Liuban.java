package com.itcrazy2008.pattern.proxy.jdkproxy;

public class Liuban implements IPersion {
  @Override
  public String findLove() {
    System.out.println("刘邦也想找真爱");
    return "还真是找着了";
  }
}
