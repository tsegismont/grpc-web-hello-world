package io.vertx.grpcweb;

import io.grpc.ServerInterceptors;
import io.grpc.ServerServiceDefinition;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerOptions;
import io.vertx.grpc.server.GrpcServer;
import io.vertx.grpc.server.GrpcServiceBridge;
import io.vertx.grpcweb.VertxUnimplementedServiceGrpcServer.UnimplementedServiceApi;

public class GrpcWebTestingVerticle extends AbstractVerticle {

  public static void main(String[] args) {
    Vertx.vertx().deployVerticle(new GrpcWebTestingVerticle())
            .onComplete(System.out::println, Throwable::printStackTrace);
  }

  @Override
  public void start(Promise<Void> startPromise) {
    GrpcServer grpcServer = GrpcServer.server(vertx);

    ServerServiceDefinition serviceDefinition = ServerInterceptors.intercept(new TestServiceImpl(context), new MyServerInterceptor());

    GrpcServiceBridge.bridge(serviceDefinition).bind(grpcServer);

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

}
