package io.vertx.grpcweb;

import io.grpc.stub.StreamObserver;
import io.reactivex.rxjava3.core.Flowable;
import io.vertx.core.Context;
import io.vertx.rxjava3.RxHelper;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

class TestServiceImpl extends TestServiceGrpc.TestServiceImplBase {

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
    GrpcWebTesting.EchoResponse response = GrpcWebTesting.EchoResponse.newBuilder()
      .setPayload(request.getPayload())
      .build();
    responseObserver.onNext(response);
    responseObserver.onCompleted();
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
