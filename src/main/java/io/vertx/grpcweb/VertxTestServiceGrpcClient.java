package io.vertx.grpcweb;

import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.net.SocketAddress;
import io.vertx.grpc.client.GrpcClient;
import io.vertx.core.streams.ReadStream;
import io.vertx.core.streams.WriteStream;
import io.vertx.grpc.common.GrpcStatus;

public class VertxTestServiceGrpcClient {
  private final GrpcClient client;
  private final SocketAddress socketAddress;

  public VertxTestServiceGrpcClient(GrpcClient client, SocketAddress socketAddress) {
    this.client = client;
    this.socketAddress = socketAddress;
  }

  public Future<io.vertx.grpcweb.GrpcWebTesting.Empty> emptyCall(io.vertx.grpcweb.GrpcWebTesting.Empty request) {
    return client.request(socketAddress, TestServiceGrpc.getEmptyCallMethod()).compose(req -> {
      req.end(request);
      return req.response().compose(resp -> resp.last());
    });
  }

  public Future<io.vertx.grpcweb.GrpcWebTesting.EchoResponse> unaryCall(io.vertx.grpcweb.GrpcWebTesting.EchoRequest request) {
    return client.request(socketAddress, TestServiceGrpc.getUnaryCallMethod()).compose(req -> {
      req.end(request);
      return req.response().compose(resp -> resp.last());
    });
  }

  public Future<ReadStream<io.vertx.grpcweb.GrpcWebTesting.StreamingResponse>> streamingCall(io.vertx.grpcweb.GrpcWebTesting.StreamingRequest request) {
    return client.request(socketAddress, TestServiceGrpc.getStreamingCallMethod()).compose(req -> {
      req.end(request);
      return req.response().flatMap(resp -> {
        if (resp.status() != null && resp.status() != GrpcStatus.OK) {
          return Future.failedFuture("Invalid gRPC status " + resp.status());
        } else {
          return Future.succeededFuture(resp);
        }
      });
    });
  }

}
