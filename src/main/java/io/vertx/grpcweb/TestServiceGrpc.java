package io.vertx.grpcweb;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.50.2)",
    comments = "Source: grpc-web-testing.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class TestServiceGrpc {

  private TestServiceGrpc() {}

  public static final String SERVICE_NAME = "io.vertx.grpcweb.TestService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<io.vertx.grpcweb.GrpcWebTesting.Empty,
      io.vertx.grpcweb.GrpcWebTesting.Empty> getEmptyCallMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "EmptyCall",
      requestType = io.vertx.grpcweb.GrpcWebTesting.Empty.class,
      responseType = io.vertx.grpcweb.GrpcWebTesting.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.vertx.grpcweb.GrpcWebTesting.Empty,
      io.vertx.grpcweb.GrpcWebTesting.Empty> getEmptyCallMethod() {
    io.grpc.MethodDescriptor<io.vertx.grpcweb.GrpcWebTesting.Empty, io.vertx.grpcweb.GrpcWebTesting.Empty> getEmptyCallMethod;
    if ((getEmptyCallMethod = TestServiceGrpc.getEmptyCallMethod) == null) {
      synchronized (TestServiceGrpc.class) {
        if ((getEmptyCallMethod = TestServiceGrpc.getEmptyCallMethod) == null) {
          TestServiceGrpc.getEmptyCallMethod = getEmptyCallMethod =
              io.grpc.MethodDescriptor.<io.vertx.grpcweb.GrpcWebTesting.Empty, io.vertx.grpcweb.GrpcWebTesting.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "EmptyCall"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.vertx.grpcweb.GrpcWebTesting.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.vertx.grpcweb.GrpcWebTesting.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new TestServiceMethodDescriptorSupplier("EmptyCall"))
              .build();
        }
      }
    }
    return getEmptyCallMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.vertx.grpcweb.GrpcWebTesting.EchoRequest,
      io.vertx.grpcweb.GrpcWebTesting.EchoResponse> getUnaryCallMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UnaryCall",
      requestType = io.vertx.grpcweb.GrpcWebTesting.EchoRequest.class,
      responseType = io.vertx.grpcweb.GrpcWebTesting.EchoResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.vertx.grpcweb.GrpcWebTesting.EchoRequest,
      io.vertx.grpcweb.GrpcWebTesting.EchoResponse> getUnaryCallMethod() {
    io.grpc.MethodDescriptor<io.vertx.grpcweb.GrpcWebTesting.EchoRequest, io.vertx.grpcweb.GrpcWebTesting.EchoResponse> getUnaryCallMethod;
    if ((getUnaryCallMethod = TestServiceGrpc.getUnaryCallMethod) == null) {
      synchronized (TestServiceGrpc.class) {
        if ((getUnaryCallMethod = TestServiceGrpc.getUnaryCallMethod) == null) {
          TestServiceGrpc.getUnaryCallMethod = getUnaryCallMethod =
              io.grpc.MethodDescriptor.<io.vertx.grpcweb.GrpcWebTesting.EchoRequest, io.vertx.grpcweb.GrpcWebTesting.EchoResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UnaryCall"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.vertx.grpcweb.GrpcWebTesting.EchoRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.vertx.grpcweb.GrpcWebTesting.EchoResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TestServiceMethodDescriptorSupplier("UnaryCall"))
              .build();
        }
      }
    }
    return getUnaryCallMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.vertx.grpcweb.GrpcWebTesting.StreamingRequest,
      io.vertx.grpcweb.GrpcWebTesting.StreamingResponse> getStreamingCallMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StreamingCall",
      requestType = io.vertx.grpcweb.GrpcWebTesting.StreamingRequest.class,
      responseType = io.vertx.grpcweb.GrpcWebTesting.StreamingResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<io.vertx.grpcweb.GrpcWebTesting.StreamingRequest,
      io.vertx.grpcweb.GrpcWebTesting.StreamingResponse> getStreamingCallMethod() {
    io.grpc.MethodDescriptor<io.vertx.grpcweb.GrpcWebTesting.StreamingRequest, io.vertx.grpcweb.GrpcWebTesting.StreamingResponse> getStreamingCallMethod;
    if ((getStreamingCallMethod = TestServiceGrpc.getStreamingCallMethod) == null) {
      synchronized (TestServiceGrpc.class) {
        if ((getStreamingCallMethod = TestServiceGrpc.getStreamingCallMethod) == null) {
          TestServiceGrpc.getStreamingCallMethod = getStreamingCallMethod =
              io.grpc.MethodDescriptor.<io.vertx.grpcweb.GrpcWebTesting.StreamingRequest, io.vertx.grpcweb.GrpcWebTesting.StreamingResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StreamingCall"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.vertx.grpcweb.GrpcWebTesting.StreamingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.vertx.grpcweb.GrpcWebTesting.StreamingResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TestServiceMethodDescriptorSupplier("StreamingCall"))
              .build();
        }
      }
    }
    return getStreamingCallMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TestServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TestServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TestServiceStub>() {
        @java.lang.Override
        public TestServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TestServiceStub(channel, callOptions);
        }
      };
    return TestServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TestServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TestServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TestServiceBlockingStub>() {
        @java.lang.Override
        public TestServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TestServiceBlockingStub(channel, callOptions);
        }
      };
    return TestServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TestServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TestServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TestServiceFutureStub>() {
        @java.lang.Override
        public TestServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TestServiceFutureStub(channel, callOptions);
        }
      };
    return TestServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class TestServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void emptyCall(io.vertx.grpcweb.GrpcWebTesting.Empty request,
        io.grpc.stub.StreamObserver<io.vertx.grpcweb.GrpcWebTesting.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getEmptyCallMethod(), responseObserver);
    }

    /**
     */
    public void unaryCall(io.vertx.grpcweb.GrpcWebTesting.EchoRequest request,
        io.grpc.stub.StreamObserver<io.vertx.grpcweb.GrpcWebTesting.EchoResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUnaryCallMethod(), responseObserver);
    }

    /**
     */
    public void streamingCall(io.vertx.grpcweb.GrpcWebTesting.StreamingRequest request,
        io.grpc.stub.StreamObserver<io.vertx.grpcweb.GrpcWebTesting.StreamingResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStreamingCallMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getEmptyCallMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                io.vertx.grpcweb.GrpcWebTesting.Empty,
                io.vertx.grpcweb.GrpcWebTesting.Empty>(
                  this, METHODID_EMPTY_CALL)))
          .addMethod(
            getUnaryCallMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                io.vertx.grpcweb.GrpcWebTesting.EchoRequest,
                io.vertx.grpcweb.GrpcWebTesting.EchoResponse>(
                  this, METHODID_UNARY_CALL)))
          .addMethod(
            getStreamingCallMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                io.vertx.grpcweb.GrpcWebTesting.StreamingRequest,
                io.vertx.grpcweb.GrpcWebTesting.StreamingResponse>(
                  this, METHODID_STREAMING_CALL)))
          .build();
    }
  }

  /**
   */
  public static final class TestServiceStub extends io.grpc.stub.AbstractAsyncStub<TestServiceStub> {
    private TestServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TestServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TestServiceStub(channel, callOptions);
    }

    /**
     */
    public void emptyCall(io.vertx.grpcweb.GrpcWebTesting.Empty request,
        io.grpc.stub.StreamObserver<io.vertx.grpcweb.GrpcWebTesting.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getEmptyCallMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void unaryCall(io.vertx.grpcweb.GrpcWebTesting.EchoRequest request,
        io.grpc.stub.StreamObserver<io.vertx.grpcweb.GrpcWebTesting.EchoResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUnaryCallMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void streamingCall(io.vertx.grpcweb.GrpcWebTesting.StreamingRequest request,
        io.grpc.stub.StreamObserver<io.vertx.grpcweb.GrpcWebTesting.StreamingResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getStreamingCallMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class TestServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<TestServiceBlockingStub> {
    private TestServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TestServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TestServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public io.vertx.grpcweb.GrpcWebTesting.Empty emptyCall(io.vertx.grpcweb.GrpcWebTesting.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getEmptyCallMethod(), getCallOptions(), request);
    }

    /**
     */
    public io.vertx.grpcweb.GrpcWebTesting.EchoResponse unaryCall(io.vertx.grpcweb.GrpcWebTesting.EchoRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUnaryCallMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<io.vertx.grpcweb.GrpcWebTesting.StreamingResponse> streamingCall(
        io.vertx.grpcweb.GrpcWebTesting.StreamingRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getStreamingCallMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class TestServiceFutureStub extends io.grpc.stub.AbstractFutureStub<TestServiceFutureStub> {
    private TestServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TestServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TestServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.vertx.grpcweb.GrpcWebTesting.Empty> emptyCall(
        io.vertx.grpcweb.GrpcWebTesting.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getEmptyCallMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.vertx.grpcweb.GrpcWebTesting.EchoResponse> unaryCall(
        io.vertx.grpcweb.GrpcWebTesting.EchoRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUnaryCallMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_EMPTY_CALL = 0;
  private static final int METHODID_UNARY_CALL = 1;
  private static final int METHODID_STREAMING_CALL = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TestServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TestServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_EMPTY_CALL:
          serviceImpl.emptyCall((io.vertx.grpcweb.GrpcWebTesting.Empty) request,
              (io.grpc.stub.StreamObserver<io.vertx.grpcweb.GrpcWebTesting.Empty>) responseObserver);
          break;
        case METHODID_UNARY_CALL:
          serviceImpl.unaryCall((io.vertx.grpcweb.GrpcWebTesting.EchoRequest) request,
              (io.grpc.stub.StreamObserver<io.vertx.grpcweb.GrpcWebTesting.EchoResponse>) responseObserver);
          break;
        case METHODID_STREAMING_CALL:
          serviceImpl.streamingCall((io.vertx.grpcweb.GrpcWebTesting.StreamingRequest) request,
              (io.grpc.stub.StreamObserver<io.vertx.grpcweb.GrpcWebTesting.StreamingResponse>) responseObserver);
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

  private static abstract class TestServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TestServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return io.vertx.grpcweb.GrpcWebTesting.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TestService");
    }
  }

  private static final class TestServiceFileDescriptorSupplier
      extends TestServiceBaseDescriptorSupplier {
    TestServiceFileDescriptorSupplier() {}
  }

  private static final class TestServiceMethodDescriptorSupplier
      extends TestServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TestServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (TestServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TestServiceFileDescriptorSupplier())
              .addMethod(getEmptyCallMethod())
              .addMethod(getUnaryCallMethod())
              .addMethod(getStreamingCallMethod())
              .build();
        }
      }
    }
    return result;
  }
}
