package io.vertx.grpcweb;

import io.vertx.core.Future;
import io.vertx.core.Promise;
import io.vertx.core.Handler;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.core.streams.ReadStream;
import io.vertx.core.streams.WriteStream;
import io.vertx.grpc.common.GrpcStatus;
import io.vertx.grpc.server.GrpcServer;
import io.vertx.grpc.server.GrpcServerResponse;

import java.util.ArrayList;
import java.util.List;

public class VertxUnimplementedServiceGrpcServer  {
  public interface UnimplementedServiceApi {
    default Future<io.vertx.grpcweb.GrpcWebTesting.Empty> unimplementedCall(io.vertx.grpcweb.GrpcWebTesting.Empty request) {
      throw new UnsupportedOperationException("Not implemented");
    }
    default void unimplementedCall(io.vertx.grpcweb.GrpcWebTesting.Empty request, Promise<io.vertx.grpcweb.GrpcWebTesting.Empty> response) {
      unimplementedCall(request)
        .onSuccess(msg -> response.complete(msg))
        .onFailure(error -> response.fail(error));
    }

    default UnimplementedServiceApi bind_unimplementedCall(GrpcServer server) {
      server.callHandler(UnimplementedServiceGrpc.getUnimplementedCallMethod(), request -> {
        Promise<io.vertx.grpcweb.GrpcWebTesting.Empty> promise = Promise.promise();
        request.handler(req -> {
          try {
            unimplementedCall(req, promise);
          } catch (RuntimeException err) {
            promise.tryFail(err);
          }
        });
        promise.future()
          .onFailure(err -> request.response().status(GrpcStatus.INTERNAL).end())
          .onSuccess(resp -> request.response().end(resp));
      });
      return this;
    }

    default UnimplementedServiceApi bindAll(GrpcServer server) {
      bind_unimplementedCall(server);
      return this;
    }
  }
}
