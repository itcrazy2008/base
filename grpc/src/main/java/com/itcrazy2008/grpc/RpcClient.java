package com.itcrazy2008.grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.itcrazy2008.grpc.remote.grpc.proto.GreeterGrpc;
import com.itcrazy2008.grpc.remote.grpc.proto.HelloReply;
import com.itcrazy2008.grpc.remote.grpc.proto.HelloRequest;


public class RpcClient {
  private final ManagedChannel channel;
  private final GreeterGrpc.GreeterBlockingStub blockingStub;
  private static final Logger logger = Logger.getLogger(RpcClient.class.getName());

  public RpcClient(String host,int port){
    channel = ManagedChannelBuilder.forAddress(host,port)
        .usePlaintext(true)
        .build();

    blockingStub = GreeterGrpc.newBlockingStub(channel);
  }


  public void shutdown() throws InterruptedException {
    channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
  }

  public  void greet(String name){
    HelloRequest request = HelloRequest.newBuilder().setName(name).build();
    HelloReply response;
    try{
      response = blockingStub.sayHello(request);
    } catch (StatusRuntimeException e)
    {
      logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
      return;
    }
    logger.info("Message from gRPC-Server: "+response.getMessage());
  }

  public static void main(String[] args) throws InterruptedException {
    RpcClient client = new RpcClient("127.0.0.1",50051);
    try{
      String user = "world";
      if (args.length > 0){
        user = args[0];
      }
      client.greet(user);
    }finally {
      client.shutdown();
    }
  }
}
