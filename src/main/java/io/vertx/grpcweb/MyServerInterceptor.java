package io.vertx.grpcweb;

import io.grpc.*;
import io.grpc.Metadata.Key;

import java.util.Set;

class MyServerInterceptor implements ServerInterceptor {
  private static final Set<Key<?>> HEADERS_KEY_SET = Set.of(Key.of("x-grpc-test-echo-initial", Metadata.ASCII_STRING_MARSHALLER));
  private static final Set<Key<?>> TRAILERS_KEY_SET = Set.of(Key.of("x-grpc-test-echo-trailing-bin", Metadata.BINARY_BYTE_MARSHALLER));

  @Override
  public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> call, Metadata metadata, ServerCallHandler<ReqT, RespT> next) {
    return next.startCall(new ForwardingServerCall.SimpleForwardingServerCall<>(call) {

      @Override
      public void sendHeaders(Metadata headers) {
        headers.merge(metadata, HEADERS_KEY_SET);
        super.sendHeaders(headers);
      }

      @Override
      public void close(Status status, Metadata trailers) {
        trailers.merge(metadata, TRAILERS_KEY_SET);
        super.close(status, trailers);
      }
    }, metadata);
  }
}
