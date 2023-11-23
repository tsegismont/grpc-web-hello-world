package helloworld;

import io.reactivex.rxjava3.core.Flowable;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerOptions;
import io.vertx.core.streams.ReadStream;
import io.vertx.grpc.server.GrpcServer;
import io.vertx.rxjava3.FlowableHelper;
import io.vertx.rxjava3.RxHelper;

import static java.util.concurrent.TimeUnit.SECONDS;

public class HelloworldVerticle extends AbstractVerticle {

  public static void main(String[] args) {
    Vertx.vertx().deployVerticle(new HelloworldVerticle())
            .onComplete(System.out::println, Throwable::printStackTrace);
  }

  @Override
  public void start(Promise<Void> startPromise) {
    GrpcServer grpcServer = GrpcServer.server(vertx);

    VertxGreeterGrpcServer.GreeterApi stub = new VertxGreeterGrpcServer.GreeterApi() {
      @Override
      public void sayHello(Helloworld.HelloRequest request, Promise<Helloworld.HelloReply> response) {
        response.complete(Helloworld.HelloReply.newBuilder().setMessage("Hello " + request.getName()).build());
      }

      @Override
      public ReadStream<Helloworld.HelloReply> sayRepeatHello(Helloworld.RepeatHelloRequest request) {
        Flowable<Helloworld.HelloReply> flowable = Flowable.interval(1, SECONDS, RxHelper.scheduler(context))
                .onBackpressureDrop()
                .map(l -> Helloworld.HelloReply.newBuilder().setMessage("Hello " + request.getName()).build())
                .take(5)
                .doAfterNext(__ -> System.out.println("reply emmited"))
                .doAfterTerminate(() -> System.out.println("done"));
        return FlowableHelper.toReadStream(flowable);
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
