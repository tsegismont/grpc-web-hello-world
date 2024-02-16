package io.vertx.grpcweb;

import io.grpc.Metadata;
import io.grpc.Metadata.Key;
import io.grpc.Status;
import io.grpc.StatusException;
import io.grpc.stub.StreamObserver;
import io.reactivex.rxjava3.core.Flowable;
import io.vertx.core.Context;
import io.vertx.rxjava3.RxHelper;

import static io.grpc.Metadata.ASCII_STRING_MARSHALLER;
import static java.util.concurrent.TimeUnit.MILLISECONDS;

class TestServiceImpl extends TestServiceGrpc.TestServiceImplBase {

  private static final Key<String> TRAILER_ERROR_KEY = Key.of("x-error-trailer", ASCII_STRING_MARSHALLER);

  private final Context context;

  TestServiceImpl(Context context) {
    this.context = context;
  }

  @Override
  public void emptyCall(GrpcWebTesting.Empty request, StreamObserver<GrpcWebTesting.Empty> responseObserver) {
    responseObserver.onNext(GrpcWebTesting.Empty.newBuilder().build());
    responseObserver.onCompleted();
  }

  @Override
  public void unaryCall(GrpcWebTesting.EchoRequest request, StreamObserver<GrpcWebTesting.EchoResponse> responseObserver) {
    String payload = request.getPayload();
    if ("boom".equals(payload)) {
      Metadata metadata = new Metadata();
      metadata.put(TRAILER_ERROR_KEY, "boom");
      responseObserver.onError(new StatusException(Status.INTERNAL, metadata));
    } else {
      GrpcWebTesting.EchoResponse response = GrpcWebTesting.EchoResponse.newBuilder()
        .setPayload(payload)
        .build();
      responseObserver.onNext(response);
      responseObserver.onCompleted();
    }
  }

  @Override
  public void streamingCall(GrpcWebTesting.StreamingRequest request, StreamObserver<GrpcWebTesting.StreamingResponse> responseObserver) {
    Flowable.fromIterable(request.getResponseSizeList())
      .zipWith(Flowable.interval(1, MILLISECONDS, RxHelper.scheduler(context)), (responseSize, interval) -> {
        return GrpcWebTesting.StreamingResponse.newBuilder().setPayload("a".repeat(responseSize)).build();
      })
      .subscribe(responseObserver::onNext, responseObserver::onError, responseObserver::onCompleted);
  }
}
