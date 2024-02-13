package io.vertx.grpcweb;

import io.grpc.ForwardingServerCall.SimpleForwardingServerCall;
import io.grpc.Metadata;
import io.grpc.ServerCall;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;
import io.reactivex.rxjava3.core.Flowable;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerOptions;
import io.vertx.core.streams.ReadStream;
import io.vertx.grpc.server.GrpcServer;
import io.vertx.grpcweb.VertxTestServiceGrpcServer.TestServiceApi;
import io.vertx.grpcweb.VertxUnimplementedServiceGrpcServer.UnimplementedServiceApi;
import io.vertx.rxjava3.FlowableHelper;
import io.vertx.rxjava3.RxHelper;

import static io.vertx.grpcweb.GrpcWebTesting.*;
import static java.util.concurrent.TimeUnit.MILLISECONDS;

public class GrpcWebTestingVerticle extends AbstractVerticle {

  public static void main(String[] args) {
    Vertx.vertx().deployVerticle(new GrpcWebTestingVerticle())
            .onComplete(System.out::println, Throwable::printStackTrace);
  }

  @Override
  public void start(Promise<Void> startPromise) {
    GrpcServer grpcServer = GrpcServer.server(vertx);

    TestServiceApi testServiceStub = new TestServiceApi() {
      @Override
      public Future<Empty> emptyCall(Empty request) {
        return Future.succeededFuture(Empty.newBuilder().build());
      }

      @Override
      public Future<EchoResponse> unaryCall(EchoRequest request) {
        EchoResponse response = EchoResponse.newBuilder()
          .setPayload(request.getPayload())
          .build();
        return Future.succeededFuture(response);
      }

      @Override
      public ReadStream<StreamingResponse> streamingCall(StreamingRequest request) {
        Flowable<StreamingResponse> responses = Flowable.fromIterable(request.getResponseSizeList())
          .zipWith(Flowable.interval(1, MILLISECONDS, RxHelper.scheduler(context)), (responseSize, interval) -> {
            return StreamingResponse.newBuilder().setPayload("a".repeat(responseSize)).build();
          })
          .onBackpressureBuffer();
        return FlowableHelper.toReadStream(responses);
      }
    };

    testServiceStub.bindAll(grpcServer);

    UnimplementedServiceApi unimplementedServiceStub = new UnimplementedServiceApi() {
    };
    unimplementedServiceStub.bindAll(grpcServer);

    HttpServer server = vertx.createHttpServer(new HttpServerOptions());

    server
      .requestHandler(grpcServer)
      .listen(9090)
      .<Void>mapEmpty()
      .onComplete(startPromise);
  }

  private static class MyServerInterceptor implements ServerInterceptor {

    // TODO

    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> call, Metadata metadata, ServerCallHandler<ReqT, RespT> next) {
      return next.startCall(new SimpleForwardingServerCall<>(call) {
      }, metadata);
    }
  }
}
