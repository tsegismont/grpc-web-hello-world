package io.vertx.grpcweb;

import io.grpc.*;

class MyServerInterceptor implements ServerInterceptor {

  // TODO

  @Override
  public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> call, Metadata metadata, ServerCallHandler<ReqT, RespT> next) {
    System.out.println("MyServerInterceptor.interceptCall");
    System.out.println("call = " + call + ", metadata = " + metadata + ", next = " + next);
    return next.startCall(new ForwardingServerCall.SimpleForwardingServerCall<>(call) {

      @Override
      public void sendHeaders(Metadata headers) {
        System.out.println("MyServerInterceptor.sendHeaders");
        System.out.println("headers = " + headers);
        super.sendHeaders(headers);
      }

      @Override
      public void close(Status status, Metadata trailers) {
        super.close(status, trailers);
      }
    }, metadata);
  }
}
