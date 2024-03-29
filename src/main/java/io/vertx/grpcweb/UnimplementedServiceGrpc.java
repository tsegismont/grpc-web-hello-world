package io.vertx.grpcweb;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.50.2)",
    comments = "Source: grpc-web-testing.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class UnimplementedServiceGrpc {

  private UnimplementedServiceGrpc() {}

  public static final String SERVICE_NAME = "io.vertx.grpcweb.UnimplementedService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<io.vertx.grpcweb.GrpcWebTesting.Empty,
      io.vertx.grpcweb.GrpcWebTesting.Empty> getUnimplementedCallMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UnimplementedCall",
      requestType = io.vertx.grpcweb.GrpcWebTesting.Empty.class,
      responseType = io.vertx.grpcweb.GrpcWebTesting.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.vertx.grpcweb.GrpcWebTesting.Empty,
      io.vertx.grpcweb.GrpcWebTesting.Empty> getUnimplementedCallMethod() {
    io.grpc.MethodDescriptor<io.vertx.grpcweb.GrpcWebTesting.Empty, io.vertx.grpcweb.GrpcWebTesting.Empty> getUnimplementedCallMethod;
    if ((getUnimplementedCallMethod = UnimplementedServiceGrpc.getUnimplementedCallMethod) == null) {
      synchronized (UnimplementedServiceGrpc.class) {
        if ((getUnimplementedCallMethod = UnimplementedServiceGrpc.getUnimplementedCallMethod) == null) {
          UnimplementedServiceGrpc.getUnimplementedCallMethod = getUnimplementedCallMethod =
              io.grpc.MethodDescriptor.<io.vertx.grpcweb.GrpcWebTesting.Empty, io.vertx.grpcweb.GrpcWebTesting.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UnimplementedCall"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.vertx.grpcweb.GrpcWebTesting.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.vertx.grpcweb.GrpcWebTesting.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new UnimplementedServiceMethodDescriptorSupplier("UnimplementedCall"))
              .build();
        }
      }
    }
    return getUnimplementedCallMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static UnimplementedServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UnimplementedServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UnimplementedServiceStub>() {
        @java.lang.Override
        public UnimplementedServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UnimplementedServiceStub(channel, callOptions);
        }
      };
    return UnimplementedServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static UnimplementedServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UnimplementedServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UnimplementedServiceBlockingStub>() {
        @java.lang.Override
        public UnimplementedServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UnimplementedServiceBlockingStub(channel, callOptions);
        }
      };
    return UnimplementedServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static UnimplementedServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UnimplementedServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UnimplementedServiceFutureStub>() {
        @java.lang.Override
        public UnimplementedServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UnimplementedServiceFutureStub(channel, callOptions);
        }
      };
    return UnimplementedServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class UnimplementedServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Do not implement
     * </pre>
     */
    public void unimplementedCall(io.vertx.grpcweb.GrpcWebTesting.Empty request,
        io.grpc.stub.StreamObserver<io.vertx.grpcweb.GrpcWebTesting.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUnimplementedCallMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getUnimplementedCallMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                io.vertx.grpcweb.GrpcWebTesting.Empty,
                io.vertx.grpcweb.GrpcWebTesting.Empty>(
                  this, METHODID_UNIMPLEMENTED_CALL)))
          .build();
    }
  }

  /**
   */
  public static final class UnimplementedServiceStub extends io.grpc.stub.AbstractAsyncStub<UnimplementedServiceStub> {
    private UnimplementedServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UnimplementedServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UnimplementedServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Do not implement
     * </pre>
     */
    public void unimplementedCall(io.vertx.grpcweb.GrpcWebTesting.Empty request,
        io.grpc.stub.StreamObserver<io.vertx.grpcweb.GrpcWebTesting.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUnimplementedCallMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class UnimplementedServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<UnimplementedServiceBlockingStub> {
    private UnimplementedServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UnimplementedServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UnimplementedServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Do not implement
     * </pre>
     */
    public io.vertx.grpcweb.GrpcWebTesting.Empty unimplementedCall(io.vertx.grpcweb.GrpcWebTesting.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUnimplementedCallMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class UnimplementedServiceFutureStub extends io.grpc.stub.AbstractFutureStub<UnimplementedServiceFutureStub> {
    private UnimplementedServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UnimplementedServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UnimplementedServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Do not implement
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<io.vertx.grpcweb.GrpcWebTesting.Empty> unimplementedCall(
        io.vertx.grpcweb.GrpcWebTesting.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUnimplementedCallMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_UNIMPLEMENTED_CALL = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final UnimplementedServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(UnimplementedServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_UNIMPLEMENTED_CALL:
          serviceImpl.unimplementedCall((io.vertx.grpcweb.GrpcWebTesting.Empty) request,
              (io.grpc.stub.StreamObserver<io.vertx.grpcweb.GrpcWebTesting.Empty>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class UnimplementedServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    UnimplementedServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return io.vertx.grpcweb.GrpcWebTesting.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("UnimplementedService");
    }
  }

  private static final class UnimplementedServiceFileDescriptorSupplier
      extends UnimplementedServiceBaseDescriptorSupplier {
    UnimplementedServiceFileDescriptorSupplier() {}
  }

  private static final class UnimplementedServiceMethodDescriptorSupplier
      extends UnimplementedServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    UnimplementedServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (UnimplementedServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new UnimplementedServiceFileDescriptorSupplier())
              .addMethod(getUnimplementedCallMethod())
              .build();
        }
      }
    }
    return result;
  }
}
