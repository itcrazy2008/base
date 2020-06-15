package com.itcrazy2008.grpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.util.logging.Logger;

import com.itcrazy2008.grpc.remote.grpc.proto.GreeterGrpc;
import com.itcrazy2008.grpc.remote.grpc.proto.HelloReply;
import com.itcrazy2008.grpc.remote.grpc.proto.HelloRequest;

public class RpcServer {
  private static final Logger logger = Logger.getLogger(RpcServer.class.getName());

  private int port = 50051;
  private Server server;

  private void start() throws IOException{
    server = ServerBuilder.forPort(port)
        .addService(new GreeterImpl())
        .build()
        .start();
    logger.info("Server started, listening on "+ port);

    Runtime.getRuntime().addShutdownHook(new Thread(){

      @Override
      public void run(){

        System.err.println("*** shutting down gRPC server since JVM is shutting down");
        RpcServer.this.stop();
        System.err.println("*** server shut down");
      }
    });
  }

  private void stop(){
    if (server != null){
      server.shutdown();
    }
  }

  // block 一直到退出程序
  private void blockUntilShutdown() throws InterruptedException {
    if (server != null){
      server.awaitTermination();
    }
  }


  public  static  void main(String[] args) throws IOException, InterruptedException {

    final RpcServer server = new RpcServer();
    server.start();
    server.blockUntilShutdown();
  }


  // 实现 定义一个实现服务接口的类
  private class GreeterImpl extends GreeterGrpc.GreeterImplBase {

    @Override
    public void sayHello(HelloRequest req, StreamObserver<HelloReply> responseObserver){
      HelloReply reply = HelloReply.newBuilder().setMessage(("Hello "+req.getName())).build();
      responseObserver.onNext(reply);
      responseObserver.onCompleted();
      System.out.println("Message from gRPC-Client:" + req.getName());
    }
  }
}