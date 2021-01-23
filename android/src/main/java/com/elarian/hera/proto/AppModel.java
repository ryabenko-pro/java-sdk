// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: app_model.proto

package com.elarian.hera.proto;

public final class AppModel {
  private AppModel() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }
  public interface CustomerReminderOrBuilder extends
      // @@protoc_insertion_point(interface_extends:com.elarian.hera.proto.CustomerReminder)
      com.google.protobuf.MessageLiteOrBuilder {

    /**
     * <code>string key = 1;</code>
     * @return The key.
     */
    java.lang.String getKey();
    /**
     * <code>string key = 1;</code>
     * @return The bytes for key.
     */
    com.google.protobuf.ByteString
        getKeyBytes();

    /**
     * <code>.google.protobuf.Timestamp remind_at = 2;</code>
     * @return Whether the remindAt field is set.
     */
    boolean hasRemindAt();
    /**
     * <code>.google.protobuf.Timestamp remind_at = 2;</code>
     * @return The remindAt.
     */
    com.google.protobuf.Timestamp getRemindAt();

    /**
     * <code>.google.protobuf.Duration interval = 3;</code>
     * @return Whether the interval field is set.
     */
    boolean hasInterval();
    /**
     * <code>.google.protobuf.Duration interval = 3;</code>
     * @return The interval.
     */
    com.google.protobuf.Duration getInterval();

    /**
     * <code>.google.protobuf.StringValue payload = 4;</code>
     * @return Whether the payload field is set.
     */
    boolean hasPayload();
    /**
     * <code>.google.protobuf.StringValue payload = 4;</code>
     * @return The payload.
     */
    com.google.protobuf.StringValue getPayload();
  }
  /**
   * Protobuf type {@code com.elarian.hera.proto.CustomerReminder}
   */
  public  static final class CustomerReminder extends
      com.google.protobuf.GeneratedMessageLite<
          CustomerReminder, CustomerReminder.Builder> implements
      // @@protoc_insertion_point(message_implements:com.elarian.hera.proto.CustomerReminder)
      CustomerReminderOrBuilder {
    private CustomerReminder() {
      key_ = "";
    }
    public static final int KEY_FIELD_NUMBER = 1;
    private java.lang.String key_;
    /**
     * <code>string key = 1;</code>
     * @return The key.
     */
    @java.lang.Override
    public java.lang.String getKey() {
      return key_;
    }
    /**
     * <code>string key = 1;</code>
     * @return The bytes for key.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString
        getKeyBytes() {
      return com.google.protobuf.ByteString.copyFromUtf8(key_);
    }
    /**
     * <code>string key = 1;</code>
     * @param value The key to set.
     */
    private void setKey(
        java.lang.String value) {
      value.getClass();
  
      key_ = value;
    }
    /**
     * <code>string key = 1;</code>
     */
    private void clearKey() {
      
      key_ = getDefaultInstance().getKey();
    }
    /**
     * <code>string key = 1;</code>
     * @param value The bytes for key to set.
     */
    private void setKeyBytes(
        com.google.protobuf.ByteString value) {
      checkByteStringIsUtf8(value);
      key_ = value.toStringUtf8();
      
    }

    public static final int REMIND_AT_FIELD_NUMBER = 2;
    private com.google.protobuf.Timestamp remindAt_;
    /**
     * <code>.google.protobuf.Timestamp remind_at = 2;</code>
     */
    @java.lang.Override
    public boolean hasRemindAt() {
      return remindAt_ != null;
    }
    /**
     * <code>.google.protobuf.Timestamp remind_at = 2;</code>
     */
    @java.lang.Override
    public com.google.protobuf.Timestamp getRemindAt() {
      return remindAt_ == null ? com.google.protobuf.Timestamp.getDefaultInstance() : remindAt_;
    }
    /**
     * <code>.google.protobuf.Timestamp remind_at = 2;</code>
     */
    private void setRemindAt(com.google.protobuf.Timestamp value) {
      value.getClass();
  remindAt_ = value;
      
      }
    /**
     * <code>.google.protobuf.Timestamp remind_at = 2;</code>
     */
    @java.lang.SuppressWarnings({"ReferenceEquality"})
    private void mergeRemindAt(com.google.protobuf.Timestamp value) {
      value.getClass();
  if (remindAt_ != null &&
          remindAt_ != com.google.protobuf.Timestamp.getDefaultInstance()) {
        remindAt_ =
          com.google.protobuf.Timestamp.newBuilder(remindAt_).mergeFrom(value).buildPartial();
      } else {
        remindAt_ = value;
      }
      
    }
    /**
     * <code>.google.protobuf.Timestamp remind_at = 2;</code>
     */
    private void clearRemindAt() {  remindAt_ = null;
      
    }

    public static final int INTERVAL_FIELD_NUMBER = 3;
    private com.google.protobuf.Duration interval_;
    /**
     * <code>.google.protobuf.Duration interval = 3;</code>
     */
    @java.lang.Override
    public boolean hasInterval() {
      return interval_ != null;
    }
    /**
     * <code>.google.protobuf.Duration interval = 3;</code>
     */
    @java.lang.Override
    public com.google.protobuf.Duration getInterval() {
      return interval_ == null ? com.google.protobuf.Duration.getDefaultInstance() : interval_;
    }
    /**
     * <code>.google.protobuf.Duration interval = 3;</code>
     */
    private void setInterval(com.google.protobuf.Duration value) {
      value.getClass();
  interval_ = value;
      
      }
    /**
     * <code>.google.protobuf.Duration interval = 3;</code>
     */
    @java.lang.SuppressWarnings({"ReferenceEquality"})
    private void mergeInterval(com.google.protobuf.Duration value) {
      value.getClass();
  if (interval_ != null &&
          interval_ != com.google.protobuf.Duration.getDefaultInstance()) {
        interval_ =
          com.google.protobuf.Duration.newBuilder(interval_).mergeFrom(value).buildPartial();
      } else {
        interval_ = value;
      }
      
    }
    /**
     * <code>.google.protobuf.Duration interval = 3;</code>
     */
    private void clearInterval() {  interval_ = null;
      
    }

    public static final int PAYLOAD_FIELD_NUMBER = 4;
    private com.google.protobuf.StringValue payload_;
    /**
     * <code>.google.protobuf.StringValue payload = 4;</code>
     */
    @java.lang.Override
    public boolean hasPayload() {
      return payload_ != null;
    }
    /**
     * <code>.google.protobuf.StringValue payload = 4;</code>
     */
    @java.lang.Override
    public com.google.protobuf.StringValue getPayload() {
      return payload_ == null ? com.google.protobuf.StringValue.getDefaultInstance() : payload_;
    }
    /**
     * <code>.google.protobuf.StringValue payload = 4;</code>
     */
    private void setPayload(com.google.protobuf.StringValue value) {
      value.getClass();
  payload_ = value;
      
      }
    /**
     * <code>.google.protobuf.StringValue payload = 4;</code>
     */
    @java.lang.SuppressWarnings({"ReferenceEquality"})
    private void mergePayload(com.google.protobuf.StringValue value) {
      value.getClass();
  if (payload_ != null &&
          payload_ != com.google.protobuf.StringValue.getDefaultInstance()) {
        payload_ =
          com.google.protobuf.StringValue.newBuilder(payload_).mergeFrom(value).buildPartial();
      } else {
        payload_ = value;
      }
      
    }
    /**
     * <code>.google.protobuf.StringValue payload = 4;</code>
     */
    private void clearPayload() {  payload_ = null;
      
    }

    public static com.elarian.hera.proto.AppModel.CustomerReminder parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, data);
    }
    public static com.elarian.hera.proto.AppModel.CustomerReminder parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, data, extensionRegistry);
    }
    public static com.elarian.hera.proto.AppModel.CustomerReminder parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, data);
    }
    public static com.elarian.hera.proto.AppModel.CustomerReminder parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, data, extensionRegistry);
    }
    public static com.elarian.hera.proto.AppModel.CustomerReminder parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, data);
    }
    public static com.elarian.hera.proto.AppModel.CustomerReminder parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, data, extensionRegistry);
    }
    public static com.elarian.hera.proto.AppModel.CustomerReminder parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, input);
    }
    public static com.elarian.hera.proto.AppModel.CustomerReminder parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, input, extensionRegistry);
    }
    public static com.elarian.hera.proto.AppModel.CustomerReminder parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }
    public static com.elarian.hera.proto.AppModel.CustomerReminder parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }
    public static com.elarian.hera.proto.AppModel.CustomerReminder parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, input);
    }
    public static com.elarian.hera.proto.AppModel.CustomerReminder parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
      return (Builder) DEFAULT_INSTANCE.createBuilder();
    }
    public static Builder newBuilder(com.elarian.hera.proto.AppModel.CustomerReminder prototype) {
      return (Builder) DEFAULT_INSTANCE.createBuilder(prototype);
    }

    /**
     * Protobuf type {@code com.elarian.hera.proto.CustomerReminder}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageLite.Builder<
          com.elarian.hera.proto.AppModel.CustomerReminder, Builder> implements
        // @@protoc_insertion_point(builder_implements:com.elarian.hera.proto.CustomerReminder)
        com.elarian.hera.proto.AppModel.CustomerReminderOrBuilder {
      // Construct using com.elarian.hera.proto.AppModel.CustomerReminder.newBuilder()
      private Builder() {
        super(DEFAULT_INSTANCE);
      }


      /**
       * <code>string key = 1;</code>
       * @return The key.
       */
      @java.lang.Override
      public java.lang.String getKey() {
        return instance.getKey();
      }
      /**
       * <code>string key = 1;</code>
       * @return The bytes for key.
       */
      @java.lang.Override
      public com.google.protobuf.ByteString
          getKeyBytes() {
        return instance.getKeyBytes();
      }
      /**
       * <code>string key = 1;</code>
       * @param value The key to set.
       * @return This builder for chaining.
       */
      public Builder setKey(
          java.lang.String value) {
        copyOnWrite();
        instance.setKey(value);
        return this;
      }
      /**
       * <code>string key = 1;</code>
       * @return This builder for chaining.
       */
      public Builder clearKey() {
        copyOnWrite();
        instance.clearKey();
        return this;
      }
      /**
       * <code>string key = 1;</code>
       * @param value The bytes for key to set.
       * @return This builder for chaining.
       */
      public Builder setKeyBytes(
          com.google.protobuf.ByteString value) {
        copyOnWrite();
        instance.setKeyBytes(value);
        return this;
      }

      /**
       * <code>.google.protobuf.Timestamp remind_at = 2;</code>
       */
      @java.lang.Override
      public boolean hasRemindAt() {
        return instance.hasRemindAt();
      }
      /**
       * <code>.google.protobuf.Timestamp remind_at = 2;</code>
       */
      @java.lang.Override
      public com.google.protobuf.Timestamp getRemindAt() {
        return instance.getRemindAt();
      }
      /**
       * <code>.google.protobuf.Timestamp remind_at = 2;</code>
       */
      public Builder setRemindAt(com.google.protobuf.Timestamp value) {
        copyOnWrite();
        instance.setRemindAt(value);
        return this;
        }
      /**
       * <code>.google.protobuf.Timestamp remind_at = 2;</code>
       */
      public Builder setRemindAt(
          com.google.protobuf.Timestamp.Builder builderForValue) {
        copyOnWrite();
        instance.setRemindAt(builderForValue.build());
        return this;
      }
      /**
       * <code>.google.protobuf.Timestamp remind_at = 2;</code>
       */
      public Builder mergeRemindAt(com.google.protobuf.Timestamp value) {
        copyOnWrite();
        instance.mergeRemindAt(value);
        return this;
      }
      /**
       * <code>.google.protobuf.Timestamp remind_at = 2;</code>
       */
      public Builder clearRemindAt() {  copyOnWrite();
        instance.clearRemindAt();
        return this;
      }

      /**
       * <code>.google.protobuf.Duration interval = 3;</code>
       */
      @java.lang.Override
      public boolean hasInterval() {
        return instance.hasInterval();
      }
      /**
       * <code>.google.protobuf.Duration interval = 3;</code>
       */
      @java.lang.Override
      public com.google.protobuf.Duration getInterval() {
        return instance.getInterval();
      }
      /**
       * <code>.google.protobuf.Duration interval = 3;</code>
       */
      public Builder setInterval(com.google.protobuf.Duration value) {
        copyOnWrite();
        instance.setInterval(value);
        return this;
        }
      /**
       * <code>.google.protobuf.Duration interval = 3;</code>
       */
      public Builder setInterval(
          com.google.protobuf.Duration.Builder builderForValue) {
        copyOnWrite();
        instance.setInterval(builderForValue.build());
        return this;
      }
      /**
       * <code>.google.protobuf.Duration interval = 3;</code>
       */
      public Builder mergeInterval(com.google.protobuf.Duration value) {
        copyOnWrite();
        instance.mergeInterval(value);
        return this;
      }
      /**
       * <code>.google.protobuf.Duration interval = 3;</code>
       */
      public Builder clearInterval() {  copyOnWrite();
        instance.clearInterval();
        return this;
      }

      /**
       * <code>.google.protobuf.StringValue payload = 4;</code>
       */
      @java.lang.Override
      public boolean hasPayload() {
        return instance.hasPayload();
      }
      /**
       * <code>.google.protobuf.StringValue payload = 4;</code>
       */
      @java.lang.Override
      public com.google.protobuf.StringValue getPayload() {
        return instance.getPayload();
      }
      /**
       * <code>.google.protobuf.StringValue payload = 4;</code>
       */
      public Builder setPayload(com.google.protobuf.StringValue value) {
        copyOnWrite();
        instance.setPayload(value);
        return this;
        }
      /**
       * <code>.google.protobuf.StringValue payload = 4;</code>
       */
      public Builder setPayload(
          com.google.protobuf.StringValue.Builder builderForValue) {
        copyOnWrite();
        instance.setPayload(builderForValue.build());
        return this;
      }
      /**
       * <code>.google.protobuf.StringValue payload = 4;</code>
       */
      public Builder mergePayload(com.google.protobuf.StringValue value) {
        copyOnWrite();
        instance.mergePayload(value);
        return this;
      }
      /**
       * <code>.google.protobuf.StringValue payload = 4;</code>
       */
      public Builder clearPayload() {  copyOnWrite();
        instance.clearPayload();
        return this;
      }

      // @@protoc_insertion_point(builder_scope:com.elarian.hera.proto.CustomerReminder)
    }
    @java.lang.Override
    @java.lang.SuppressWarnings({"unchecked", "fallthrough"})
    protected final java.lang.Object dynamicMethod(
        com.google.protobuf.GeneratedMessageLite.MethodToInvoke method,
        java.lang.Object arg0, java.lang.Object arg1) {
      switch (method) {
        case NEW_MUTABLE_INSTANCE: {
          return new com.elarian.hera.proto.AppModel.CustomerReminder();
        }
        case NEW_BUILDER: {
          return new Builder();
        }
        case BUILD_MESSAGE_INFO: {
            java.lang.Object[] objects = new java.lang.Object[] {
              "key_",
              "remindAt_",
              "interval_",
              "payload_",
            };
            java.lang.String info =
                "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u0208\u0002\t" +
                "\u0003\t\u0004\t";
            return newMessageInfo(DEFAULT_INSTANCE, info, objects);
        }
        // fall through
        case GET_DEFAULT_INSTANCE: {
          return DEFAULT_INSTANCE;
        }
        case GET_PARSER: {
          com.google.protobuf.Parser<com.elarian.hera.proto.AppModel.CustomerReminder> parser = PARSER;
          if (parser == null) {
            synchronized (com.elarian.hera.proto.AppModel.CustomerReminder.class) {
              parser = PARSER;
              if (parser == null) {
                parser =
                    new DefaultInstanceBasedParser<com.elarian.hera.proto.AppModel.CustomerReminder>(
                        DEFAULT_INSTANCE);
                PARSER = parser;
              }
            }
          }
          return parser;
      }
      case GET_MEMOIZED_IS_INITIALIZED: {
        return (byte) 1;
      }
      case SET_MEMOIZED_IS_INITIALIZED: {
        return null;
      }
      }
      throw new UnsupportedOperationException();
    }


    // @@protoc_insertion_point(class_scope:com.elarian.hera.proto.CustomerReminder)
    private static final com.elarian.hera.proto.AppModel.CustomerReminder DEFAULT_INSTANCE;
    static {
      CustomerReminder defaultInstance = new CustomerReminder();
      // New instances are implicitly immutable so no need to make
      // immutable.
      DEFAULT_INSTANCE = defaultInstance;
      com.google.protobuf.GeneratedMessageLite.registerDefaultInstance(
        CustomerReminder.class, defaultInstance);
    }

    public static com.elarian.hera.proto.AppModel.CustomerReminder getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static volatile com.google.protobuf.Parser<CustomerReminder> PARSER;

    public static com.google.protobuf.Parser<CustomerReminder> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
  }


  static {
  }

  // @@protoc_insertion_point(outer_class_scope)
}