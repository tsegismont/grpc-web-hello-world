package helloworld;

import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.net.SocketAddress;
import io.vertx.grpc.client.GrpcClient;
import io.vertx.core.streams.ReadStream;
import io.vertx.core.streams.WriteStream;
import io.vertx.grpc.common.GrpcStatus;

public class VertxGreeterGrpcClient {
  private final GrpcClient client;
  private final SocketAddress socketAddress;

  public VertxGreeterGrpcClient(GrpcClient client, SocketAddress socketAddress) {
    this.client = client;
    this.socketAddress = socketAddress;
  }

  public Future<helloworld.Helloworld.HelloReply> sayHello(helloworld.Helloworld.HelloRequest request) {
    return client.request(socketAddress, GreeterGrpc.getSayHelloMethod()).compose(req -> {
      req.end(request);
      return req.response().compose(resp -> resp.last());
    });
  }

}
