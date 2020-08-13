package com.elarian.hera.proto;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: web.proto")
public final class GrpcWebServiceGrpc {

  private GrpcWebServiceGrpc() {}

  public static final String SERVICE_NAME = "com.elarian.hera.proto.GrpcWebService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.elarian.hera.proto.Web.AuthTokenRequest,
      com.elarian.hera.proto.Web.AuthTokenReply> METHOD_AUTH_TOKEN =
      io.grpc.MethodDescriptor.<com.elarian.hera.proto.Web.AuthTokenRequest, com.elarian.hera.proto.Web.AuthTokenReply>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.elarian.hera.proto.GrpcWebService", "AuthToken"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.elarian.hera.proto.Web.AuthTokenRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.elarian.hera.proto.Web.AuthTokenReply.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.elarian.hera.proto.Web.GetCustomerStateRequest,
      com.elarian.hera.proto.Web.GetCustomerStateReply> METHOD_GET_CUSTOMER_STATE =
      io.grpc.MethodDescriptor.<com.elarian.hera.proto.Web.GetCustomerStateRequest, com.elarian.hera.proto.Web.GetCustomerStateReply>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.elarian.hera.proto.GrpcWebService", "GetCustomerState"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.elarian.hera.proto.Web.GetCustomerStateRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.elarian.hera.proto.Web.GetCustomerStateReply.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.elarian.hera.proto.Web.AdoptCustomerStateRequest,
      com.elarian.hera.proto.Web.UpdateCustomerStateReply> METHOD_ADOPT_CUSTOMER_STATE =
      io.grpc.MethodDescriptor.<com.elarian.hera.proto.Web.AdoptCustomerStateRequest, com.elarian.hera.proto.Web.UpdateCustomerStateReply>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.elarian.hera.proto.GrpcWebService", "AdoptCustomerState"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.elarian.hera.proto.Web.AdoptCustomerStateRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.elarian.hera.proto.Web.UpdateCustomerStateReply.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.elarian.hera.proto.Web.AddCustomerReminderRequest,
      com.elarian.hera.proto.Web.UpdateCustomerStateReply> METHOD_ADD_CUSTOMER_REMINDER =
      io.grpc.MethodDescriptor.<com.elarian.hera.proto.Web.AddCustomerReminderRequest, com.elarian.hera.proto.Web.UpdateCustomerStateReply>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.elarian.hera.proto.GrpcWebService", "AddCustomerReminder"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.elarian.hera.proto.Web.AddCustomerReminderRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.elarian.hera.proto.Web.UpdateCustomerStateReply.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.elarian.hera.proto.Web.AddCustomerReminderTagRequest,
      com.elarian.hera.proto.Web.TagCommandReply> METHOD_ADD_CUSTOMER_REMINDER_BY_TAG =
      io.grpc.MethodDescriptor.<com.elarian.hera.proto.Web.AddCustomerReminderTagRequest, com.elarian.hera.proto.Web.TagCommandReply>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.elarian.hera.proto.GrpcWebService", "AddCustomerReminderByTag"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.elarian.hera.proto.Web.AddCustomerReminderTagRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.elarian.hera.proto.Web.TagCommandReply.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.elarian.hera.proto.Web.CancelCustomerReminderRequest,
      com.elarian.hera.proto.Web.UpdateCustomerStateReply> METHOD_CANCEL_CUSTOMER_REMINDER =
      io.grpc.MethodDescriptor.<com.elarian.hera.proto.Web.CancelCustomerReminderRequest, com.elarian.hera.proto.Web.UpdateCustomerStateReply>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.elarian.hera.proto.GrpcWebService", "CancelCustomerReminder"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.elarian.hera.proto.Web.CancelCustomerReminderRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.elarian.hera.proto.Web.UpdateCustomerStateReply.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.elarian.hera.proto.Web.CancelCustomerReminderTagRequest,
      com.elarian.hera.proto.Web.TagCommandReply> METHOD_CANCEL_CUSTOMER_REMINDER_BY_TAG =
      io.grpc.MethodDescriptor.<com.elarian.hera.proto.Web.CancelCustomerReminderTagRequest, com.elarian.hera.proto.Web.TagCommandReply>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.elarian.hera.proto.GrpcWebService", "CancelCustomerReminderByTag"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.elarian.hera.proto.Web.CancelCustomerReminderTagRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.elarian.hera.proto.Web.TagCommandReply.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.elarian.hera.proto.Web.UpdateCustomerTagRequest,
      com.elarian.hera.proto.Web.UpdateCustomerStateReply> METHOD_UPDATE_CUSTOMER_TAG =
      io.grpc.MethodDescriptor.<com.elarian.hera.proto.Web.UpdateCustomerTagRequest, com.elarian.hera.proto.Web.UpdateCustomerStateReply>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.elarian.hera.proto.GrpcWebService", "UpdateCustomerTag"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.elarian.hera.proto.Web.UpdateCustomerTagRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.elarian.hera.proto.Web.UpdateCustomerStateReply.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.elarian.hera.proto.Web.DeleteCustomerTagRequest,
      com.elarian.hera.proto.Web.UpdateCustomerStateReply> METHOD_DELETE_CUSTOMER_TAG =
      io.grpc.MethodDescriptor.<com.elarian.hera.proto.Web.DeleteCustomerTagRequest, com.elarian.hera.proto.Web.UpdateCustomerStateReply>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.elarian.hera.proto.GrpcWebService", "DeleteCustomerTag"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.elarian.hera.proto.Web.DeleteCustomerTagRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.elarian.hera.proto.Web.UpdateCustomerStateReply.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.elarian.hera.proto.Web.UpdateCustomerSecondaryIdRequest,
      com.elarian.hera.proto.Web.UpdateCustomerStateReply> METHOD_UPDATE_CUSTOMER_SECONDARY_ID =
      io.grpc.MethodDescriptor.<com.elarian.hera.proto.Web.UpdateCustomerSecondaryIdRequest, com.elarian.hera.proto.Web.UpdateCustomerStateReply>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.elarian.hera.proto.GrpcWebService", "UpdateCustomerSecondaryId"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.elarian.hera.proto.Web.UpdateCustomerSecondaryIdRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.elarian.hera.proto.Web.UpdateCustomerStateReply.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.elarian.hera.proto.Web.DeleteCustomerSecondaryIdRequest,
      com.elarian.hera.proto.Web.UpdateCustomerStateReply> METHOD_DELETE_CUSTOMER_SECONDARY_ID =
      io.grpc.MethodDescriptor.<com.elarian.hera.proto.Web.DeleteCustomerSecondaryIdRequest, com.elarian.hera.proto.Web.UpdateCustomerStateReply>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.elarian.hera.proto.GrpcWebService", "DeleteCustomerSecondaryId"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.elarian.hera.proto.Web.DeleteCustomerSecondaryIdRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.elarian.hera.proto.Web.UpdateCustomerStateReply.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.elarian.hera.proto.Web.UpdateCustomerMetadataRequest,
      com.elarian.hera.proto.Web.UpdateCustomerStateReply> METHOD_UPDATE_CUSTOMER_METADATA =
      io.grpc.MethodDescriptor.<com.elarian.hera.proto.Web.UpdateCustomerMetadataRequest, com.elarian.hera.proto.Web.UpdateCustomerStateReply>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.elarian.hera.proto.GrpcWebService", "UpdateCustomerMetadata"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.elarian.hera.proto.Web.UpdateCustomerMetadataRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.elarian.hera.proto.Web.UpdateCustomerStateReply.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.elarian.hera.proto.Web.DeleteCustomerMetadataRequest,
      com.elarian.hera.proto.Web.UpdateCustomerStateReply> METHOD_DELETE_CUSTOMER_METADATA =
      io.grpc.MethodDescriptor.<com.elarian.hera.proto.Web.DeleteCustomerMetadataRequest, com.elarian.hera.proto.Web.UpdateCustomerStateReply>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.elarian.hera.proto.GrpcWebService", "DeleteCustomerMetadata"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.elarian.hera.proto.Web.DeleteCustomerMetadataRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.elarian.hera.proto.Web.UpdateCustomerStateReply.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.elarian.hera.proto.Web.SendMessageRequest,
      com.elarian.hera.proto.Web.SendMessageReply> METHOD_SEND_MESSAGE =
      io.grpc.MethodDescriptor.<com.elarian.hera.proto.Web.SendMessageRequest, com.elarian.hera.proto.Web.SendMessageReply>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.elarian.hera.proto.GrpcWebService", "SendMessage"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.elarian.hera.proto.Web.SendMessageRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.elarian.hera.proto.Web.SendMessageReply.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.elarian.hera.proto.Web.SendMessageTagRequest,
      com.elarian.hera.proto.Web.TagCommandReply> METHOD_SEND_MESSAGE_BY_TAG =
      io.grpc.MethodDescriptor.<com.elarian.hera.proto.Web.SendMessageTagRequest, com.elarian.hera.proto.Web.TagCommandReply>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.elarian.hera.proto.GrpcWebService", "SendMessageByTag"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.elarian.hera.proto.Web.SendMessageTagRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.elarian.hera.proto.Web.TagCommandReply.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.elarian.hera.proto.Web.ReplyToMessageRequest,
      com.elarian.hera.proto.Web.SendMessageReply> METHOD_REPLY_TO_MESSAGE =
      io.grpc.MethodDescriptor.<com.elarian.hera.proto.Web.ReplyToMessageRequest, com.elarian.hera.proto.Web.SendMessageReply>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.elarian.hera.proto.GrpcWebService", "ReplyToMessage"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.elarian.hera.proto.Web.ReplyToMessageRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.elarian.hera.proto.Web.SendMessageReply.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.elarian.hera.proto.Web.MessagingConsentRequest,
      com.elarian.hera.proto.Web.MessagingConsentReply> METHOD_MESSAGING_CONSENT =
      io.grpc.MethodDescriptor.<com.elarian.hera.proto.Web.MessagingConsentRequest, com.elarian.hera.proto.Web.MessagingConsentReply>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.elarian.hera.proto.GrpcWebService", "MessagingConsent"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.elarian.hera.proto.Web.MessagingConsentRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.elarian.hera.proto.Web.MessagingConsentReply.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.elarian.hera.proto.Web.SendPaymentRequest,
      com.elarian.hera.proto.Web.SendPaymentReply> METHOD_SEND_PAYMENT =
      io.grpc.MethodDescriptor.<com.elarian.hera.proto.Web.SendPaymentRequest, com.elarian.hera.proto.Web.SendPaymentReply>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.elarian.hera.proto.GrpcWebService", "SendPayment"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.elarian.hera.proto.Web.SendPaymentRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.elarian.hera.proto.Web.SendPaymentReply.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.elarian.hera.proto.Web.CheckoutPaymentRequest,
      com.elarian.hera.proto.Web.CheckoutPaymentReply> METHOD_CHECKOUT_PAYMENT =
      io.grpc.MethodDescriptor.<com.elarian.hera.proto.Web.CheckoutPaymentRequest, com.elarian.hera.proto.Web.CheckoutPaymentReply>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.elarian.hera.proto.GrpcWebService", "CheckoutPayment"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.elarian.hera.proto.Web.CheckoutPaymentRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.elarian.hera.proto.Web.CheckoutPaymentReply.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.elarian.hera.proto.Web.MakeVoiceCallRequest,
      com.elarian.hera.proto.Web.MakeVoiceCallReply> METHOD_MAKE_VOICE_CALL =
      io.grpc.MethodDescriptor.<com.elarian.hera.proto.Web.MakeVoiceCallRequest, com.elarian.hera.proto.Web.MakeVoiceCallReply>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.elarian.hera.proto.GrpcWebService", "MakeVoiceCall"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.elarian.hera.proto.Web.MakeVoiceCallRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.elarian.hera.proto.Web.MakeVoiceCallReply.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.elarian.hera.proto.Web.StreamNotificationRequest,
      com.elarian.hera.proto.Web.WebhookRequest> METHOD_STREAM_NOTIFICATIONS =
      io.grpc.MethodDescriptor.<com.elarian.hera.proto.Web.StreamNotificationRequest, com.elarian.hera.proto.Web.WebhookRequest>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
          .setFullMethodName(generateFullMethodName(
              "com.elarian.hera.proto.GrpcWebService", "StreamNotifications"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.elarian.hera.proto.Web.StreamNotificationRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.elarian.hera.proto.Web.WebhookRequest.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.elarian.hera.proto.Web.WebhookResponse,
      com.elarian.hera.proto.Web.WebhookResponseReply> METHOD_SEND_WEBHOOK_RESPONSE =
      io.grpc.MethodDescriptor.<com.elarian.hera.proto.Web.WebhookResponse, com.elarian.hera.proto.Web.WebhookResponseReply>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.elarian.hera.proto.GrpcWebService", "SendWebhookResponse"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.elarian.hera.proto.Web.WebhookResponse.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.elarian.hera.proto.Web.WebhookResponseReply.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static GrpcWebServiceStub newStub(io.grpc.Channel channel) {
    return new GrpcWebServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GrpcWebServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new GrpcWebServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static GrpcWebServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new GrpcWebServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class GrpcWebServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void authToken(com.elarian.hera.proto.Web.AuthTokenRequest request,
        io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.AuthTokenReply> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_AUTH_TOKEN, responseObserver);
    }

    /**
     */
    public void getCustomerState(com.elarian.hera.proto.Web.GetCustomerStateRequest request,
        io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.GetCustomerStateReply> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_CUSTOMER_STATE, responseObserver);
    }

