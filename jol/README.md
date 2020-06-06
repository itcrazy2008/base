了解数据占用空间的大小是很常见的监控需要。
常规方式，人工可以按照Java基础数据类型大小及内容大小估算出缓存对象的大概堆占用，但是麻烦还不准。
OpenJDK，提供了JOL包，可以帮我们在运行时计算某个对象的大小，是非常好的工具
官网：http://openjdk.java.net/projects/code-tools/jol/
定位：分析对象在JVM的大小和分布