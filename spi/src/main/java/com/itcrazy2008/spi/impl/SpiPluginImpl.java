package com.itcrazy2008.spi.impl;

import com.itcrazy2008.spi.SpiInterface;

public class SpiPluginImpl implements SpiInterface {
  @Override
  public void boot() {
    System.out.println("this is SPI plugin impl.");
  }
}
