# GRPC

* 编写pom文件，注意maven插件版本 protobuf-maven-plugin

* 编写 proto文件  helloworld.proto

* 右击`Maven.Projects\protobuf\protobuf:compile` ，选择`run`，生成用于序列化的java文件

* 右击`Maven.Projects\protobuf\protobuf:compile-custom`，选择`run`，生成用于rpc的java代码

* 注意以上两步执行之后，在generated-sources目录中生成的代码

* 编写服务端 RpcServer

* 编写客户端 RpcClient

* 运行服务端、客户端即可看到调用成功的信息

* protobuf下载地址

  https://github.com/google/protobuf/releases

