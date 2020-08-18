package com.elarian.hera.proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: web.proto")
public final class GrpcWebServiceGrpc {

  private GrpcWebServiceGrpc() {}

  public static final String SERVICE_NAME = "com.elarian.hera.proto.GrpcWebService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.elarian.hera.proto.Web.AuthTokenRequest,
      com.elarian.hera.proto.Web.AuthTokenReply> getAuthTokenMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AuthToken",
      requestType = com.elarian.hera.proto.Web.AuthTokenRequest.class,
      responseType = com.elarian.hera.proto.Web.AuthTokenReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.elarian.hera.proto.Web.AuthTokenRequest,
      com.elarian.hera.proto.Web.AuthTokenReply> getAuthTokenMethod() {
    io.grpc.MethodDescriptor<com.elarian.hera.proto.Web.AuthTokenRequest, com.elarian.hera.proto.Web.AuthTokenReply> getAuthTokenMethod;
    if ((getAuthTokenMethod = GrpcWebServiceGrpc.getAuthTokenMethod) == null) {
      synchronized (GrpcWebServiceGrpc.class) {
        if ((getAuthTokenMethod = GrpcWebServiceGrpc.getAuthTokenMethod) == null) {
          GrpcWebServiceGrpc.getAuthTokenMethod = getAuthTokenMethod =
              io.grpc.MethodDescriptor.<com.elarian.hera.proto.Web.AuthTokenRequest, com.elarian.hera.proto.Web.AuthTokenReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AuthToken"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  com.elarian.hera.proto.Web.AuthTokenRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  com.elarian.hera.proto.Web.AuthTokenReply.getDefaultInstance()))
              .build();
        }
      }
    }
    return getAuthTokenMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.elarian.hera.proto.Web.GetCustomerStateRequest,
      com.elarian.hera.proto.Web.GetCustomerStateReply> getGetCustomerStateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCustomerState",
      requestType = com.elarian.hera.proto.Web.GetCustomerStateRequest.class,
      responseType = com.elarian.hera.proto.Web.GetCustomerStateReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.elarian.hera.proto.Web.GetCustomerStateRequest,
      com.elarian.hera.proto.Web.GetCustomerStateReply> getGetCustomerStateMethod() {
    io.grpc.MethodDescriptor<com.elarian.hera.proto.Web.GetCustomerStateRequest, com.elarian.hera.proto.Web.GetCustomerStateReply> getGetCustomerStateMethod;
    if ((getGetCustomerStateMethod = GrpcWebServiceGrpc.getGetCustomerStateMethod) == null) {
      synchronized (GrpcWebServiceGrpc.class) {
        if ((getGetCustomerStateMethod = GrpcWebServiceGrpc.getGetCustomerStateMethod) == null) {
          GrpcWebServiceGrpc.getGetCustomerStateMethod = getGetCustomerStateMethod =
              io.grpc.MethodDescriptor.<com.elarian.hera.proto.Web.GetCustomerStateRequest, com.elarian.hera.proto.Web.GetCustomerStateReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetCustomerState"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  com.elarian.hera.proto.Web.GetCustomerStateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  com.elarian.hera.proto.Web.GetCustomerStateReply.getDefaultInstance()))
              .build();
        }
      }
    }
    return getGetCustomerStateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.elarian.hera.proto.Web.AdoptCustomerStateRequest,
      com.elarian.hera.proto.Web.UpdateCustomerStateReply> getAdoptCustomerStateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AdoptCustomerState",
      requestType = com.elarian.hera.proto.Web.AdoptCustomerStateRequest.class,
      responseType = com.elarian.hera.proto.Web.UpdateCustomerStateReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.elarian.hera.proto.Web.AdoptCustomerStateRequest,
      com.elarian.hera.proto.Web.UpdateCustomerStateReply> getAdoptCustomerStateMethod() {
    io.grpc.MethodDescriptor<com.elarian.hera.proto.Web.AdoptCustomerStateRequest, com.elarian.hera.proto.Web.UpdateCustomerStateReply> getAdoptCustomerStateMethod;
    if ((getAdoptCustomerStateMethod = GrpcWebServiceGrpc.getAdoptCustomerStateMethod) == null) {
      synchronized (GrpcWebServiceGrpc.class) {
        if ((getAdoptCustomerStateMethod = GrpcWebServiceGrpc.getAdoptCustomerStateMethod) == null) {
          GrpcWebServiceGrpc.getAdoptCustomerStateMethod = getAdoptCustomerStateMethod =
              io.grpc.MethodDescriptor.<com.elarian.hera.proto.Web.AdoptCustomerStateRequest, com.elarian.hera.proto.Web.UpdateCustomerStateReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AdoptCustomerState"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  com.elarian.hera.proto.Web.AdoptCustomerStateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  com.elarian.hera.proto.Web.UpdateCustomerStateReply.getDefaultInstance()))
              .build();
        }
      }
    }
    return getAdoptCustomerStateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.elarian.hera.proto.Web.AddCustomerReminderRequest,
      com.elarian.hera.proto.Web.UpdateCustomerStateReply> getAddCustomerReminderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddCustomerReminder",
      requestType = com.elarian.hera.proto.Web.AddCustomerReminderRequest.class,
      responseType = com.elarian.hera.proto.Web.UpdateCustomerStateReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.elarian.hera.proto.Web.AddCustomerReminderRequest,
      com.elarian.hera.proto.Web.UpdateCustomerStateReply> getAddCustomerReminderMethod() {
    io.grpc.MethodDescriptor<com.elarian.hera.proto.Web.AddCustomerReminderRequest, com.elarian.hera.proto.Web.UpdateCustomerStateReply> getAddCustomerReminderMethod;
    if ((getAddCustomerReminderMethod = GrpcWebServiceGrpc.getAddCustomerReminderMethod) == null) {
      synchronized (GrpcWebServiceGrpc.class) {
        if ((getAddCustomerReminderMethod = GrpcWebServiceGrpc.getAddCustomerReminderMethod) == null) {
          GrpcWebServiceGrpc.getAddCustomerReminderMethod = getAddCustomerReminderMethod =
              io.grpc.MethodDescriptor.<com.elarian.hera.proto.Web.AddCustomerReminderRequest, com.elarian.hera.proto.Web.UpdateCustomerStateReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AddCustomerReminder"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  com.elarian.hera.proto.Web.AddCustomerReminderRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  com.elarian.hera.proto.Web.UpdateCustomerStateReply.getDefaultInstance()))
              .build();
        }
      }
    }
    return getAddCustomerReminderMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.elarian.hera.proto.Web.AddCustomerReminderTagRequest,
      com.elarian.hera.proto.Web.TagCommandReply> getAddCustomerReminderByTagMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddCustomerReminderByTag",
      requestType = com.elarian.hera.proto.Web.AddCustomerReminderTagRequest.class,
      responseType = com.elarian.hera.proto.Web.TagCommandReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.elarian.hera.proto.Web.AddCustomerReminderTagRequest,
      com.elarian.hera.proto.Web.TagCommandReply> getAddCustomerReminderByTagMethod() {
    io.grpc.MethodDescriptor<com.elarian.hera.proto.Web.AddCustomerReminderTagRequest, com.elarian.hera.proto.Web.TagCommandReply> getAddCustomerReminderByTagMethod;
    if ((getAddCustomerReminderByTagMethod = GrpcWebServiceGrpc.getAddCustomerReminderByTagMethod) == null) {
      synchronized (GrpcWebServiceGrpc.class) {
        if ((getAddCustomerReminderByTagMethod = GrpcWebServiceGrpc.getAddCustomerReminderByTagMethod) == null) {
          GrpcWebServiceGrpc.getAddCustomerReminderByTagMethod = getAddCustomerReminderByTagMethod =
              io.grpc.MethodDescriptor.<com.elarian.hera.proto.Web.AddCustomerReminderTagRequest, com.elarian.hera.proto.Web.TagCommandReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AddCustomerReminderByTag"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  com.elarian.hera.proto.Web.AddCustomerReminderTagRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  com.elarian.hera.proto.Web.TagCommandReply.getDefaultInstance()))
              .build();
        }
      }
    }
    return getAddCustomerReminderByTagMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.elarian.hera.proto.Web.CancelCustomerReminderRequest,
      com.elarian.hera.proto.Web.UpdateCustomerStateReply> getCancelCustomerReminderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CancelCustomerReminder",
      requestType = com.elarian.hera.proto.Web.CancelCustomerReminderRequest.class,
      responseType = com.elarian.hera.proto.Web.UpdateCustomerStateReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.elarian.hera.proto.Web.CancelCustomerReminderRequest,
      com.elarian.hera.proto.Web.UpdateCustomerStateReply> getCancelCustomerReminderMethod() {
    io.grpc.MethodDescriptor<com.elarian.hera.proto.Web.CancelCustomerReminderRequest, com.elarian.hera.proto.Web.UpdateCustomerStateReply> getCancelCustomerReminderMethod;
    if ((getCancelCustomerReminderMethod = GrpcWebServiceGrpc.getCancelCustomerReminderMethod) == null) {
      synchronized (GrpcWebServiceGrpc.class) {
        if ((getCancelCustomerReminderMethod = GrpcWebServiceGrpc.getCancelCustomerReminderMethod) == null) {
          GrpcWebServiceGrpc.getCancelCustomerReminderMethod = getCancelCustomerReminderMethod =
              io.grpc.MethodDescriptor.<com.elarian.hera.proto.Web.CancelCustomerReminderRequest, com.elarian.hera.proto.Web.UpdateCustomerStateReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CancelCustomerReminder"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  com.elarian.hera.proto.Web.CancelCustomerReminderRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  com.elarian.hera.proto.Web.UpdateCustomerStateReply.getDefaultInstance()))
              .build();
        }
      }
    }
    return getCancelCustomerReminderMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.elarian.hera.proto.Web.CancelCustomerReminderTagRequest,
      com.elarian.hera.proto.Web.TagCommandReply> getCancelCustomerReminderByTagMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CancelCustomerReminderByTag",
      requestType = com.elarian.hera.proto.Web.CancelCustomerReminderTagRequest.class,
      responseType = com.elarian.hera.proto.Web.TagCommandReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.elarian.hera.proto.Web.CancelCustomerReminderTagRequest,
      com.elarian.hera.proto.Web.TagCommandReply> getCancelCustomerReminderByTagMethod() {
    io.grpc.MethodDescriptor<com.elarian.hera.proto.Web.CancelCustomerReminderTagRequest, com.elarian.hera.proto.Web.TagCommandReply> getCancelCustomerReminderByTagMethod;
    if ((getCancelCustomerReminderByTagMethod = GrpcWebServiceGrpc.getCancelCustomerReminderByTagMethod) == null) {
      synchronized (GrpcWebServiceGrpc.class) {
        if ((getCancelCustomerReminderByTagMethod = GrpcWebServiceGrpc.getCancelCustomerReminderByTagMethod) == null) {
          GrpcWebServiceGrpc.getCancelCustomerReminderByTagMethod = getCancelCustomerReminderByTagMethod =
              io.grpc.MethodDescriptor.<com.elarian.hera.proto.Web.CancelCustomerReminderTagRequest, com.elarian.hera.proto.Web.TagCommandReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CancelCustomerReminderByTag"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  com.elarian.hera.proto.Web.CancelCustomerReminderTagRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  com.elarian.hera.proto.Web.TagCommandReply.getDefaultInstance()))
              .build();
        }
      }
    }
    return getCancelCustomerReminderByTagMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.elarian.hera.proto.Web.UpdateCustomerTagRequest,
      com.elarian.hera.proto.Web.UpdateCustomerStateReply> getUpdateCustomerTagMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateCustomerTag",
      requestType = com.elarian.hera.proto.Web.UpdateCustomerTagRequest.class,
      responseType = com.elarian.hera.proto.Web.UpdateCustomerStateReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.elarian.hera.proto.Web.UpdateCustomerTagRequest,
      com.elarian.hera.proto.Web.UpdateCustomerStateReply> getUpdateCustomerTagMethod() {
    io.grpc.MethodDescriptor<com.elarian.hera.proto.Web.UpdateCustomerTagRequest, com.elarian.hera.proto.Web.UpdateCustomerStateReply> getUpdateCustomerTagMethod;
    if ((getUpdateCustomerTagMethod = GrpcWebServiceGrpc.getUpdateCustomerTagMethod) == null) {
      synchronized (GrpcWebServiceGrpc.class) {
        if ((getUpdateCustomerTagMethod = GrpcWebServiceGrpc.getUpdateCustomerTagMethod) == null) {
          GrpcWebServiceGrpc.getUpdateCustomerTagMethod = getUpdateCustomerTagMethod =
              io.grpc.MethodDescriptor.<com.elarian.hera.proto.Web.UpdateCustomerTagRequest, com.elarian.hera.proto.Web.UpdateCustomerStateReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateCustomerTag"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  com.elarian.hera.proto.Web.UpdateCustomerTagRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  com.elarian.hera.proto.Web.UpdateCustomerStateReply.getDefaultInstance()))
              .build();
        }
      }
    }
    return getUpdateCustomerTagMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.elarian.hera.proto.Web.DeleteCustomerTagRequest,
      com.elarian.hera.proto.Web.UpdateCustomerStateReply> getDeleteCustomerTagMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteCustomerTag",
      requestType = com.elarian.hera.proto.Web.DeleteCustomerTagRequest.class,
      responseType = com.elarian.hera.proto.Web.UpdateCustomerStateReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.elarian.hera.proto.Web.DeleteCustomerTagRequest,
      com.elarian.hera.proto.Web.UpdateCustomerStateReply> getDeleteCustomerTagMethod() {
    io.grpc.MethodDescriptor<com.elarian.hera.proto.Web.DeleteCustomerTagRequest, com.elarian.hera.proto.Web.UpdateCustomerStateReply> getDeleteCustomerTagMethod;
    if ((getDeleteCustomerTagMethod = GrpcWebServiceGrpc.getDeleteCustomerTagMethod) == null) {
      synchronized (GrpcWebServiceGrpc.class) {
        if ((getDeleteCustomerTagMethod = GrpcWebServiceGrpc.getDeleteCustomerTagMethod) == null) {
          GrpcWebServiceGrpc.getDeleteCustomerTagMethod = getDeleteCustomerTagMethod =
              io.grpc.MethodDescriptor.<com.elarian.hera.proto.Web.DeleteCustomerTagRequest, com.elarian.hera.proto.Web.UpdateCustomerStateReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteCustomerTag"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  com.elarian.hera.proto.Web.DeleteCustomerTagRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  com.elarian.hera.proto.Web.UpdateCustomerStateReply.getDefaultInstance()))
              .build();
        }
      }
    }
    return getDeleteCustomerTagMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.elarian.hera.proto.Web.UpdateCustomerSecondaryIdRequest,
      com.elarian.hera.proto.Web.UpdateCustomerStateReply> getUpdateCustomerSecondaryIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateCustomerSecondaryId",
      requestType = com.elarian.hera.proto.Web.UpdateCustomerSecondaryIdRequest.class,
      responseType = com.elarian.hera.proto.Web.UpdateCustomerStateReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.elarian.hera.proto.Web.UpdateCustomerSecondaryIdRequest,
      com.elarian.hera.proto.Web.UpdateCustomerStateReply> getUpdateCustomerSecondaryIdMethod() {
    io.grpc.MethodDescriptor<com.elarian.hera.proto.Web.UpdateCustomerSecondaryIdRequest, com.elarian.hera.proto.Web.UpdateCustomerStateReply> getUpdateCustomerSecondaryIdMethod;
    if ((getUpdateCustomerSecondaryIdMethod = GrpcWebServiceGrpc.getUpdateCustomerSecondaryIdMethod) == null) {
      synchronized (GrpcWebServiceGrpc.class) {
        if ((getUpdateCustomerSecondaryIdMethod = GrpcWebServiceGrpc.getUpdateCustomerSecondaryIdMethod) == null) {
          GrpcWebServiceGrpc.getUpdateCustomerSecondaryIdMethod = getUpdateCustomerSecondaryIdMethod =
              io.grpc.MethodDescriptor.<com.elarian.hera.proto.Web.UpdateCustomerSecondaryIdRequest, com.elarian.hera.proto.Web.UpdateCustomerStateReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateCustomerSecondaryId"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  com.elarian.hera.proto.Web.UpdateCustomerSecondaryIdRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  com.elarian.hera.proto.Web.UpdateCustomerStateReply.getDefaultInstance()))
              .build();
        }
      }
    }
    return getUpdateCustomerSecondaryIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.elarian.hera.proto.Web.DeleteCustomerSecondaryIdRequest,
      com.elarian.hera.proto.Web.UpdateCustomerStateReply> getDeleteCustomerSecondaryIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteCustomerSecondaryId",
      requestType = com.elarian.hera.proto.Web.DeleteCustomerSecondaryIdRequest.class,
      responseType = com.elarian.hera.proto.Web.UpdateCustomerStateReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.elarian.hera.proto.Web.DeleteCustomerSecondaryIdRequest,
      com.elarian.hera.proto.Web.UpdateCustomerStateReply> getDeleteCustomerSecondaryIdMethod() {
    io.grpc.MethodDescriptor<com.elarian.hera.proto.Web.DeleteCustomerSecondaryIdRequest, com.elarian.hera.proto.Web.UpdateCustomerStateReply> getDeleteCustomerSecondaryIdMethod;
    if ((getDeleteCustomerSecondaryIdMethod = GrpcWebServiceGrpc.getDeleteCustomerSecondaryIdMethod) == null) {
      synchronized (GrpcWebServiceGrpc.class) {
        if ((getDeleteCustomerSecondaryIdMethod = GrpcWebServiceGrpc.getDeleteCustomerSecondaryIdMethod) == null) {
          GrpcWebServiceGrpc.getDeleteCustomerSecondaryIdMethod = getDeleteCustomerSecondaryIdMethod =
              io.grpc.MethodDescriptor.<com.elarian.hera.proto.Web.DeleteCustomerSecondaryIdRequest, com.elarian.hera.proto.Web.UpdateCustomerStateReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteCustomerSecondaryId"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  com.elarian.hera.proto.Web.DeleteCustomerSecondaryIdRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  com.elarian.hera.proto.Web.UpdateCustomerStateReply.getDefaultInstance()))
              .build();
        }
      }
    }
    return getDeleteCustomerSecondaryIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.elarian.hera.proto.Web.UpdateCustomerMetadataRequest,
      com.elarian.hera.proto.Web.UpdateCustomerStateReply> getUpdateCustomerMetadataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateCustomerMetadata",
      requestType = com.elarian.hera.proto.Web.UpdateCustomerMetadataRequest.class,
      responseType = com.elarian.hera.proto.Web.UpdateCustomerStateReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.elarian.hera.proto.Web.UpdateCustomerMetadataRequest,
      com.elarian.hera.proto.Web.UpdateCustomerStateReply> getUpdateCustomerMetadataMethod() {
    io.grpc.MethodDescriptor<com.elarian.hera.proto.Web.UpdateCustomerMetadataRequest, com.elarian.hera.proto.Web.UpdateCustomerStateReply> getUpdateCustomerMetadataMethod;
    if ((getUpdateCustomerMetadataMethod = GrpcWebServiceGrpc.getUpdateCustomerMetadataMethod) == null) {
      synchronized (GrpcWebServiceGrpc.class) {
        if ((getUpdateCustomerMetadataMethod = GrpcWebServiceGrpc.getUpdateCustomerMetadataMethod) == null) {
          GrpcWebServiceGrpc.getUpdateCustomerMetadataMethod = getUpdateCustomerMetadataMethod =
              io.grpc.MethodDescriptor.<com.elarian.hera.proto.Web.UpdateCustomerMetadataRequest, com.elarian.hera.proto.Web.UpdateCustomerStateReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateCustomerMetadata"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  com.elarian.hera.proto.Web.UpdateCustomerMetadataRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  com.elarian.hera.proto.Web.UpdateCustomerStateReply.getDefaultInstance()))
              .build();
        }
      }
    }
    return getUpdateCustomerMetadataMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.elarian.hera.proto.Web.DeleteCustomerMetadataRequest,
      com.elarian.hera.proto.Web.UpdateCustomerStateReply> getDeleteCustomerMetadataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteCustomerMetadata",
      requestType = com.elarian.hera.proto.Web.DeleteCustomerMetadataRequest.class,
      responseType = com.elarian.hera.proto.Web.UpdateCustomerStateReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.elarian.hera.proto.Web.DeleteCustomerMetadataRequest,
      com.elarian.hera.proto.Web.UpdateCustomerStateReply> getDeleteCustomerMetadataMethod() {
    io.grpc.MethodDescriptor<com.elarian.hera.proto.Web.DeleteCustomerMetadataRequest, com.elarian.hera.proto.Web.UpdateCustomerStateReply> getDeleteCustomerMetadataMethod;
    if ((getDeleteCustomerMetadataMethod = GrpcWebServiceGrpc.getDeleteCustomerMetadataMethod) == null) {
      synchronized (GrpcWebServiceGrpc.class) {
        if ((getDeleteCustomerMetadataMethod = GrpcWebServiceGrpc.getDeleteCustomerMetadataMethod) == null) {
          GrpcWebServiceGrpc.getDeleteCustomerMetadataMethod = getDeleteCustomerMetadataMethod =
              io.grpc.MethodDescriptor.<com.elarian.hera.proto.Web.DeleteCustomerMetadataRequest, com.elarian.hera.proto.Web.UpdateCustomerStateReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteCustomerMetadata"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  com.elarian.hera.proto.Web.DeleteCustomerMetadataRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  com.elarian.hera.proto.Web.UpdateCustomerStateReply.getDefaultInstance()))
              .build();
        }
      }
    }
    return getDeleteCustomerMetadataMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.elarian.hera.proto.Web.SendMessageRequest,
      com.elarian.hera.proto.Web.SendMessageReply> getSendMessageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SendMessage",
      requestType = com.elarian.hera.proto.Web.SendMessageRequest.class,
      responseType = com.elarian.hera.proto.Web.SendMessageReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.elarian.hera.proto.Web.SendMessageRequest,
      com.elarian.hera.proto.Web.SendMessageReply> getSendMessageMethod() {
    io.grpc.MethodDescriptor<com.elarian.hera.proto.Web.SendMessageRequest, com.elarian.hera.proto.Web.SendMessageReply> getSendMessageMethod;
    if ((getSendMessageMethod = GrpcWebServiceGrpc.getSendMessageMethod) == null) {
      synchronized (GrpcWebServiceGrpc.class) {
        if ((getSendMessageMethod = GrpcWebServiceGrpc.getSendMessageMethod) == null) {
          GrpcWebServiceGrpc.getSendMessageMethod = getSendMessageMethod =
              io.grpc.MethodDescriptor.<com.elarian.hera.proto.Web.SendMessageRequest, com.elarian.hera.proto.Web.SendMessageReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SendMessage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  com.elarian.hera.proto.Web.SendMessageRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  com.elarian.hera.proto.Web.SendMessageReply.getDefaultInstance()))
              .build();
        }
      }
    }
    return getSendMessageMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.elarian.hera.proto.Web.SendMessageTagRequest,
      com.elarian.hera.proto.Web.TagCommandReply> getSendMessageByTagMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SendMessageByTag",
      requestType = com.elarian.hera.proto.Web.SendMessageTagRequest.class,
      responseType = com.elarian.hera.proto.Web.TagCommandReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.elarian.hera.proto.Web.SendMessageTagRequest,
      com.elarian.hera.proto.Web.TagCommandReply> getSendMessageByTagMethod() {
    io.grpc.MethodDescriptor<com.elarian.hera.proto.Web.SendMessageTagRequest, com.elarian.hera.proto.Web.TagCommandReply> getSendMessageByTagMethod;
    if ((getSendMessageByTagMethod = GrpcWebServiceGrpc.getSendMessageByTagMethod) == null) {
      synchronized (GrpcWebServiceGrpc.class) {
        if ((getSendMessageByTagMethod = GrpcWebServiceGrpc.getSendMessageByTagMethod) == null) {
          GrpcWebServiceGrpc.getSendMessageByTagMethod = getSendMessageByTagMethod =
              io.grpc.MethodDescriptor.<com.elarian.hera.proto.Web.SendMessageTagRequest, com.elarian.hera.proto.Web.TagCommandReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SendMessageByTag"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  com.elarian.hera.proto.Web.SendMessageTagRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  com.elarian.hera.proto.Web.TagCommandReply.getDefaultInstance()))
              .build();
        }
      }
    }
    return getSendMessageByTagMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.elarian.hera.proto.Web.ReplyToMessageRequest,
      com.elarian.hera.proto.Web.SendMessageReply> getReplyToMessageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReplyToMessage",
      requestType = com.elarian.hera.proto.Web.ReplyToMessageRequest.class,
      responseType = com.elarian.hera.proto.Web.SendMessageReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.elarian.hera.proto.Web.ReplyToMessageRequest,
      com.elarian.hera.proto.Web.SendMessageReply> getReplyToMessageMethod() {
    io.grpc.MethodDescriptor<com.elarian.hera.proto.Web.ReplyToMessageRequest, com.elarian.hera.proto.Web.SendMessageReply> getReplyToMessageMethod;
    if ((getReplyToMessageMethod = GrpcWebServiceGrpc.getReplyToMessageMethod) == null) {
      synchronized (GrpcWebServiceGrpc.class) {
        if ((getReplyToMessageMethod = GrpcWebServiceGrpc.getReplyToMessageMethod) == null) {
          GrpcWebServiceGrpc.getReplyToMessageMethod = getReplyToMessageMethod =
              io.grpc.MethodDescriptor.<com.elarian.hera.proto.Web.ReplyToMessageRequest, com.elarian.hera.proto.Web.SendMessageReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ReplyToMessage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  com.elarian.hera.proto.Web.ReplyToMessageRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  com.elarian.hera.proto.Web.SendMessageReply.getDefaultInstance()))
              .build();
        }
      }
    }
    return getReplyToMessageMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.elarian.hera.proto.Web.MessagingConsentRequest,
      com.elarian.hera.proto.Web.MessagingConsentReply> getMessagingConsentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "MessagingConsent",
      requestType = com.elarian.hera.proto.Web.MessagingConsentRequest.class,
      responseType = com.elarian.hera.proto.Web.MessagingConsentReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.elarian.hera.proto.Web.MessagingConsentRequest,
      com.elarian.hera.proto.Web.MessagingConsentReply> getMessagingConsentMethod() {
    io.grpc.MethodDescriptor<com.elarian.hera.proto.Web.MessagingConsentRequest, com.elarian.hera.proto.Web.MessagingConsentReply> getMessagingConsentMethod;
    if ((getMessagingConsentMethod = GrpcWebServiceGrpc.getMessagingConsentMethod) == null) {
      synchronized (GrpcWebServiceGrpc.class) {
        if ((getMessagingConsentMethod = GrpcWebServiceGrpc.getMessagingConsentMethod) == null) {
          GrpcWebServiceGrpc.getMessagingConsentMethod = getMessagingConsentMethod =
              io.grpc.MethodDescriptor.<com.elarian.hera.proto.Web.MessagingConsentRequest, com.elarian.hera.proto.Web.MessagingConsentReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "MessagingConsent"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  com.elarian.hera.proto.Web.MessagingConsentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  com.elarian.hera.proto.Web.MessagingConsentReply.getDefaultInstance()))
              .build();
        }
      }
    }
    return getMessagingConsentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.elarian.hera.proto.Web.SendPaymentRequest,
      com.elarian.hera.proto.Web.SendPaymentReply> getSendPaymentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SendPayment",
      requestType = com.elarian.hera.proto.Web.SendPaymentRequest.class,
      responseType = com.elarian.hera.proto.Web.SendPaymentReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.elarian.hera.proto.Web.SendPaymentRequest,
      com.elarian.hera.proto.Web.SendPaymentReply> getSendPaymentMethod() {
    io.grpc.MethodDescriptor<com.elarian.hera.proto.Web.SendPaymentRequest, com.elarian.hera.proto.Web.SendPaymentReply> getSendPaymentMethod;
    if ((getSendPaymentMethod = GrpcWebServiceGrpc.getSendPaymentMethod) == null) {
      synchronized (GrpcWebServiceGrpc.class) {
        if ((getSendPaymentMethod = GrpcWebServiceGrpc.getSendPaymentMethod) == null) {
          GrpcWebServiceGrpc.getSendPaymentMethod = getSendPaymentMethod =
              io.grpc.MethodDescriptor.<com.elarian.hera.proto.Web.SendPaymentRequest, com.elarian.hera.proto.Web.SendPaymentReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SendPayment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  com.elarian.hera.proto.Web.SendPaymentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  com.elarian.hera.proto.Web.SendPaymentReply.getDefaultInstance()))
              .build();
        }
      }
    }
    return getSendPaymentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.elarian.hera.proto.Web.CheckoutPaymentRequest,
      com.elarian.hera.proto.Web.CheckoutPaymentReply> getCheckoutPaymentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CheckoutPayment",
      requestType = com.elarian.hera.proto.Web.CheckoutPaymentRequest.class,
      responseType = com.elarian.hera.proto.Web.CheckoutPaymentReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.elarian.hera.proto.Web.CheckoutPaymentRequest,
      com.elarian.hera.proto.Web.CheckoutPaymentReply> getCheckoutPaymentMethod() {
    io.grpc.MethodDescriptor<com.elarian.hera.proto.Web.CheckoutPaymentRequest, com.elarian.hera.proto.Web.CheckoutPaymentReply> getCheckoutPaymentMethod;
    if ((getCheckoutPaymentMethod = GrpcWebServiceGrpc.getCheckoutPaymentMethod) == null) {
      synchronized (GrpcWebServiceGrpc.class) {
        if ((getCheckoutPaymentMethod = GrpcWebServiceGrpc.getCheckoutPaymentMethod) == null) {
          GrpcWebServiceGrpc.getCheckoutPaymentMethod = getCheckoutPaymentMethod =
              io.grpc.MethodDescriptor.<com.elarian.hera.proto.Web.CheckoutPaymentRequest, com.elarian.hera.proto.Web.CheckoutPaymentReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CheckoutPayment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  com.elarian.hera.proto.Web.CheckoutPaymentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  com.elarian.hera.proto.Web.CheckoutPaymentReply.getDefaultInstance()))
              .build();
        }
      }
    }
    return getCheckoutPaymentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.elarian.hera.proto.Web.MakeVoiceCallRequest,
      com.elarian.hera.proto.Web.MakeVoiceCallReply> getMakeVoiceCallMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "MakeVoiceCall",
      requestType = com.elarian.hera.proto.Web.MakeVoiceCallRequest.class,
      responseType = com.elarian.hera.proto.Web.MakeVoiceCallReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.elarian.hera.proto.Web.MakeVoiceCallRequest,
      com.elarian.hera.proto.Web.MakeVoiceCallReply> getMakeVoiceCallMethod() {
    io.grpc.MethodDescriptor<com.elarian.hera.proto.Web.MakeVoiceCallRequest, com.elarian.hera.proto.Web.MakeVoiceCallReply> getMakeVoiceCallMethod;
    if ((getMakeVoiceCallMethod = GrpcWebServiceGrpc.getMakeVoiceCallMethod) == null) {
      synchronized (GrpcWebServiceGrpc.class) {
        if ((getMakeVoiceCallMethod = GrpcWebServiceGrpc.getMakeVoiceCallMethod) == null) {
          GrpcWebServiceGrpc.getMakeVoiceCallMethod = getMakeVoiceCallMethod =
              io.grpc.MethodDescriptor.<com.elarian.hera.proto.Web.MakeVoiceCallRequest, com.elarian.hera.proto.Web.MakeVoiceCallReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "MakeVoiceCall"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  com.elarian.hera.proto.Web.MakeVoiceCallRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  com.elarian.hera.proto.Web.MakeVoiceCallReply.getDefaultInstance()))
              .build();
        }
      }
    }
    return getMakeVoiceCallMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.elarian.hera.proto.Web.StreamNotificationRequest,
      com.elarian.hera.proto.Web.WebhookRequest> getStreamNotificationsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StreamNotifications",
      requestType = com.elarian.hera.proto.Web.StreamNotificationRequest.class,
      responseType = com.elarian.hera.proto.Web.WebhookRequest.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.elarian.hera.proto.Web.StreamNotificationRequest,
      com.elarian.hera.proto.Web.WebhookRequest> getStreamNotificationsMethod() {
    io.grpc.MethodDescriptor<com.elarian.hera.proto.Web.StreamNotificationRequest, com.elarian.hera.proto.Web.WebhookRequest> getStreamNotificationsMethod;
    if ((getStreamNotificationsMethod = GrpcWebServiceGrpc.getStreamNotificationsMethod) == null) {
      synchronized (GrpcWebServiceGrpc.class) {
        if ((getStreamNotificationsMethod = GrpcWebServiceGrpc.getStreamNotificationsMethod) == null) {
          GrpcWebServiceGrpc.getStreamNotificationsMethod = getStreamNotificationsMethod =
              io.grpc.MethodDescriptor.<com.elarian.hera.proto.Web.StreamNotificationRequest, com.elarian.hera.proto.Web.WebhookRequest>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StreamNotifications"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  com.elarian.hera.proto.Web.StreamNotificationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  com.elarian.hera.proto.Web.WebhookRequest.getDefaultInstance()))
              .build();
        }
      }
    }
    return getStreamNotificationsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.elarian.hera.proto.Web.WebhookResponse,
      com.elarian.hera.proto.Web.WebhookResponseReply> getSendWebhookResponseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SendWebhookResponse",
      requestType = com.elarian.hera.proto.Web.WebhookResponse.class,
      responseType = com.elarian.hera.proto.Web.WebhookResponseReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.elarian.hera.proto.Web.WebhookResponse,
      com.elarian.hera.proto.Web.WebhookResponseReply> getSendWebhookResponseMethod() {
    io.grpc.MethodDescriptor<com.elarian.hera.proto.Web.WebhookResponse, com.elarian.hera.proto.Web.WebhookResponseReply> getSendWebhookResponseMethod;
    if ((getSendWebhookResponseMethod = GrpcWebServiceGrpc.getSendWebhookResponseMethod) == null) {
      synchronized (GrpcWebServiceGrpc.class) {
        if ((getSendWebhookResponseMethod = GrpcWebServiceGrpc.getSendWebhookResponseMethod) == null) {
          GrpcWebServiceGrpc.getSendWebhookResponseMethod = getSendWebhookResponseMethod =
              io.grpc.MethodDescriptor.<com.elarian.hera.proto.Web.WebhookResponse, com.elarian.hera.proto.Web.WebhookResponseReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SendWebhookResponse"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  com.elarian.hera.proto.Web.WebhookResponse.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  com.elarian.hera.proto.Web.WebhookResponseReply.getDefaultInstance()))
              .build();
        }
      }
    }
    return getSendWebhookResponseMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static GrpcWebServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GrpcWebServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GrpcWebServiceStub>() {
        @java.lang.Override
        public GrpcWebServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GrpcWebServiceStub(channel, callOptions);
        }
      };
    return GrpcWebServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GrpcWebServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GrpcWebServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GrpcWebServiceBlockingStub>() {
        @java.lang.Override
        public GrpcWebServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GrpcWebServiceBlockingStub(channel, callOptions);
        }
      };
    return GrpcWebServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static GrpcWebServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GrpcWebServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GrpcWebServiceFutureStub>() {
        @java.lang.Override
        public GrpcWebServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GrpcWebServiceFutureStub(channel, callOptions);
        }
      };
    return GrpcWebServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class GrpcWebServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void authToken(com.elarian.hera.proto.Web.AuthTokenRequest request,
        io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.AuthTokenReply> responseObserver) {
      asyncUnimplementedUnaryCall(getAuthTokenMethod(), responseObserver);
    }

    /**
     */
    public void getCustomerState(com.elarian.hera.proto.Web.GetCustomerStateRequest request,
        io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.GetCustomerStateReply> responseObserver) {
      asyncUnimplementedUnaryCall(getGetCustomerStateMethod(), responseObserver);
    }

    /**
     */
    public void adoptCustomerState(com.elarian.hera.proto.Web.AdoptCustomerStateRequest request,
        io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.UpdateCustomerStateReply> responseObserver) {
      asyncUnimplementedUnaryCall(getAdoptCustomerStateMethod(), responseObserver);
    }

    /**
     */
    public void addCustomerReminder(com.elarian.hera.proto.Web.AddCustomerReminderRequest request,
        io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.UpdateCustomerStateReply> responseObserver) {
      asyncUnimplementedUnaryCall(getAddCustomerReminderMethod(), responseObserver);
    }

    /**
     */
    public void addCustomerReminderByTag(com.elarian.hera.proto.Web.AddCustomerReminderTagRequest request,
        io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.TagCommandReply> responseObserver) {
      asyncUnimplementedUnaryCall(getAddCustomerReminderByTagMethod(), responseObserver);
    }

    /**
     */
    public void cancelCustomerReminder(com.elarian.hera.proto.Web.CancelCustomerReminderRequest request,
        io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.UpdateCustomerStateReply> responseObserver) {
      asyncUnimplementedUnaryCall(getCancelCustomerReminderMethod(), responseObserver);
    }

    /**
     */
    public void cancelCustomerReminderByTag(com.elarian.hera.proto.Web.CancelCustomerReminderTagRequest request,
        io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.TagCommandReply> responseObserver) {
      asyncUnimplementedUnaryCall(getCancelCustomerReminderByTagMethod(), responseObserver);
    }

    /**
     */
    public void updateCustomerTag(com.elarian.hera.proto.Web.UpdateCustomerTagRequest request,
        io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.UpdateCustomerStateReply> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateCustomerTagMethod(), responseObserver);
    }

    /**
     */
    public void deleteCustomerTag(com.elarian.hera.proto.Web.DeleteCustomerTagRequest request,
        io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.UpdateCustomerStateReply> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteCustomerTagMethod(), responseObserver);
    }

    /**
     */
    public void updateCustomerSecondaryId(com.elarian.hera.proto.Web.UpdateCustomerSecondaryIdRequest request,
        io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.UpdateCustomerStateReply> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateCustomerSecondaryIdMethod(), responseObserver);
    }

    /**
     */
    public void deleteCustomerSecondaryId(com.elarian.hera.proto.Web.DeleteCustomerSecondaryIdRequest request,
        io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.UpdateCustomerStateReply> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteCustomerSecondaryIdMethod(), responseObserver);
    }

    /**
     */
    public void updateCustomerMetadata(com.elarian.hera.proto.Web.UpdateCustomerMetadataRequest request,
        io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.UpdateCustomerStateReply> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateCustomerMetadataMethod(), responseObserver);
    }

    /**
     */
    public void deleteCustomerMetadata(com.elarian.hera.proto.Web.DeleteCustomerMetadataRequest request,
        io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.UpdateCustomerStateReply> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteCustomerMetadataMethod(), responseObserver);
    }

    /**
     */
    public void sendMessage(com.elarian.hera.proto.Web.SendMessageRequest request,
        io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.SendMessageReply> responseObserver) {
      asyncUnimplementedUnaryCall(getSendMessageMethod(), responseObserver);
    }

    /**
     */
    public void sendMessageByTag(com.elarian.hera.proto.Web.SendMessageTagRequest request,
        io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.TagCommandReply> responseObserver) {
      asyncUnimplementedUnaryCall(getSendMessageByTagMethod(), responseObserver);
    }

    /**
     */
    public void replyToMessage(com.elarian.hera.proto.Web.ReplyToMessageRequest request,
        io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.SendMessageReply> responseObserver) {
      asyncUnimplementedUnaryCall(getReplyToMessageMethod(), responseObserver);
    }

    /**
     */
    public void messagingConsent(com.elarian.hera.proto.Web.MessagingConsentRequest request,
        io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.MessagingConsentReply> responseObserver) {
      asyncUnimplementedUnaryCall(getMessagingConsentMethod(), responseObserver);
    }

    /**
     */
    public void sendPayment(com.elarian.hera.proto.Web.SendPaymentRequest request,
        io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.SendPaymentReply> responseObserver) {
      asyncUnimplementedUnaryCall(getSendPaymentMethod(), responseObserver);
    }

    /**
     */
    public void checkoutPayment(com.elarian.hera.proto.Web.CheckoutPaymentRequest request,
        io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.CheckoutPaymentReply> responseObserver) {
      asyncUnimplementedUnaryCall(getCheckoutPaymentMethod(), responseObserver);
    }

    /**
     */
    public void makeVoiceCall(com.elarian.hera.proto.Web.MakeVoiceCallRequest request,
        io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.MakeVoiceCallReply> responseObserver) {
      asyncUnimplementedUnaryCall(getMakeVoiceCallMethod(), responseObserver);
    }

    /**
     */
    public void streamNotifications(com.elarian.hera.proto.Web.StreamNotificationRequest request,
        io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.WebhookRequest> responseObserver) {
      asyncUnimplementedUnaryCall(getStreamNotificationsMethod(), responseObserver);
    }

    /**
     */
    public void sendWebhookResponse(com.elarian.hera.proto.Web.WebhookResponse request,
        io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.WebhookResponseReply> responseObserver) {
      asyncUnimplementedUnaryCall(getSendWebhookResponseMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAuthTokenMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.elarian.hera.proto.Web.AuthTokenRequest,
                com.elarian.hera.proto.Web.AuthTokenReply>(
                  this, METHODID_AUTH_TOKEN)))
          .addMethod(
            getGetCustomerStateMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.elarian.hera.proto.Web.GetCustomerStateRequest,
                com.elarian.hera.proto.Web.GetCustomerStateReply>(
                  this, METHODID_GET_CUSTOMER_STATE)))
          .addMethod(
            getAdoptCustomerStateMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.elarian.hera.proto.Web.AdoptCustomerStateRequest,
                com.elarian.hera.proto.Web.UpdateCustomerStateReply>(
                  this, METHODID_ADOPT_CUSTOMER_STATE)))
          .addMethod(
            getAddCustomerReminderMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.elarian.hera.proto.Web.AddCustomerReminderRequest,
                com.elarian.hera.proto.Web.UpdateCustomerStateReply>(
                  this, METHODID_ADD_CUSTOMER_REMINDER)))
          .addMethod(
            getAddCustomerReminderByTagMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.elarian.hera.proto.Web.AddCustomerReminderTagRequest,
                com.elarian.hera.proto.Web.TagCommandReply>(
                  this, METHODID_ADD_CUSTOMER_REMINDER_BY_TAG)))
          .addMethod(
            getCancelCustomerReminderMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.elarian.hera.proto.Web.CancelCustomerReminderRequest,
                com.elarian.hera.proto.Web.UpdateCustomerStateReply>(
                  this, METHODID_CANCEL_CUSTOMER_REMINDER)))
          .addMethod(
            getCancelCustomerReminderByTagMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.elarian.hera.proto.Web.CancelCustomerReminderTagRequest,
                com.elarian.hera.proto.Web.TagCommandReply>(
                  this, METHODID_CANCEL_CUSTOMER_REMINDER_BY_TAG)))
          .addMethod(
            getUpdateCustomerTagMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.elarian.hera.proto.Web.UpdateCustomerTagRequest,
                com.elarian.hera.proto.Web.UpdateCustomerStateReply>(
                  this, METHODID_UPDATE_CUSTOMER_TAG)))
          .addMethod(
            getDeleteCustomerTagMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.elarian.hera.proto.Web.DeleteCustomerTagRequest,
                com.elarian.hera.proto.Web.UpdateCustomerStateReply>(
                  this, METHODID_DELETE_CUSTOMER_TAG)))
          .addMethod(
            getUpdateCustomerSecondaryIdMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.elarian.hera.proto.Web.UpdateCustomerSecondaryIdRequest,
                com.elarian.hera.proto.Web.UpdateCustomerStateReply>(
                  this, METHODID_UPDATE_CUSTOMER_SECONDARY_ID)))
          .addMethod(
            getDeleteCustomerSecondaryIdMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.elarian.hera.proto.Web.DeleteCustomerSecondaryIdRequest,
                com.elarian.hera.proto.Web.UpdateCustomerStateReply>(
                  this, METHODID_DELETE_CUSTOMER_SECONDARY_ID)))
          .addMethod(
            getUpdateCustomerMetadataMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.elarian.hera.proto.Web.UpdateCustomerMetadataRequest,
                com.elarian.hera.proto.Web.UpdateCustomerStateReply>(
                  this, METHODID_UPDATE_CUSTOMER_METADATA)))
          .addMethod(
            getDeleteCustomerMetadataMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.elarian.hera.proto.Web.DeleteCustomerMetadataRequest,
                com.elarian.hera.proto.Web.UpdateCustomerStateReply>(
                  this, METHODID_DELETE_CUSTOMER_METADATA)))
          .addMethod(
            getSendMessageMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.elarian.hera.proto.Web.SendMessageRequest,
                com.elarian.hera.proto.Web.SendMessageReply>(
                  this, METHODID_SEND_MESSAGE)))
          .addMethod(
            getSendMessageByTagMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.elarian.hera.proto.Web.SendMessageTagRequest,
                com.elarian.hera.proto.Web.TagCommandReply>(
                  this, METHODID_SEND_MESSAGE_BY_TAG)))
          .addMethod(
            getReplyToMessageMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.elarian.hera.proto.Web.ReplyToMessageRequest,
                com.elarian.hera.proto.Web.SendMessageReply>(
                  this, METHODID_REPLY_TO_MESSAGE)))
          .addMethod(
            getMessagingConsentMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.elarian.hera.proto.Web.MessagingConsentRequest,
                com.elarian.hera.proto.Web.MessagingConsentReply>(
                  this, METHODID_MESSAGING_CONSENT)))
          .addMethod(
            getSendPaymentMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.elarian.hera.proto.Web.SendPaymentRequest,
                com.elarian.hera.proto.Web.SendPaymentReply>(
                  this, METHODID_SEND_PAYMENT)))
          .addMethod(
            getCheckoutPaymentMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.elarian.hera.proto.Web.CheckoutPaymentRequest,
                com.elarian.hera.proto.Web.CheckoutPaymentReply>(
                  this, METHODID_CHECKOUT_PAYMENT)))
          .addMethod(
            getMakeVoiceCallMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.elarian.hera.proto.Web.MakeVoiceCallRequest,
                com.elarian.hera.proto.Web.MakeVoiceCallReply>(
                  this, METHODID_MAKE_VOICE_CALL)))
          .addMethod(
            getStreamNotificationsMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.elarian.hera.proto.Web.StreamNotificationRequest,
                com.elarian.hera.proto.Web.WebhookRequest>(
                  this, METHODID_STREAM_NOTIFICATIONS)))
          .addMethod(
            getSendWebhookResponseMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.elarian.hera.proto.Web.WebhookResponse,
                com.elarian.hera.proto.Web.WebhookResponseReply>(
                  this, METHODID_SEND_WEBHOOK_RESPONSE)))
          .build();
    }
  }

  /**
   */
  public static final class GrpcWebServiceStub extends io.grpc.stub.AbstractAsyncStub<GrpcWebServiceStub> {
    private GrpcWebServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GrpcWebServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GrpcWebServiceStub(channel, callOptions);
    }

    /**
     */
    public void authToken(com.elarian.hera.proto.Web.AuthTokenRequest request,
        io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.AuthTokenReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAuthTokenMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getCustomerState(com.elarian.hera.proto.Web.GetCustomerStateRequest request,
        io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.GetCustomerStateReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetCustomerStateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void adoptCustomerState(com.elarian.hera.proto.Web.AdoptCustomerStateRequest request,
        io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.UpdateCustomerStateReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAdoptCustomerStateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addCustomerReminder(com.elarian.hera.proto.Web.AddCustomerReminderRequest request,
        io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.UpdateCustomerStateReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddCustomerReminderMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addCustomerReminderByTag(com.elarian.hera.proto.Web.AddCustomerReminderTagRequest request,
        io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.TagCommandReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddCustomerReminderByTagMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void cancelCustomerReminder(com.elarian.hera.proto.Web.CancelCustomerReminderRequest request,
        io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.UpdateCustomerStateReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCancelCustomerReminderMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void cancelCustomerReminderByTag(com.elarian.hera.proto.Web.CancelCustomerReminderTagRequest request,
        io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.TagCommandReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCancelCustomerReminderByTagMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateCustomerTag(com.elarian.hera.proto.Web.UpdateCustomerTagRequest request,
        io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.UpdateCustomerStateReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateCustomerTagMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteCustomerTag(com.elarian.hera.proto.Web.DeleteCustomerTagRequest request,
        io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.UpdateCustomerStateReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteCustomerTagMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateCustomerSecondaryId(com.elarian.hera.proto.Web.UpdateCustomerSecondaryIdRequest request,
        io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.UpdateCustomerStateReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateCustomerSecondaryIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteCustomerSecondaryId(com.elarian.hera.proto.Web.DeleteCustomerSecondaryIdRequest request,
        io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.UpdateCustomerStateReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteCustomerSecondaryIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateCustomerMetadata(com.elarian.hera.proto.Web.UpdateCustomerMetadataRequest request,
        io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.UpdateCustomerStateReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateCustomerMetadataMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteCustomerMetadata(com.elarian.hera.proto.Web.DeleteCustomerMetadataRequest request,
        io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.UpdateCustomerStateReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteCustomerMetadataMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void sendMessage(com.elarian.hera.proto.Web.SendMessageRequest request,
        io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.SendMessageReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSendMessageMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void sendMessageByTag(com.elarian.hera.proto.Web.SendMessageTagRequest request,
        io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.TagCommandReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSendMessageByTagMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void replyToMessage(com.elarian.hera.proto.Web.ReplyToMessageRequest request,
        io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.SendMessageReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReplyToMessageMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void messagingConsent(com.elarian.hera.proto.Web.MessagingConsentRequest request,
        io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.MessagingConsentReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getMessagingConsentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void sendPayment(com.elarian.hera.proto.Web.SendPaymentRequest request,
        io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.SendPaymentReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSendPaymentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void checkoutPayment(com.elarian.hera.proto.Web.CheckoutPaymentRequest request,
        io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.CheckoutPaymentReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCheckoutPaymentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void makeVoiceCall(com.elarian.hera.proto.Web.MakeVoiceCallRequest request,
        io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.MakeVoiceCallReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getMakeVoiceCallMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void streamNotifications(com.elarian.hera.proto.Web.StreamNotificationRequest request,
        io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.WebhookRequest> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getStreamNotificationsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void sendWebhookResponse(com.elarian.hera.proto.Web.WebhookResponse request,
        io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.WebhookResponseReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSendWebhookResponseMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class GrpcWebServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<GrpcWebServiceBlockingStub> {
    private GrpcWebServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GrpcWebServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GrpcWebServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.elarian.hera.proto.Web.AuthTokenReply authToken(com.elarian.hera.proto.Web.AuthTokenRequest request) {
      return blockingUnaryCall(
          getChannel(), getAuthTokenMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.elarian.hera.proto.Web.GetCustomerStateReply getCustomerState(com.elarian.hera.proto.Web.GetCustomerStateRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetCustomerStateMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.elarian.hera.proto.Web.UpdateCustomerStateReply adoptCustomerState(com.elarian.hera.proto.Web.AdoptCustomerStateRequest request) {
      return blockingUnaryCall(
          getChannel(), getAdoptCustomerStateMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.elarian.hera.proto.Web.UpdateCustomerStateReply addCustomerReminder(com.elarian.hera.proto.Web.AddCustomerReminderRequest request) {
      return blockingUnaryCall(
          getChannel(), getAddCustomerReminderMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.elarian.hera.proto.Web.TagCommandReply addCustomerReminderByTag(com.elarian.hera.proto.Web.AddCustomerReminderTagRequest request) {
      return blockingUnaryCall(
          getChannel(), getAddCustomerReminderByTagMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.elarian.hera.proto.Web.UpdateCustomerStateReply cancelCustomerReminder(com.elarian.hera.proto.Web.CancelCustomerReminderRequest request) {
      return blockingUnaryCall(
          getChannel(), getCancelCustomerReminderMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.elarian.hera.proto.Web.TagCommandReply cancelCustomerReminderByTag(com.elarian.hera.proto.Web.CancelCustomerReminderTagRequest request) {
      return blockingUnaryCall(
          getChannel(), getCancelCustomerReminderByTagMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.elarian.hera.proto.Web.UpdateCustomerStateReply updateCustomerTag(com.elarian.hera.proto.Web.UpdateCustomerTagRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateCustomerTagMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.elarian.hera.proto.Web.UpdateCustomerStateReply deleteCustomerTag(com.elarian.hera.proto.Web.DeleteCustomerTagRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteCustomerTagMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.elarian.hera.proto.Web.UpdateCustomerStateReply updateCustomerSecondaryId(com.elarian.hera.proto.Web.UpdateCustomerSecondaryIdRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateCustomerSecondaryIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.elarian.hera.proto.Web.UpdateCustomerStateReply deleteCustomerSecondaryId(com.elarian.hera.proto.Web.DeleteCustomerSecondaryIdRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteCustomerSecondaryIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.elarian.hera.proto.Web.UpdateCustomerStateReply updateCustomerMetadata(com.elarian.hera.proto.Web.UpdateCustomerMetadataRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateCustomerMetadataMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.elarian.hera.proto.Web.UpdateCustomerStateReply deleteCustomerMetadata(com.elarian.hera.proto.Web.DeleteCustomerMetadataRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteCustomerMetadataMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.elarian.hera.proto.Web.SendMessageReply sendMessage(com.elarian.hera.proto.Web.SendMessageRequest request) {
      return blockingUnaryCall(
          getChannel(), getSendMessageMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.elarian.hera.proto.Web.TagCommandReply sendMessageByTag(com.elarian.hera.proto.Web.SendMessageTagRequest request) {
      return blockingUnaryCall(
          getChannel(), getSendMessageByTagMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.elarian.hera.proto.Web.SendMessageReply replyToMessage(com.elarian.hera.proto.Web.ReplyToMessageRequest request) {
      return blockingUnaryCall(
          getChannel(), getReplyToMessageMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.elarian.hera.proto.Web.MessagingConsentReply messagingConsent(com.elarian.hera.proto.Web.MessagingConsentRequest request) {
      return blockingUnaryCall(
          getChannel(), getMessagingConsentMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.elarian.hera.proto.Web.SendPaymentReply sendPayment(com.elarian.hera.proto.Web.SendPaymentRequest request) {
      return blockingUnaryCall(
          getChannel(), getSendPaymentMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.elarian.hera.proto.Web.CheckoutPaymentReply checkoutPayment(com.elarian.hera.proto.Web.CheckoutPaymentRequest request) {
      return blockingUnaryCall(
          getChannel(), getCheckoutPaymentMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.elarian.hera.proto.Web.MakeVoiceCallReply makeVoiceCall(com.elarian.hera.proto.Web.MakeVoiceCallRequest request) {
      return blockingUnaryCall(
          getChannel(), getMakeVoiceCallMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<com.elarian.hera.proto.Web.WebhookRequest> streamNotifications(
        com.elarian.hera.proto.Web.StreamNotificationRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getStreamNotificationsMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.elarian.hera.proto.Web.WebhookResponseReply sendWebhookResponse(com.elarian.hera.proto.Web.WebhookResponse request) {
      return blockingUnaryCall(
          getChannel(), getSendWebhookResponseMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class GrpcWebServiceFutureStub extends io.grpc.stub.AbstractFutureStub<GrpcWebServiceFutureStub> {
    private GrpcWebServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GrpcWebServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GrpcWebServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.elarian.hera.proto.Web.AuthTokenReply> authToken(
        com.elarian.hera.proto.Web.AuthTokenRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getAuthTokenMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.elarian.hera.proto.Web.GetCustomerStateReply> getCustomerState(
        com.elarian.hera.proto.Web.GetCustomerStateRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetCustomerStateMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.elarian.hera.proto.Web.UpdateCustomerStateReply> adoptCustomerState(
        com.elarian.hera.proto.Web.AdoptCustomerStateRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getAdoptCustomerStateMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.elarian.hera.proto.Web.UpdateCustomerStateReply> addCustomerReminder(
        com.elarian.hera.proto.Web.AddCustomerReminderRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getAddCustomerReminderMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.elarian.hera.proto.Web.TagCommandReply> addCustomerReminderByTag(
        com.elarian.hera.proto.Web.AddCustomerReminderTagRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getAddCustomerReminderByTagMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.elarian.hera.proto.Web.UpdateCustomerStateReply> cancelCustomerReminder(
        com.elarian.hera.proto.Web.CancelCustomerReminderRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCancelCustomerReminderMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.elarian.hera.proto.Web.TagCommandReply> cancelCustomerReminderByTag(
        com.elarian.hera.proto.Web.CancelCustomerReminderTagRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCancelCustomerReminderByTagMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.elarian.hera.proto.Web.UpdateCustomerStateReply> updateCustomerTag(
        com.elarian.hera.proto.Web.UpdateCustomerTagRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateCustomerTagMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.elarian.hera.proto.Web.UpdateCustomerStateReply> deleteCustomerTag(
        com.elarian.hera.proto.Web.DeleteCustomerTagRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteCustomerTagMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.elarian.hera.proto.Web.UpdateCustomerStateReply> updateCustomerSecondaryId(
        com.elarian.hera.proto.Web.UpdateCustomerSecondaryIdRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateCustomerSecondaryIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.elarian.hera.proto.Web.UpdateCustomerStateReply> deleteCustomerSecondaryId(
        com.elarian.hera.proto.Web.DeleteCustomerSecondaryIdRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteCustomerSecondaryIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.elarian.hera.proto.Web.UpdateCustomerStateReply> updateCustomerMetadata(
        com.elarian.hera.proto.Web.UpdateCustomerMetadataRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateCustomerMetadataMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.elarian.hera.proto.Web.UpdateCustomerStateReply> deleteCustomerMetadata(
        com.elarian.hera.proto.Web.DeleteCustomerMetadataRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteCustomerMetadataMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.elarian.hera.proto.Web.SendMessageReply> sendMessage(
        com.elarian.hera.proto.Web.SendMessageRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSendMessageMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.elarian.hera.proto.Web.TagCommandReply> sendMessageByTag(
        com.elarian.hera.proto.Web.SendMessageTagRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSendMessageByTagMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.elarian.hera.proto.Web.SendMessageReply> replyToMessage(
        com.elarian.hera.proto.Web.ReplyToMessageRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getReplyToMessageMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.elarian.hera.proto.Web.MessagingConsentReply> messagingConsent(
        com.elarian.hera.proto.Web.MessagingConsentRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getMessagingConsentMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.elarian.hera.proto.Web.SendPaymentReply> sendPayment(
        com.elarian.hera.proto.Web.SendPaymentRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSendPaymentMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.elarian.hera.proto.Web.CheckoutPaymentReply> checkoutPayment(
        com.elarian.hera.proto.Web.CheckoutPaymentRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCheckoutPaymentMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.elarian.hera.proto.Web.MakeVoiceCallReply> makeVoiceCall(
        com.elarian.hera.proto.Web.MakeVoiceCallRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getMakeVoiceCallMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.elarian.hera.proto.Web.WebhookResponseReply> sendWebhookResponse(
        com.elarian.hera.proto.Web.WebhookResponse request) {
      return futureUnaryCall(
          getChannel().newCall(getSendWebhookResponseMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_AUTH_TOKEN = 0;
  private static final int METHODID_GET_CUSTOMER_STATE = 1;
  private static final int METHODID_ADOPT_CUSTOMER_STATE = 2;
  private static final int METHODID_ADD_CUSTOMER_REMINDER = 3;
  private static final int METHODID_ADD_CUSTOMER_REMINDER_BY_TAG = 4;
  private static final int METHODID_CANCEL_CUSTOMER_REMINDER = 5;
  private static final int METHODID_CANCEL_CUSTOMER_REMINDER_BY_TAG = 6;
  private static final int METHODID_UPDATE_CUSTOMER_TAG = 7;
  private static final int METHODID_DELETE_CUSTOMER_TAG = 8;
  private static final int METHODID_UPDATE_CUSTOMER_SECONDARY_ID = 9;
  private static final int METHODID_DELETE_CUSTOMER_SECONDARY_ID = 10;
  private static final int METHODID_UPDATE_CUSTOMER_METADATA = 11;
  private static final int METHODID_DELETE_CUSTOMER_METADATA = 12;
  private static final int METHODID_SEND_MESSAGE = 13;
  private static final int METHODID_SEND_MESSAGE_BY_TAG = 14;
  private static final int METHODID_REPLY_TO_MESSAGE = 15;
  private static final int METHODID_MESSAGING_CONSENT = 16;
  private static final int METHODID_SEND_PAYMENT = 17;
  private static final int METHODID_CHECKOUT_PAYMENT = 18;
  private static final int METHODID_MAKE_VOICE_CALL = 19;
  private static final int METHODID_STREAM_NOTIFICATIONS = 20;
  private static final int METHODID_SEND_WEBHOOK_RESPONSE = 21;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final GrpcWebServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(GrpcWebServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_AUTH_TOKEN:
          serviceImpl.authToken((com.elarian.hera.proto.Web.AuthTokenRequest) request,
              (io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.AuthTokenReply>) responseObserver);
          break;
        case METHODID_GET_CUSTOMER_STATE:
          serviceImpl.getCustomerState((com.elarian.hera.proto.Web.GetCustomerStateRequest) request,
              (io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.GetCustomerStateReply>) responseObserver);
          break;
        case METHODID_ADOPT_CUSTOMER_STATE:
          serviceImpl.adoptCustomerState((com.elarian.hera.proto.Web.AdoptCustomerStateRequest) request,
              (io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.UpdateCustomerStateReply>) responseObserver);
          break;
        case METHODID_ADD_CUSTOMER_REMINDER:
          serviceImpl.addCustomerReminder((com.elarian.hera.proto.Web.AddCustomerReminderRequest) request,
              (io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.UpdateCustomerStateReply>) responseObserver);
          break;
        case METHODID_ADD_CUSTOMER_REMINDER_BY_TAG:
          serviceImpl.addCustomerReminderByTag((com.elarian.hera.proto.Web.AddCustomerReminderTagRequest) request,
              (io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.TagCommandReply>) responseObserver);
          break;
        case METHODID_CANCEL_CUSTOMER_REMINDER:
          serviceImpl.cancelCustomerReminder((com.elarian.hera.proto.Web.CancelCustomerReminderRequest) request,
              (io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.UpdateCustomerStateReply>) responseObserver);
          break;
        case METHODID_CANCEL_CUSTOMER_REMINDER_BY_TAG:
          serviceImpl.cancelCustomerReminderByTag((com.elarian.hera.proto.Web.CancelCustomerReminderTagRequest) request,
              (io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.TagCommandReply>) responseObserver);
          break;
        case METHODID_UPDATE_CUSTOMER_TAG:
          serviceImpl.updateCustomerTag((com.elarian.hera.proto.Web.UpdateCustomerTagRequest) request,
              (io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.UpdateCustomerStateReply>) responseObserver);
          break;
        case METHODID_DELETE_CUSTOMER_TAG:
          serviceImpl.deleteCustomerTag((com.elarian.hera.proto.Web.DeleteCustomerTagRequest) request,
              (io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.UpdateCustomerStateReply>) responseObserver);
          break;
        case METHODID_UPDATE_CUSTOMER_SECONDARY_ID:
          serviceImpl.updateCustomerSecondaryId((com.elarian.hera.proto.Web.UpdateCustomerSecondaryIdRequest) request,
              (io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.UpdateCustomerStateReply>) responseObserver);
          break;
        case METHODID_DELETE_CUSTOMER_SECONDARY_ID:
          serviceImpl.deleteCustomerSecondaryId((com.elarian.hera.proto.Web.DeleteCustomerSecondaryIdRequest) request,
              (io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.UpdateCustomerStateReply>) responseObserver);
          break;
        case METHODID_UPDATE_CUSTOMER_METADATA:
          serviceImpl.updateCustomerMetadata((com.elarian.hera.proto.Web.UpdateCustomerMetadataRequest) request,
              (io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.UpdateCustomerStateReply>) responseObserver);
          break;
        case METHODID_DELETE_CUSTOMER_METADATA:
          serviceImpl.deleteCustomerMetadata((com.elarian.hera.proto.Web.DeleteCustomerMetadataRequest) request,
              (io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.UpdateCustomerStateReply>) responseObserver);
          break;
        case METHODID_SEND_MESSAGE:
          serviceImpl.sendMessage((com.elarian.hera.proto.Web.SendMessageRequest) request,
              (io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.SendMessageReply>) responseObserver);
          break;
        case METHODID_SEND_MESSAGE_BY_TAG:
          serviceImpl.sendMessageByTag((com.elarian.hera.proto.Web.SendMessageTagRequest) request,
              (io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.TagCommandReply>) responseObserver);
          break;
        case METHODID_REPLY_TO_MESSAGE:
          serviceImpl.replyToMessage((com.elarian.hera.proto.Web.ReplyToMessageRequest) request,
              (io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.SendMessageReply>) responseObserver);
          break;
        case METHODID_MESSAGING_CONSENT:
          serviceImpl.messagingConsent((com.elarian.hera.proto.Web.MessagingConsentRequest) request,
              (io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.MessagingConsentReply>) responseObserver);
          break;
        case METHODID_SEND_PAYMENT:
          serviceImpl.sendPayment((com.elarian.hera.proto.Web.SendPaymentRequest) request,
              (io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.SendPaymentReply>) responseObserver);
          break;
        case METHODID_CHECKOUT_PAYMENT:
          serviceImpl.checkoutPayment((com.elarian.hera.proto.Web.CheckoutPaymentRequest) request,
              (io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.CheckoutPaymentReply>) responseObserver);
          break;
        case METHODID_MAKE_VOICE_CALL:
          serviceImpl.makeVoiceCall((com.elarian.hera.proto.Web.MakeVoiceCallRequest) request,
              (io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.MakeVoiceCallReply>) responseObserver);
          break;
        case METHODID_STREAM_NOTIFICATIONS:
          serviceImpl.streamNotifications((com.elarian.hera.proto.Web.StreamNotificationRequest) request,
              (io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.WebhookRequest>) responseObserver);
          break;
        case METHODID_SEND_WEBHOOK_RESPONSE:
          serviceImpl.sendWebhookResponse((com.elarian.hera.proto.Web.WebhookResponse) request,
              (io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.WebhookResponseReply>) responseObserver);
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

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (GrpcWebServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .addMethod(getAuthTokenMethod())
              .addMethod(getGetCustomerStateMethod())
              .addMethod(getAdoptCustomerStateMethod())
              .addMethod(getAddCustomerReminderMethod())
              .addMethod(getAddCustomerReminderByTagMethod())
              .addMethod(getCancelCustomerReminderMethod())
              .addMethod(getCancelCustomerReminderByTagMethod())
              .addMethod(getUpdateCustomerTagMethod())
              .addMethod(getDeleteCustomerTagMethod())
              .addMethod(getUpdateCustomerSecondaryIdMethod())
              .addMethod(getDeleteCustomerSecondaryIdMethod())
              .addMethod(getUpdateCustomerMetadataMethod())
              .addMethod(getDeleteCustomerMetadataMethod())
              .addMethod(getSendMessageMethod())
              .addMethod(getSendMessageByTagMethod())
              .addMethod(getReplyToMessageMethod())
              .addMethod(getMessagingConsentMethod())
              .addMethod(getSendPaymentMethod())
              .addMethod(getCheckoutPaymentMethod())
              .addMethod(getMakeVoiceCallMethod())
              .addMethod(getStreamNotificationsMethod())
              .addMethod(getSendWebhookResponseMethod())
              .build();
        }
      }
    }
    return result;
  }
}
