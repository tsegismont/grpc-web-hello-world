package io.vertx.grpcweb;

import io.grpc.ServerInterceptors;
import io.grpc.ServerServiceDefinition;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerOptions;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.CorsHandler;
import io.vertx.grpc.server.GrpcServer;
import io.vertx.grpc.server.GrpcServiceBridge;
import io.vertx.grpcweb.VertxUnimplementedServiceGrpcServer.UnimplementedServiceApi;

import java.util.Set;

public class GrpcWebTestingVerticle extends AbstractVerticle {

  public static void main(String[] args) {
    Vertx.vertx().deployVerticle(new GrpcWebTestingVerticle())
            .onComplete(System.out::println, Throwable::printStackTrace);
  }

  @Override
  public void start(Promise<Void> startPromise) {

    Router router = Router.router(vertx);

    router.route().handler(CorsHandler.create()
      .exposedHeader("x-header-text-key,x-header-bin-key-bin,x-trailer-text-key,x-trailer-bin-key-bin,x-error-trailer,grpc-status,grpc-message"));

    GrpcServer grpcServer = GrpcServer.server(vertx);

    ServerServiceDefinition testServiceDef = ServerInterceptors.intercept(new TestServiceImpl(context), new MyServerInterceptor());

    GrpcServiceBridge.bridge(testServiceDef).bind(grpcServer);

    router.post("/" + TestServiceGrpc.SERVICE_NAME + "/*").handler(rc -> grpcServer.handle(rc.request()));

    UnimplementedServiceApi unimplementedServiceStub = new UnimplementedServiceApi() {
    };
    unimplementedServiceStub.bindAll(grpcServer);

    router.post("/" + UnimplementedServiceGrpc.SERVICE_NAME + "/*").handler(rc -> grpcServer.handle(rc.request()));

    HttpServer server = vertx.createHttpServer(new HttpServerOptions());

    server
      .requestHandler(router)
      .listen(8080)
      .<Void>mapEmpty()
      .onComplete(startPromise);
  }

}
