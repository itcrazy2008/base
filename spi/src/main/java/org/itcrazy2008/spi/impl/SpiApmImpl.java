package org.itcrazy2008.spi.impl;

import org.itcrazy2008.spi.SpiInterface;

public class SpiApmImpl implements SpiInterface {
  @Override
  public void boot() {
    System.out.println("this is SPI apm impl.");
  }
}
