package io.vertx.grpcweb;

import io.grpc.*;
import io.grpc.Metadata.Key;

import java.util.Set;

import static io.grpc.Metadata.ASCII_STRING_MARSHALLER;
import static io.grpc.Metadata.BINARY_BYTE_MARSHALLER;

class MyServerInterceptor implements ServerInterceptor {
  private static final Key<String> HEADER_TEXT_KEY = Key.of("x-header-text-key", ASCII_STRING_MARSHALLER);
  private static final Key<byte[]> HEADER_BIN_KEY = Key.of("x-header-bin-key-bin", BINARY_BYTE_MARSHALLER);
  private static final Set<Key<?>> HEADERS_KEY_SET = Set.of(HEADER_TEXT_KEY, HEADER_BIN_KEY);
  private static final Key<String> TRAILER_TEXT_KEY = Key.of("x-trailer-text-key", ASCII_STRING_MARSHALLER);
  private static final Key<byte[]> TRAILER_BIN_KEY = Key.of("x-trailer-bin-key-bin", BINARY_BYTE_MARSHALLER);
  private static final Set<Key<?>> TRAILERS_KEY_SET = Set.of(TRAILER_TEXT_KEY, TRAILER_BIN_KEY);

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
