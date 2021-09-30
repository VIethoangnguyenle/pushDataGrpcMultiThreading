package com.hoang;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.39.0)",
    comments = "Source: example.proto")
public final class PushDataGrpc {

  private PushDataGrpc() {}

  public static final String SERVICE_NAME = "PushData";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.hoang.Example.IndexStudent,
      com.google.protobuf.Empty> getPushStudentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PushStudent",
      requestType = com.hoang.Example.IndexStudent.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<com.hoang.Example.IndexStudent,
      com.google.protobuf.Empty> getPushStudentMethod() {
    io.grpc.MethodDescriptor<com.hoang.Example.IndexStudent, com.google.protobuf.Empty> getPushStudentMethod;
    if ((getPushStudentMethod = PushDataGrpc.getPushStudentMethod) == null) {
      synchronized (PushDataGrpc.class) {
        if ((getPushStudentMethod = PushDataGrpc.getPushStudentMethod) == null) {
          PushDataGrpc.getPushStudentMethod = getPushStudentMethod =
              io.grpc.MethodDescriptor.<com.hoang.Example.IndexStudent, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "PushStudent"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.hoang.Example.IndexStudent.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new PushDataMethodDescriptorSupplier("PushStudent"))
              .build();
        }
      }
    }
    return getPushStudentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.hoang.Example.IndexAnimal,
      com.google.protobuf.Empty> getPushAnimalMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PushAnimal",
      requestType = com.hoang.Example.IndexAnimal.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<com.hoang.Example.IndexAnimal,
      com.google.protobuf.Empty> getPushAnimalMethod() {
    io.grpc.MethodDescriptor<com.hoang.Example.IndexAnimal, com.google.protobuf.Empty> getPushAnimalMethod;
    if ((getPushAnimalMethod = PushDataGrpc.getPushAnimalMethod) == null) {
      synchronized (PushDataGrpc.class) {
        if ((getPushAnimalMethod = PushDataGrpc.getPushAnimalMethod) == null) {
          PushDataGrpc.getPushAnimalMethod = getPushAnimalMethod =
              io.grpc.MethodDescriptor.<com.hoang.Example.IndexAnimal, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "PushAnimal"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.hoang.Example.IndexAnimal.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new PushDataMethodDescriptorSupplier("PushAnimal"))
              .build();
        }
      }
    }
    return getPushAnimalMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PushDataStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PushDataStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PushDataStub>() {
        @java.lang.Override
        public PushDataStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PushDataStub(channel, callOptions);
        }
      };
    return PushDataStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PushDataBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PushDataBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PushDataBlockingStub>() {
        @java.lang.Override
        public PushDataBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PushDataBlockingStub(channel, callOptions);
        }
      };
    return PushDataBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PushDataFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PushDataFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PushDataFutureStub>() {
        @java.lang.Override
        public PushDataFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PushDataFutureStub(channel, callOptions);
        }
      };
    return PushDataFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class PushDataImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<com.hoang.Example.IndexStudent> pushStudent(
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getPushStudentMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.hoang.Example.IndexAnimal> pushAnimal(
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getPushAnimalMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getPushStudentMethod(),
            io.grpc.stub.ServerCalls.asyncClientStreamingCall(
              new MethodHandlers<
                com.hoang.Example.IndexStudent,
                com.google.protobuf.Empty>(
                  this, METHODID_PUSH_STUDENT)))
          .addMethod(
            getPushAnimalMethod(),
            io.grpc.stub.ServerCalls.asyncClientStreamingCall(
              new MethodHandlers<
                com.hoang.Example.IndexAnimal,
                com.google.protobuf.Empty>(
                  this, METHODID_PUSH_ANIMAL)))
          .build();
    }
  }

  /**
   */
  public static final class PushDataStub extends io.grpc.stub.AbstractAsyncStub<PushDataStub> {
    private PushDataStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PushDataStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PushDataStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.hoang.Example.IndexStudent> pushStudent(
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncClientStreamingCall(
          getChannel().newCall(getPushStudentMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.hoang.Example.IndexAnimal> pushAnimal(
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncClientStreamingCall(
          getChannel().newCall(getPushAnimalMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class PushDataBlockingStub extends io.grpc.stub.AbstractBlockingStub<PushDataBlockingStub> {
    private PushDataBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PushDataBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PushDataBlockingStub(channel, callOptions);
    }
  }

  /**
   */
  public static final class PushDataFutureStub extends io.grpc.stub.AbstractFutureStub<PushDataFutureStub> {
    private PushDataFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PushDataFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PushDataFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_PUSH_STUDENT = 0;
  private static final int METHODID_PUSH_ANIMAL = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final PushDataImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(PushDataImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_PUSH_STUDENT:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.pushStudent(
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
        case METHODID_PUSH_ANIMAL:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.pushAnimal(
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class PushDataBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PushDataBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.hoang.Example.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("PushData");
    }
  }

  private static final class PushDataFileDescriptorSupplier
      extends PushDataBaseDescriptorSupplier {
    PushDataFileDescriptorSupplier() {}
  }

  private static final class PushDataMethodDescriptorSupplier
      extends PushDataBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    PushDataMethodDescriptorSupplier(String methodName) {
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
      synchronized (PushDataGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PushDataFileDescriptorSupplier())
              .addMethod(getPushStudentMethod())
              .addMethod(getPushAnimalMethod())
              .build();
        }
      }
    }
    return result;
  }
}
