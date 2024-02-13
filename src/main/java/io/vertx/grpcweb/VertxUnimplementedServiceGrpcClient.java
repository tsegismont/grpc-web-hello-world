package io.vertx.grpcweb;

import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.net.SocketAddress;
import io.vertx.grpc.client.GrpcClient;
import io.vertx.core.streams.ReadStream;
import io.vertx.core.streams.WriteStream;
import io.vertx.grpc.common.GrpcStatus;

public class VertxUnimplementedServiceGrpcClient {
  private final GrpcClient client;
  private final SocketAddress socketAddress;

  public VertxUnimplementedServiceGrpcClient(GrpcClient client, SocketAddress socketAddress) {
    this.client = client;
    this.socketAddress = socketAddress;
  }

  public Future<io.vertx.grpcweb.GrpcWebTesting.Empty> unimplementedCall(io.vertx.grpcweb.GrpcWebTesting.Empty request) {
    return client.request(socketAddress, UnimplementedServiceGrpc.getUnimplementedCallMethod()).compose(req -> {
      req.end(request);
      return req.response().compose(resp -> resp.last());
    });
  }

}
