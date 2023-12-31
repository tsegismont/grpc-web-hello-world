package helloworld;

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

public class VertxGreeterGrpcServer  {
  public interface GreeterApi {
    default Future<helloworld.Helloworld.HelloReply> sayHello(helloworld.Helloworld.HelloRequest request) {
      throw new UnsupportedOperationException("Not implemented");
    }
    default void sayHello(helloworld.Helloworld.HelloRequest request, Promise<helloworld.Helloworld.HelloReply> response) {
      sayHello(request)
        .onSuccess(msg -> response.complete(msg))
        .onFailure(error -> response.fail(error));
    }
    default ReadStream<helloworld.Helloworld.HelloReply> sayRepeatHello(helloworld.Helloworld.RepeatHelloRequest request) {
      throw new UnsupportedOperationException("Not implemented");
    }
    default void sayRepeatHello(helloworld.Helloworld.RepeatHelloRequest request, WriteStream<helloworld.Helloworld.HelloReply> response) {
      sayRepeatHello(request)
        .handler(msg -> response.write(msg))
        .endHandler(msg -> response.end())
        .resume();
    }

    default GreeterApi bind_sayHello(GrpcServer server) {
      server.callHandler(GreeterGrpc.getSayHelloMethod(), request -> {
        Promise<helloworld.Helloworld.HelloReply> promise = Promise.promise();
        request.handler(req -> {
          try {
            sayHello(req, promise);
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
    default GreeterApi bind_sayRepeatHello(GrpcServer server) {
      server.callHandler(GreeterGrpc.getSayRepeatHelloMethod(), request -> {
        request.handler(req -> {
          try {
            sayRepeatHello(req, request.response());
          } catch (RuntimeException err) {
            request.response().status(GrpcStatus.INTERNAL).end();
          }
        });
      });
      return this;
    }

    default GreeterApi bindAll(GrpcServer server) {
      bind_sayHello(server);
      bind_sayRepeatHello(server);
      return this;
    }
  }
}