    /**
     */
    public void adoptCustomerState(com.elarian.hera.proto.Web.AdoptCustomerStateRequest request,
        io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.UpdateCustomerStateReply> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_ADOPT_CUSTOMER_STATE, responseObserver);
    }

    /**
     */
    public void addCustomerReminder(com.elarian.hera.proto.Web.AddCustomerReminderRequest request,
        io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.UpdateCustomerStateReply> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_ADD_CUSTOMER_REMINDER, responseObserver);
    }

    /**
     */
    public void addCustomerReminderByTag(com.elarian.hera.proto.Web.AddCustomerReminderTagRequest request,
        io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.TagCommandReply> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_ADD_CUSTOMER_REMINDER_BY_TAG, responseObserver);
    }

    /**
     */
    public void cancelCustomerReminder(com.elarian.hera.proto.Web.CancelCustomerReminderRequest request,
        io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.UpdateCustomerStateReply> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_CANCEL_CUSTOMER_REMINDER, responseObserver);
    }

    /**
     */
    public void cancelCustomerReminderByTag(com.elarian.hera.proto.Web.CancelCustomerReminderTagRequest request,
        io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.TagCommandReply> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_CANCEL_CUSTOMER_REMINDER_BY_TAG, responseObserver);
    }

    /**
     */
    public void updateCustomerTag(com.elarian.hera.proto.Web.UpdateCustomerTagRequest request,
        io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.UpdateCustomerStateReply> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_UPDATE_CUSTOMER_TAG, responseObserver);
    }

    /**
     */
    public void deleteCustomerTag(com.elarian.hera.proto.Web.DeleteCustomerTagRequest request,
        io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.UpdateCustomerStateReply> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_DELETE_CUSTOMER_TAG, responseObserver);
    }

    /**
     */
    public void updateCustomerSecondaryId(com.elarian.hera.proto.Web.UpdateCustomerSecondaryIdRequest request,
        io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.UpdateCustomerStateReply> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_UPDATE_CUSTOMER_SECONDARY_ID, responseObserver);
    }

    /**
     */
    public void deleteCustomerSecondaryId(com.elarian.hera.proto.Web.DeleteCustomerSecondaryIdRequest request,
        io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.UpdateCustomerStateReply> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_DELETE_CUSTOMER_SECONDARY_ID, responseObserver);
    }

    /**
     */
    public void updateCustomerMetadata(com.elarian.hera.proto.Web.UpdateCustomerMetadataRequest request,
        io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.UpdateCustomerStateReply> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_UPDATE_CUSTOMER_METADATA, responseObserver);
    }

    /**
     */
    public void deleteCustomerMetadata(com.elarian.hera.proto.Web.DeleteCustomerMetadataRequest request,
        io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.UpdateCustomerStateReply> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_DELETE_CUSTOMER_METADATA, responseObserver);
    }

    /**
     */
    public void sendMessage(com.elarian.hera.proto.Web.SendMessageRequest request,
        io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.SendMessageReply> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SEND_MESSAGE, responseObserver);
    }

    /**
     */
    public void sendMessageByTag(com.elarian.hera.proto.Web.SendMessageTagRequest request,
        io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.TagCommandReply> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SEND_MESSAGE_BY_TAG, responseObserver);
    }

    /**
     */
    public void replyToMessage(com.elarian.hera.proto.Web.ReplyToMessageRequest request,
        io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.SendMessageReply> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_REPLY_TO_MESSAGE, responseObserver);
    }

    /**
     */
    public void messagingConsent(com.elarian.hera.proto.Web.MessagingConsentRequest request,
        io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.MessagingConsentReply> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_MESSAGING_CONSENT, responseObserver);
    }

    /**
     */
    public void sendPayment(com.elarian.hera.proto.Web.SendPaymentRequest request,
        io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.SendPaymentReply> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SEND_PAYMENT, responseObserver);
    }

    /**
     */
    public void checkoutPayment(com.elarian.hera.proto.Web.CheckoutPaymentRequest request,
        io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.CheckoutPaymentReply> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_CHECKOUT_PAYMENT, responseObserver);
    }

    /**
     */
    public void makeVoiceCall(com.elarian.hera.proto.Web.MakeVoiceCallRequest request,
        io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.MakeVoiceCallReply> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_MAKE_VOICE_CALL, responseObserver);
    }

    /**
     */
    public void streamNotifications(com.elarian.hera.proto.Web.StreamNotificationRequest request,
        io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.WebhookRequest> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_STREAM_NOTIFICATIONS, responseObserver);
    }

    /**
     */
    public void sendWebhookResponse(com.elarian.hera.proto.Web.WebhookResponse request,
        io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.WebhookResponseReply> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SEND_WEBHOOK_RESPONSE, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_AUTH_TOKEN,
            asyncUnaryCall(
              new MethodHandlers<
                com.elarian.hera.proto.Web.AuthTokenRequest,
                com.elarian.hera.proto.Web.AuthTokenReply>(
                  this, METHODID_AUTH_TOKEN)))
          .addMethod(
            METHOD_GET_CUSTOMER_STATE,
            asyncUnaryCall(
              new MethodHandlers<
                com.elarian.hera.proto.Web.GetCustomerStateRequest,
                com.elarian.hera.proto.Web.GetCustomerStateReply>(
                  this, METHODID_GET_CUSTOMER_STATE)))
          .addMethod(
            METHOD_ADOPT_CUSTOMER_STATE,
            asyncUnaryCall(
              new MethodHandlers<
                com.elarian.hera.proto.Web.AdoptCustomerStateRequest,
                com.elarian.hera.proto.Web.UpdateCustomerStateReply>(
                  this, METHODID_ADOPT_CUSTOMER_STATE)))
          .addMethod(
            METHOD_ADD_CUSTOMER_REMINDER,
            asyncUnaryCall(
              new MethodHandlers<
                com.elarian.hera.proto.Web.AddCustomerReminderRequest,
                com.elarian.hera.proto.Web.UpdateCustomerStateReply>(
                  this, METHODID_ADD_CUSTOMER_REMINDER)))
          .addMethod(
            METHOD_ADD_CUSTOMER_REMINDER_BY_TAG,
            asyncUnaryCall(
              new MethodHandlers<
                com.elarian.hera.proto.Web.AddCustomerReminderTagRequest,
                com.elarian.hera.proto.Web.TagCommandReply>(
                  this, METHODID_ADD_CUSTOMER_REMINDER_BY_TAG)))
          .addMethod(
            METHOD_CANCEL_CUSTOMER_REMINDER,
            asyncUnaryCall(
              new MethodHandlers<
                com.elarian.hera.proto.Web.CancelCustomerReminderRequest,
                com.elarian.hera.proto.Web.UpdateCustomerStateReply>(
                  this, METHODID_CANCEL_CUSTOMER_REMINDER)))
          .addMethod(
            METHOD_CANCEL_CUSTOMER_REMINDER_BY_TAG,
            asyncUnaryCall(
              new MethodHandlers<
                com.elarian.hera.proto.Web.CancelCustomerReminderTagRequest,
                com.elarian.hera.proto.Web.TagCommandReply>(
                  this, METHODID_CANCEL_CUSTOMER_REMINDER_BY_TAG)))
          .addMethod(
            METHOD_UPDATE_CUSTOMER_TAG,
            asyncUnaryCall(
              new MethodHandlers<
                com.elarian.hera.proto.Web.UpdateCustomerTagRequest,
                com.elarian.hera.proto.Web.UpdateCustomerStateReply>(
                  this, METHODID_UPDATE_CUSTOMER_TAG)))
          .addMethod(
            METHOD_DELETE_CUSTOMER_TAG,
            asyncUnaryCall(
              new MethodHandlers<
                com.elarian.hera.proto.Web.DeleteCustomerTagRequest,
                com.elarian.hera.proto.Web.UpdateCustomerStateReply>(
                  this, METHODID_DELETE_CUSTOMER_TAG)))
          .addMethod(
            METHOD_UPDATE_CUSTOMER_SECONDARY_ID,
            asyncUnaryCall(
              new MethodHandlers<
                com.elarian.hera.proto.Web.UpdateCustomerSecondaryIdRequest,
                com.elarian.hera.proto.Web.UpdateCustomerStateReply>(
                  this, METHODID_UPDATE_CUSTOMER_SECONDARY_ID)))
          .addMethod(
            METHOD_DELETE_CUSTOMER_SECONDARY_ID,
            asyncUnaryCall(
              new MethodHandlers<
                com.elarian.hera.proto.Web.DeleteCustomerSecondaryIdRequest,
                com.elarian.hera.proto.Web.UpdateCustomerStateReply>(
                  this, METHODID_DELETE_CUSTOMER_SECONDARY_ID)))
          .addMethod(
            METHOD_UPDATE_CUSTOMER_METADATA,
            asyncUnaryCall(
              new MethodHandlers<
                com.elarian.hera.proto.Web.UpdateCustomerMetadataRequest,
                com.elarian.hera.proto.Web.UpdateCustomerStateReply>(
                  this, METHODID_UPDATE_CUSTOMER_METADATA)))
          .addMethod(
            METHOD_DELETE_CUSTOMER_METADATA,
            asyncUnaryCall(
              new MethodHandlers<
                com.elarian.hera.proto.Web.DeleteCustomerMetadataRequest,
                com.elarian.hera.proto.Web.UpdateCustomerStateReply>(
                  this, METHODID_DELETE_CUSTOMER_METADATA)))
          .addMethod(
            METHOD_SEND_MESSAGE,
            asyncUnaryCall(
              new MethodHandlers<
                com.elarian.hera.proto.Web.SendMessageRequest,
                com.elarian.hera.proto.Web.SendMessageReply>(
                  this, METHODID_SEND_MESSAGE)))
          .addMethod(
            METHOD_SEND_MESSAGE_BY_TAG,
            asyncUnaryCall(
              new MethodHandlers<
                com.elarian.hera.proto.Web.SendMessageTagRequest,
                com.elarian.hera.proto.Web.TagCommandReply>(
                  this, METHODID_SEND_MESSAGE_BY_TAG)))
          .addMethod(
            METHOD_REPLY_TO_MESSAGE,
            asyncUnaryCall(
              new MethodHandlers<
                com.elarian.hera.proto.Web.ReplyToMessageRequest,
                com.elarian.hera.proto.Web.SendMessageReply>(
                  this, METHODID_REPLY_TO_MESSAGE)))
          .addMethod(
            METHOD_MESSAGING_CONSENT,
            asyncUnaryCall(
              new MethodHandlers<
                com.elarian.hera.proto.Web.MessagingConsentRequest,
                com.elarian.hera.proto.Web.MessagingConsentReply>(
                  this, METHODID_MESSAGING_CONSENT)))
          .addMethod(
            METHOD_SEND_PAYMENT,
            asyncUnaryCall(
              new MethodHandlers<
                com.elarian.hera.proto.Web.SendPaymentRequest,
                com.elarian.hera.proto.Web.SendPaymentReply>(
                  this, METHODID_SEND_PAYMENT)))
          .addMethod(
            METHOD_CHECKOUT_PAYMENT,
            asyncUnaryCall(
              new MethodHandlers<
                com.elarian.hera.proto.Web.CheckoutPaymentRequest,
                com.elarian.hera.proto.Web.CheckoutPaymentReply>(
                  this, METHODID_CHECKOUT_PAYMENT)))
          .addMethod(
            METHOD_MAKE_VOICE_CALL,
            asyncUnaryCall(
              new MethodHandlers<
                com.elarian.hera.proto.Web.MakeVoiceCallRequest,
                com.elarian.hera.proto.Web.MakeVoiceCallReply>(
                  this, METHODID_MAKE_VOICE_CALL)))
          .addMethod(
            METHOD_STREAM_NOTIFICATIONS,
            asyncServerStreamingCall(
              new MethodHandlers<
                com.elarian.hera.proto.Web.StreamNotificationRequest,
                com.elarian.hera.proto.Web.WebhookRequest>(
                  this, METHODID_STREAM_NOTIFICATIONS)))
          .addMethod(
            METHOD_SEND_WEBHOOK_RESPONSE,
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
  public static final class GrpcWebServiceStub extends io.grpc.stub.AbstractStub<GrpcWebServiceStub> {
    private GrpcWebServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GrpcWebServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GrpcWebServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GrpcWebServiceStub(channel, callOptions);
    }

    /**
     */
    public void authToken(com.elarian.hera.proto.Web.AuthTokenRequest request,
        io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.AuthTokenReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_AUTH_TOKEN, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getCustomerState(com.elarian.hera.proto.Web.GetCustomerStateRequest request,
        io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.GetCustomerStateReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_CUSTOMER_STATE, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void adoptCustomerState(com.elarian.hera.proto.Web.AdoptCustomerStateRequest request,
        io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.UpdateCustomerStateReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_ADOPT_CUSTOMER_STATE, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addCustomerReminder(com.elarian.hera.proto.Web.AddCustomerReminderRequest request,
        io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.UpdateCustomerStateReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_ADD_CUSTOMER_REMINDER, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addCustomerReminderByTag(com.elarian.hera.proto.Web.AddCustomerReminderTagRequest request,
        io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.TagCommandReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_ADD_CUSTOMER_REMINDER_BY_TAG, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void cancelCustomerReminder(com.elarian.hera.proto.Web.CancelCustomerReminderRequest request,
        io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.UpdateCustomerStateReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_CANCEL_CUSTOMER_REMINDER, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void cancelCustomerReminderByTag(com.elarian.hera.proto.Web.CancelCustomerReminderTagRequest request,
        io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.TagCommandReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_CANCEL_CUSTOMER_REMINDER_BY_TAG, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateCustomerTag(com.elarian.hera.proto.Web.UpdateCustomerTagRequest request,
        io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.UpdateCustomerStateReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_UPDATE_CUSTOMER_TAG, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteCustomerTag(com.elarian.hera.proto.Web.DeleteCustomerTagRequest request,
        io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.UpdateCustomerStateReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_DELETE_CUSTOMER_TAG, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateCustomerSecondaryId(com.elarian.hera.proto.Web.UpdateCustomerSecondaryIdRequest request,
        io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.UpdateCustomerStateReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_UPDATE_CUSTOMER_SECONDARY_ID, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteCustomerSecondaryId(com.elarian.hera.proto.Web.DeleteCustomerSecondaryIdRequest request,
        io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.UpdateCustomerStateReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_DELETE_CUSTOMER_SECONDARY_ID, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateCustomerMetadata(com.elarian.hera.proto.Web.UpdateCustomerMetadataRequest request,
        io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.UpdateCustomerStateReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_UPDATE_CUSTOMER_METADATA, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteCustomerMetadata(com.elarian.hera.proto.Web.DeleteCustomerMetadataRequest request,
        io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.UpdateCustomerStateReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_DELETE_CUSTOMER_METADATA, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void sendMessage(com.elarian.hera.proto.Web.SendMessageRequest request,
        io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.SendMessageReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SEND_MESSAGE, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void sendMessageByTag(com.elarian.hera.proto.Web.SendMessageTagRequest request,
        io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.TagCommandReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SEND_MESSAGE_BY_TAG, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void replyToMessage(com.elarian.hera.proto.Web.ReplyToMessageRequest request,
        io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.SendMessageReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_REPLY_TO_MESSAGE, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void messagingConsent(com.elarian.hera.proto.Web.MessagingConsentRequest request,
        io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.MessagingConsentReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_MESSAGING_CONSENT, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void sendPayment(com.elarian.hera.proto.Web.SendPaymentRequest request,
        io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.SendPaymentReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SEND_PAYMENT, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void checkoutPayment(com.elarian.hera.proto.Web.CheckoutPaymentRequest request,
        io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.CheckoutPaymentReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_CHECKOUT_PAYMENT, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void makeVoiceCall(com.elarian.hera.proto.Web.MakeVoiceCallRequest request,
        io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.MakeVoiceCallReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_MAKE_VOICE_CALL, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void streamNotifications(com.elarian.hera.proto.Web.StreamNotificationRequest request,
        io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.WebhookRequest> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(METHOD_STREAM_NOTIFICATIONS, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void sendWebhookResponse(com.elarian.hera.proto.Web.WebhookResponse request,
        io.grpc.stub.StreamObserver<com.elarian.hera.proto.Web.WebhookResponseReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SEND_WEBHOOK_RESPONSE, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class GrpcWebServiceBlockingStub extends io.grpc.stub.AbstractStub<GrpcWebServiceBlockingStub> {
    private GrpcWebServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GrpcWebServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GrpcWebServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GrpcWebServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.elarian.hera.proto.Web.AuthTokenReply authToken(com.elarian.hera.proto.Web.AuthTokenRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_AUTH_TOKEN, getCallOptions(), request);
    }

    /**
     */
    public com.elarian.hera.proto.Web.GetCustomerStateReply getCustomerState(com.elarian.hera.proto.Web.GetCustomerStateRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_CUSTOMER_STATE, getCallOptions(), request);
    }

    /**
     */
    public com.elarian.hera.proto.Web.UpdateCustomerStateReply adoptCustomerState(com.elarian.hera.proto.Web.AdoptCustomerStateRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_ADOPT_CUSTOMER_STATE, getCallOptions(), request);
    }

    /**
     */
    public com.elarian.hera.proto.Web.UpdateCustomerStateReply addCustomerReminder(com.elarian.hera.proto.Web.AddCustomerReminderRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_ADD_CUSTOMER_REMINDER, getCallOptions(), request);
    }

    /**
     */
    public com.elarian.hera.proto.Web.TagCommandReply addCustomerReminderByTag(com.elarian.hera.proto.Web.AddCustomerReminderTagRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_ADD_CUSTOMER_REMINDER_BY_TAG, getCallOptions(), request);
    }

    /**
     */
    public com.elarian.hera.proto.Web.UpdateCustomerStateReply cancelCustomerReminder(com.elarian.hera.proto.Web.CancelCustomerReminderRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_CANCEL_CUSTOMER_REMINDER, getCallOptions(), request);
    }

    /**
     */
    public com.elarian.hera.proto.Web.TagCommandReply cancelCustomerReminderByTag(com.elarian.hera.proto.Web.CancelCustomerReminderTagRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_CANCEL_CUSTOMER_REMINDER_BY_TAG, getCallOptions(), request);
    }

    /**
     */
    public com.elarian.hera.proto.Web.UpdateCustomerStateReply updateCustomerTag(com.elarian.hera.proto.Web.UpdateCustomerTagRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_UPDATE_CUSTOMER_TAG, getCallOptions(), request);
    }

    /**
     */
    public com.elarian.hera.proto.Web.UpdateCustomerStateReply deleteCustomerTag(com.elarian.hera.proto.Web.DeleteCustomerTagRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_DELETE_CUSTOMER_TAG, getCallOptions(), request);
    }

    /**
     */
    public com.elarian.hera.proto.Web.UpdateCustomerStateReply updateCustomerSecondaryId(com.elarian.hera.proto.Web.UpdateCustomerSecondaryIdRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_UPDATE_CUSTOMER_SECONDARY_ID, getCallOptions(), request);
    }

    /**
     */
    public com.elarian.hera.proto.Web.UpdateCustomerStateReply deleteCustomerSecondaryId(com.elarian.hera.proto.Web.DeleteCustomerSecondaryIdRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_DELETE_CUSTOMER_SECONDARY_ID, getCallOptions(), request);
    }

    /**
     */
    public com.elarian.hera.proto.Web.UpdateCustomerStateReply updateCustomerMetadata(com.elarian.hera.proto.Web.UpdateCustomerMetadataRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_UPDATE_CUSTOMER_METADATA, getCallOptions(), request);
    }

    /**
     */
    public com.elarian.hera.proto.Web.UpdateCustomerStateReply deleteCustomerMetadata(com.elarian.hera.proto.Web.DeleteCustomerMetadataRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_DELETE_CUSTOMER_METADATA, getCallOptions(), request);
    }

    /**
     */
    public com.elarian.hera.proto.Web.SendMessageReply sendMessage(com.elarian.hera.proto.Web.SendMessageRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SEND_MESSAGE, getCallOptions(), request);
    }

    /**
     */
    public com.elarian.hera.proto.Web.TagCommandReply sendMessageByTag(com.elarian.hera.proto.Web.SendMessageTagRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SEND_MESSAGE_BY_TAG, getCallOptions(), request);
    }

    /**
     */
    public com.elarian.hera.proto.Web.SendMessageReply replyToMessage(com.elarian.hera.proto.Web.ReplyToMessageRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_REPLY_TO_MESSAGE, getCallOptions(), request);
    }

    /**
     */
    public com.elarian.hera.proto.Web.MessagingConsentReply messagingConsent(com.elarian.hera.proto.Web.MessagingConsentRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_MESSAGING_CONSENT, getCallOptions(), request);
    }

    /**
     */
    public com.elarian.hera.proto.Web.SendPaymentReply sendPayment(com.elarian.hera.proto.Web.SendPaymentRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SEND_PAYMENT, getCallOptions(), request);
    }

    /**
     */
    public com.elarian.hera.proto.Web.CheckoutPaymentReply checkoutPayment(com.elarian.hera.proto.Web.CheckoutPaymentRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_CHECKOUT_PAYMENT, getCallOptions(), request);
    }

    /**
     */
    public com.elarian.hera.proto.Web.MakeVoiceCallReply makeVoiceCall(com.elarian.hera.proto.Web.MakeVoiceCallRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_MAKE_VOICE_CALL, getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<com.elarian.hera.proto.Web.WebhookRequest> streamNotifications(
        com.elarian.hera.proto.Web.StreamNotificationRequest request) {
      return blockingServerStreamingCall(
          getChannel(), METHOD_STREAM_NOTIFICATIONS, getCallOptions(), request);
    }

    /**
     */
    public com.elarian.hera.proto.Web.WebhookResponseReply sendWebhookResponse(com.elarian.hera.proto.Web.WebhookResponse request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SEND_WEBHOOK_RESPONSE, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class GrpcWebServiceFutureStub extends io.grpc.stub.AbstractStub<GrpcWebServiceFutureStub> {
    private GrpcWebServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GrpcWebServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GrpcWebServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GrpcWebServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.elarian.hera.proto.Web.AuthTokenReply> authToken(
        com.elarian.hera.proto.Web.AuthTokenRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_AUTH_TOKEN, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.elarian.hera.proto.Web.GetCustomerStateReply> getCustomerState(
        com.elarian.hera.proto.Web.GetCustomerStateRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_CUSTOMER_STATE, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.elarian.hera.proto.Web.UpdateCustomerStateReply> adoptCustomerState(
        com.elarian.hera.proto.Web.AdoptCustomerStateRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_ADOPT_CUSTOMER_STATE, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.elarian.hera.proto.Web.UpdateCustomerStateReply> addCustomerReminder(
        com.elarian.hera.proto.Web.AddCustomerReminderRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_ADD_CUSTOMER_REMINDER, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.elarian.hera.proto.Web.TagCommandReply> addCustomerReminderByTag(
        com.elarian.hera.proto.Web.AddCustomerReminderTagRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_ADD_CUSTOMER_REMINDER_BY_TAG, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.elarian.hera.proto.Web.UpdateCustomerStateReply> cancelCustomerReminder(
        com.elarian.hera.proto.Web.CancelCustomerReminderRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_CANCEL_CUSTOMER_REMINDER, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.elarian.hera.proto.Web.TagCommandReply> cancelCustomerReminderByTag(
        com.elarian.hera.proto.Web.CancelCustomerReminderTagRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_CANCEL_CUSTOMER_REMINDER_BY_TAG, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.elarian.hera.proto.Web.UpdateCustomerStateReply> updateCustomerTag(
        com.elarian.hera.proto.Web.UpdateCustomerTagRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_UPDATE_CUSTOMER_TAG, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.elarian.hera.proto.Web.UpdateCustomerStateReply> deleteCustomerTag(
        com.elarian.hera.proto.Web.DeleteCustomerTagRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_DELETE_CUSTOMER_TAG, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.elarian.hera.proto.Web.UpdateCustomerStateReply> updateCustomerSecondaryId(
        com.elarian.hera.proto.Web.UpdateCustomerSecondaryIdRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_UPDATE_CUSTOMER_SECONDARY_ID, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.elarian.hera.proto.Web.UpdateCustomerStateReply> deleteCustomerSecondaryId(
        com.elarian.hera.proto.Web.DeleteCustomerSecondaryIdRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_DELETE_CUSTOMER_SECONDARY_ID, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.elarian.hera.proto.Web.UpdateCustomerStateReply> updateCustomerMetadata(
        com.elarian.hera.proto.Web.UpdateCustomerMetadataRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_UPDATE_CUSTOMER_METADATA, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.elarian.hera.proto.Web.UpdateCustomerStateReply> deleteCustomerMetadata(
        com.elarian.hera.proto.Web.DeleteCustomerMetadataRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_DELETE_CUSTOMER_METADATA, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.elarian.hera.proto.Web.SendMessageReply> sendMessage(
        com.elarian.hera.proto.Web.SendMessageRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SEND_MESSAGE, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.elarian.hera.proto.Web.TagCommandReply> sendMessageByTag(
        com.elarian.hera.proto.Web.SendMessageTagRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SEND_MESSAGE_BY_TAG, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.elarian.hera.proto.Web.SendMessageReply> replyToMessage(
        com.elarian.hera.proto.Web.ReplyToMessageRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_REPLY_TO_MESSAGE, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.elarian.hera.proto.Web.MessagingConsentReply> messagingConsent(
        com.elarian.hera.proto.Web.MessagingConsentRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_MESSAGING_CONSENT, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.elarian.hera.proto.Web.SendPaymentReply> sendPayment(
        com.elarian.hera.proto.Web.SendPaymentRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SEND_PAYMENT, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.elarian.hera.proto.Web.CheckoutPaymentReply> checkoutPayment(
        com.elarian.hera.proto.Web.CheckoutPaymentRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_CHECKOUT_PAYMENT, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.elarian.hera.proto.Web.MakeVoiceCallReply> makeVoiceCall(
        com.elarian.hera.proto.Web.MakeVoiceCallRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_MAKE_VOICE_CALL, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.elarian.hera.proto.Web.WebhookResponseReply> sendWebhookResponse(
        com.elarian.hera.proto.Web.WebhookResponse request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SEND_WEBHOOK_RESPONSE, getCallOptions()), request);
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

  private static final class GrpcWebServiceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.elarian.hera.proto.Web.getDescriptor();
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
              .setSchemaDescriptor(new GrpcWebServiceDescriptorSupplier())
              .addMethod(METHOD_AUTH_TOKEN)
              .addMethod(METHOD_GET_CUSTOMER_STATE)
              .addMethod(METHOD_ADOPT_CUSTOMER_STATE)
              .addMethod(METHOD_ADD_CUSTOMER_REMINDER)
              .addMethod(METHOD_ADD_CUSTOMER_REMINDER_BY_TAG)
              .addMethod(METHOD_CANCEL_CUSTOMER_REMINDER)
              .addMethod(METHOD_CANCEL_CUSTOMER_REMINDER_BY_TAG)
              .addMethod(METHOD_UPDATE_CUSTOMER_TAG)
              .addMethod(METHOD_DELETE_CUSTOMER_TAG)
              .addMethod(METHOD_UPDATE_CUSTOMER_SECONDARY_ID)
              .addMethod(METHOD_DELETE_CUSTOMER_SECONDARY_ID)
              .addMethod(METHOD_UPDATE_CUSTOMER_METADATA)
              .addMethod(METHOD_DELETE_CUSTOMER_METADATA)
              .addMethod(METHOD_SEND_MESSAGE)
              .addMethod(METHOD_SEND_MESSAGE_BY_TAG)
              .addMethod(METHOD_REPLY_TO_MESSAGE)
              .addMethod(METHOD_MESSAGING_CONSENT)
              .addMethod(METHOD_SEND_PAYMENT)
              .addMethod(METHOD_CHECKOUT_PAYMENT)
              .addMethod(METHOD_MAKE_VOICE_CALL)
              .addMethod(METHOD_STREAM_NOTIFICATIONS)
              .addMethod(METHOD_SEND_WEBHOOK_RESPONSE)
              .build();
        }
      }
    }
    return result;
  }
}
