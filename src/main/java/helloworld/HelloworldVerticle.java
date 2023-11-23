package helloworld;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerOptions;
import io.vertx.grpc.server.GrpcServer;

public class HelloworldVerticle extends AbstractVerticle {

  @Override
  public void start(Promise<Void> startPromise) {
    GrpcServer grpcServer = GrpcServer.server(vertx);

    VertxGreeterGrpcServer.GreeterApi stub = new VertxGreeterGrpcServer.GreeterApi() {
      @Override
      public void sayHello(Helloworld.HelloRequest request, Promise<Helloworld.HelloReply> response) {
        response.complete(Helloworld.HelloReply.newBuilder().setMessage("Hello " + request.getName()).build());
      }
    };

    stub.bindAll(grpcServer);

    HttpServer server = vertx.createHttpServer(new HttpServerOptions());

    server
      .requestHandler(grpcServer)
      .listen(9090)
      .<Void>mapEmpty()
      .onComplete(startPromise);
  }
}
