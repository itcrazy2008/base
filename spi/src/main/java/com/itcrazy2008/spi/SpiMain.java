package com.itcrazy2008.spi;

import java.util.ServiceLoader;

public class SpiMain
{
    public static void main( String[] args )
    {
        //ServiceLoader是关键,且其定义了  private static final String PREFIX = "META-INF/services/";
        //注意其目录下定义的文件名和接口全路径名对应起来 com.itcrazy2008.spi.SpiInterface
        //文件中的内容就是接口的实现类全路径名
        ServiceLoader<SpiInterface> serviceLoader = ServiceLoader.load(SpiInterface.class);
        for (SpiInterface instance:serviceLoader){
            instance.boot();
        }
    }
}
