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

public class VertxTestServiceGrpcServer  {
  public interface TestServiceApi {
    default Future<io.vertx.grpcweb.GrpcWebTesting.Empty> emptyCall(io.vertx.grpcweb.GrpcWebTesting.Empty request) {
      throw new UnsupportedOperationException("Not implemented");
    }
    default void emptyCall(io.vertx.grpcweb.GrpcWebTesting.Empty request, Promise<io.vertx.grpcweb.GrpcWebTesting.Empty> response) {
      emptyCall(request)
        .onSuccess(msg -> response.complete(msg))
        .onFailure(error -> response.fail(error));
    }
    default Future<io.vertx.grpcweb.GrpcWebTesting.EchoResponse> unaryCall(io.vertx.grpcweb.GrpcWebTesting.EchoRequest request) {
      throw new UnsupportedOperationException("Not implemented");
    }
    default void unaryCall(io.vertx.grpcweb.GrpcWebTesting.EchoRequest request, Promise<io.vertx.grpcweb.GrpcWebTesting.EchoResponse> response) {
      unaryCall(request)
        .onSuccess(msg -> response.complete(msg))
        .onFailure(error -> response.fail(error));
    }
    default ReadStream<io.vertx.grpcweb.GrpcWebTesting.StreamingResponse> streamingCall(io.vertx.grpcweb.GrpcWebTesting.StreamingRequest request) {
      throw new UnsupportedOperationException("Not implemented");
    }
    default void streamingCall(io.vertx.grpcweb.GrpcWebTesting.StreamingRequest request, WriteStream<io.vertx.grpcweb.GrpcWebTesting.StreamingResponse> response) {
      streamingCall(request)
        .handler(msg -> response.write(msg))
        .endHandler(msg -> response.end())
        .resume();
    }

    default TestServiceApi bind_emptyCall(GrpcServer server) {
      server.callHandler(TestServiceGrpc.getEmptyCallMethod(), request -> {
        Promise<io.vertx.grpcweb.GrpcWebTesting.Empty> promise = Promise.promise();
        request.handler(req -> {
          try {
            emptyCall(req, promise);
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
    default TestServiceApi bind_unaryCall(GrpcServer server) {
      server.callHandler(TestServiceGrpc.getUnaryCallMethod(), request -> {
        Promise<io.vertx.grpcweb.GrpcWebTesting.EchoResponse> promise = Promise.promise();
        request.handler(req -> {
          try {
            unaryCall(req, promise);
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
    default TestServiceApi bind_streamingCall(GrpcServer server) {
      server.callHandler(TestServiceGrpc.getStreamingCallMethod(), request -> {
        request.handler(req -> {
          try {
            streamingCall(req, request.response());
          } catch (RuntimeException err) {
            request.response().status(GrpcStatus.INTERNAL).end();
          }
        });
      });
      return this;
    }

    default TestServiceApi bindAll(GrpcServer server) {
      bind_emptyCall(server);
      bind_unaryCall(server);
      bind_streamingCall(server);
      return this;
    }
  }
}
