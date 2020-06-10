# SPI



## 概述

* SPI全称Service Provider Interface
* SPI是Java提供的一套用来被第三方实现或者扩展的接口，它可以用来启用框架扩展和替换组件
*  SPI的作用就是为这些被扩展的API寻找服务实现



## SPI和API的区别

* API （Application Programming Interface）
  * 在大多数情况下，都是实现方制定接口并完成对接口的实现，调用方仅仅依赖接口调用，且无权选择不同实现
  * 从使用人员上来说，API 直接被应用开发人员使用
* SPI （Service Provider Interface）
  * SPI是调用方来制定接口规范，提供给外部来实现，调用方在调用时则选择自己需要的外部实现
  * 从使用人员上来说，SPI 被框架扩展人员使用



## SPI 实现步骤

1. 定义一个接口，如：SpiInterface

2. 这个接口分别有两个实现，如：SpiPluginImpl   SpiApmImpl

3. 然后在resources目录下新建META-INF/services目录

4. 在META-INF/services目录下新建一个与上述接口的全限定名一致的文件 org.itcrazy2008.spi.SpiInterface

5. 文件中写入接口的实现类的全限定名,内容如下：

   > ```
   > org.itcrazy2008.spi.impl.SpiPluginImpl
   > org.itcrazy2008.spi.impl.SpiApmImpl
   > ```

6. 编写测试类 SpiMain

7. 在测试类中 通过ServiceLoader加载实现类并调用

8. 运行测试类，输出如下：

   > this is SPI plugin impl.
   > this is SPI apm impl.

9. 这样一个简单的SPI的程序就完成了。可以看到其中最为核心的就是通过ServiceLoader这个类来加载具体的实现类的。

10. 从ServiceLoader的源码中可以看出其实现的原理和流程大概如下：

    > 扫描META-INF/services目录中的指定接口名的文件
    >
    > 读取文件中的内容，并实现化定义的接口实现



## SPI再扩展

* 以上基本例子还是太简单了，且有着以下的弊端
  * 只能遍历所有的实现，并全部实例化
  * 配置文件中只是简单的列出了所有的扩展实现，而没有给他们命名。导致在程序中很难去准确的引用它们
  * 扩展如果依赖其他的扩展，做不到自动注入和装配
  * 扩展很难和其他的框架集成，比如扩展里面依赖了一个Spring bean，原生的Java SPI不支持
*  基于以上的弊端，其它第三方的框架基于以上原理，实现了对自己的扩展 ，如dubbo
  * **扩展点**：一个接口
  * **扩展**：扩展（接口）的实现
  * **扩展自适应实例：**其实就是一个Extension的代理，它实现了扩展点接口。在调用扩展点的接口方法时，会根据实际的参数来决定要使用哪个扩展。dubbo会根据接口中的参数，自动地决定选择哪个实现
  * **@SPI**:该注解作用于扩展点的接口上，表明该接口是一个扩展点
  * **@Adaptive：**@Adaptive注解用在扩展接口的方法上。表示该方法是一个自适应方法。Dubbo在为扩展点生成自适应实例时，如果方法有@Adaptive注解，会为该方法生成对应的代码
  * dubbo的spi也会从某些固定的路径下去加载配置文件，并且配置的格式与java原生的不一样，类似于property文件的格式



## 总结(能带来的好处)

* 不需要改动源码就可以实现扩展，解耦

* 实现扩展对原来的代码几乎没有侵入性

* 只需要添加配置就可以实现扩展，符合开闭原则

  

