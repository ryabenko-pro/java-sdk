// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: app_state.proto

package com.elarian.hera.proto;

public final class AppStateOuterClass {
  private AppStateOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface AppStateOrBuilder extends
      // @@protoc_insertion_point(interface_extends:com.elarian.hera.proto.AppState)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>.com.elarian.hera.proto.DataMapValue data = 1;</code>
     * @return Whether the data field is set.
     */
    boolean hasData();
    /**
     * <code>.com.elarian.hera.proto.DataMapValue data = 1;</code>
     * @return The data.
     */
    com.elarian.hera.proto.CommonModel.DataMapValue getData();
    /**
     * <code>.com.elarian.hera.proto.DataMapValue data = 1;</code>
     */
    com.elarian.hera.proto.CommonModel.DataMapValueOrBuilder getDataOrBuilder();

    /**
     * <code>repeated .com.elarian.hera.proto.CustomerReminder reminders = 2;</code>
     */
    java.util.List<com.elarian.hera.proto.AppModel.CustomerReminder> 
        getRemindersList();
    /**
     * <code>repeated .com.elarian.hera.proto.CustomerReminder reminders = 2;</code>
     */
    com.elarian.hera.proto.AppModel.CustomerReminder getReminders(int index);
    /**
     * <code>repeated .com.elarian.hera.proto.CustomerReminder reminders = 2;</code>
     */
    int getRemindersCount();
    /**
     * <code>repeated .com.elarian.hera.proto.CustomerReminder reminders = 2;</code>
     */
    java.util.List<? extends com.elarian.hera.proto.AppModel.CustomerReminderOrBuilder> 
        getRemindersOrBuilderList();
    /**
     * <code>repeated .com.elarian.hera.proto.CustomerReminder reminders = 2;</code>
     */
    com.elarian.hera.proto.AppModel.CustomerReminderOrBuilder getRemindersOrBuilder(
        int index);
  }
  /**
   * Protobuf type {@code com.elarian.hera.proto.AppState}
   */
  public static final class AppState extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:com.elarian.hera.proto.AppState)
      AppStateOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use AppState.newBuilder() to construct.
    private AppState(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private AppState() {
      reminders_ = java.util.Collections.emptyList();
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
        UnusedPrivateParameter unused) {
      return new AppState();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private AppState(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      int mutable_bitField0_ = 0;
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 10: {
              com.elarian.hera.proto.CommonModel.DataMapValue.Builder subBuilder = null;
              if (data_ != null) {
                subBuilder = data_.toBuilder();
              }
              data_ = input.readMessage(com.elarian.hera.proto.CommonModel.DataMapValue.parser(), extensionRegistry);
              if (subBuilder != null) {
                subBuilder.mergeFrom(data_);
                data_ = subBuilder.buildPartial();
              }

              break;
            }
            case 18: {
              if (!((mutable_bitField0_ & 0x00000001) != 0)) {
                reminders_ = new java.util.ArrayList<com.elarian.hera.proto.AppModel.CustomerReminder>();
                mutable_bitField0_ |= 0x00000001;
              }
              reminders_.add(
                  input.readMessage(com.elarian.hera.proto.AppModel.CustomerReminder.parser(), extensionRegistry));
              break;
            }
            default: {
              if (!parseUnknownField(
                  input, unknownFields, extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        if (((mutable_bitField0_ & 0x00000001) != 0)) {
          reminders_ = java.util.Collections.unmodifiableList(reminders_);
        }
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.elarian.hera.proto.AppStateOuterClass.internal_static_com_elarian_hera_proto_AppState_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.elarian.hera.proto.AppStateOuterClass.internal_static_com_elarian_hera_proto_AppState_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.elarian.hera.proto.AppStateOuterClass.AppState.class, com.elarian.hera.proto.AppStateOuterClass.AppState.Builder.class);
    }

    public static final int DATA_FIELD_NUMBER = 1;
    private com.elarian.hera.proto.CommonModel.DataMapValue data_;
    /**
     * <code>.com.elarian.hera.proto.DataMapValue data = 1;</code>
     * @return Whether the data field is set.
     */
    @java.lang.Override
    public boolean hasData() {
      return data_ != null;
    }
    /**
     * <code>.com.elarian.hera.proto.DataMapValue data = 1;</code>
     * @return The data.
     */
    @java.lang.Override
    public com.elarian.hera.proto.CommonModel.DataMapValue getData() {
      return data_ == null ? com.elarian.hera.proto.CommonModel.DataMapValue.getDefaultInstance() : data_;
    }
    /**
     * <code>.com.elarian.hera.proto.DataMapValue data = 1;</code>
     */
    @java.lang.Override
    public com.elarian.hera.proto.CommonModel.DataMapValueOrBuilder getDataOrBuilder() {
      return getData();
    }

    public static final int REMINDERS_FIELD_NUMBER = 2;
    private java.util.List<com.elarian.hera.proto.AppModel.CustomerReminder> reminders_;
    /**
     * <code>repeated .com.elarian.hera.proto.CustomerReminder reminders = 2;</code>
     */
    @java.lang.Override
    public java.util.List<com.elarian.hera.proto.AppModel.CustomerReminder> getRemindersList() {
      return reminders_;
    }
    /**
     * <code>repeated .com.elarian.hera.proto.CustomerReminder reminders = 2;</code>
     */
    @java.lang.Override
    public java.util.List<? extends com.elarian.hera.proto.AppModel.CustomerReminderOrBuilder> 
        getRemindersOrBuilderList() {
      return reminders_;
    }
    /**
     * <code>repeated .com.elarian.hera.proto.CustomerReminder reminders = 2;</code>
     */
    @java.lang.Override
    public int getRemindersCount() {
      return reminders_.size();
    }
    /**
     * <code>repeated .com.elarian.hera.proto.CustomerReminder reminders = 2;</code>
     */
    @java.lang.Override
    public com.elarian.hera.proto.AppModel.CustomerReminder getReminders(int index) {
      return reminders_.get(index);
    }
    /**
     * <code>repeated .com.elarian.hera.proto.CustomerReminder reminders = 2;</code>
     */
    @java.lang.Override
    public com.elarian.hera.proto.AppModel.CustomerReminderOrBuilder getRemindersOrBuilder(
        int index) {
      return reminders_.get(index);
    }

    private byte memoizedIsInitialized = -1;
    @java.lang.Override
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    @java.lang.Override
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (data_ != null) {
        output.writeMessage(1, getData());
      }
      for (int i = 0; i < reminders_.size(); i++) {
        output.writeMessage(2, reminders_.get(i));
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (data_ != null) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(1, getData());
      }
      for (int i = 0; i < reminders_.size(); i++) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(2, reminders_.get(i));
      }
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof com.elarian.hera.proto.AppStateOuterClass.AppState)) {
        return super.equals(obj);
      }
      com.elarian.hera.proto.AppStateOuterClass.AppState other = (com.elarian.hera.proto.AppStateOuterClass.AppState) obj;

      if (hasData() != other.hasData()) return false;
      if (hasData()) {
        if (!getData()
            .equals(other.getData())) return false;
      }
      if (!getRemindersList()
          .equals(other.getRemindersList())) return false;
      if (!unknownFields.equals(other.unknownFields)) return false;
      return true;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      if (hasData()) {
        hash = (37 * hash) + DATA_FIELD_NUMBER;
        hash = (53 * hash) + getData().hashCode();
      }
      if (getRemindersCount() > 0) {
        hash = (37 * hash) + REMINDERS_FIELD_NUMBER;
        hash = (53 * hash) + getRemindersList().hashCode();
      }
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.elarian.hera.proto.AppStateOuterClass.AppState parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.elarian.hera.proto.AppStateOuterClass.AppState parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.elarian.hera.proto.AppStateOuterClass.AppState parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.elarian.hera.proto.AppStateOuterClass.AppState parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.elarian.hera.proto.AppStateOuterClass.AppState parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.elarian.hera.proto.AppStateOuterClass.AppState parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.elarian.hera.proto.AppStateOuterClass.AppState parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.elarian.hera.proto.AppStateOuterClass.AppState parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.elarian.hera.proto.AppStateOuterClass.AppState parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static com.elarian.hera.proto.AppStateOuterClass.AppState parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.elarian.hera.proto.AppStateOuterClass.AppState parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.elarian.hera.proto.AppStateOuterClass.AppState parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    @java.lang.Override
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(com.elarian.hera.proto.AppStateOuterClass.AppState prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    @java.lang.Override
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code com.elarian.hera.proto.AppState}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:com.elarian.hera.proto.AppState)
        com.elarian.hera.proto.AppStateOuterClass.AppStateOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.elarian.hera.proto.AppStateOuterClass.internal_static_com_elarian_hera_proto_AppState_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.elarian.hera.proto.AppStateOuterClass.internal_static_com_elarian_hera_proto_AppState_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.elarian.hera.proto.AppStateOuterClass.AppState.class, com.elarian.hera.proto.AppStateOuterClass.AppState.Builder.class);
      }

      // Construct using com.elarian.hera.proto.AppStateOuterClass.AppState.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
          getRemindersFieldBuilder();
        }
      }
      @java.lang.Override
      public Builder clear() {
        super.clear();
        if (dataBuilder_ == null) {
          data_ = null;
        } else {
          data_ = null;
          dataBuilder_ = null;
        }
        if (remindersBuilder_ == null) {
          reminders_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000001);
        } else {
          remindersBuilder_.clear();
        }
        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.elarian.hera.proto.AppStateOuterClass.internal_static_com_elarian_hera_proto_AppState_descriptor;
      }

      @java.lang.Override
      public com.elarian.hera.proto.AppStateOuterClass.AppState getDefaultInstanceForType() {
        return com.elarian.hera.proto.AppStateOuterClass.AppState.getDefaultInstance();
      }

      @java.lang.Override
      public com.elarian.hera.proto.AppStateOuterClass.AppState build() {
        com.elarian.hera.proto.AppStateOuterClass.AppState result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.elarian.hera.proto.AppStateOuterClass.AppState buildPartial() {
        com.elarian.hera.proto.AppStateOuterClass.AppState result = new com.elarian.hera.proto.AppStateOuterClass.AppState(this);
        int from_bitField0_ = bitField0_;
        if (dataBuilder_ == null) {
          result.data_ = data_;
        } else {
          result.data_ = dataBuilder_.build();
        }
        if (remindersBuilder_ == null) {
          if (((bitField0_ & 0x00000001) != 0)) {
            reminders_ = java.util.Collections.unmodifiableList(reminders_);
            bitField0_ = (bitField0_ & ~0x00000001);
          }
          result.reminders_ = reminders_;
        } else {
          result.reminders_ = remindersBuilder_.build();
        }
        onBuilt();
        return result;
      }

      @java.lang.Override
      public Builder clone() {
        return super.clone();
      }
      @java.lang.Override
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return super.setField(field, value);
      }
      @java.lang.Override
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return super.clearField(field);
      }
      @java.lang.Override
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return super.clearOneof(oneof);
      }
      @java.lang.Override
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, java.lang.Object value) {
        return super.setRepeatedField(field, index, value);
      }
      @java.lang.Override
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return super.addRepeatedField(field, value);
      }
      @java.lang.Override
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.elarian.hera.proto.AppStateOuterClass.AppState) {
          return mergeFrom((com.elarian.hera.proto.AppStateOuterClass.AppState)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.elarian.hera.proto.AppStateOuterClass.AppState other) {
        if (other == com.elarian.hera.proto.AppStateOuterClass.AppState.getDefaultInstance()) return this;
        if (other.hasData()) {
          mergeData(other.getData());
        }
        if (remindersBuilder_ == null) {
          if (!other.reminders_.isEmpty()) {
            if (reminders_.isEmpty()) {
              reminders_ = other.reminders_;
              bitField0_ = (bitField0_ & ~0x00000001);
            } else {
              ensureRemindersIsMutable();
              reminders_.addAll(other.reminders_);
            }
            onChanged();
          }
        } else {
          if (!other.reminders_.isEmpty()) {
            if (remindersBuilder_.isEmpty()) {
              remindersBuilder_.dispose();
              remindersBuilder_ = null;
              reminders_ = other.reminders_;
              bitField0_ = (bitField0_ & ~0x00000001);
              remindersBuilder_ = 
                com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                   getRemindersFieldBuilder() : null;
            } else {
              remindersBuilder_.addAllMessages(other.reminders_);
            }
          }
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      @java.lang.Override
      public final boolean isInitialized() {
        return true;
      }

      @java.lang.Override
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.elarian.hera.proto.AppStateOuterClass.AppState parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (com.elarian.hera.proto.AppStateOuterClass.AppState) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private com.elarian.hera.proto.CommonModel.DataMapValue data_;
      private com.google.protobuf.SingleFieldBuilderV3<
          com.elarian.hera.proto.CommonModel.DataMapValue, com.elarian.hera.proto.CommonModel.DataMapValue.Builder, com.elarian.hera.proto.CommonModel.DataMapValueOrBuilder> dataBuilder_;
      /**
       * <code>.com.elarian.hera.proto.DataMapValue data = 1;</code>
       * @return Whether the data field is set.
       */
      public boolean hasData() {
        return dataBuilder_ != null || data_ != null;
      }
      /**
       * <code>.com.elarian.hera.proto.DataMapValue data = 1;</code>
       * @return The data.
       */
      public com.elarian.hera.proto.CommonModel.DataMapValue getData() {
        if (dataBuilder_ == null) {
          return data_ == null ? com.elarian.hera.proto.CommonModel.DataMapValue.getDefaultInstance() : data_;
        } else {
          return dataBuilder_.getMessage();
        }
      }
      /**
       * <code>.com.elarian.hera.proto.DataMapValue data = 1;</code>
       */
      public Builder setData(com.elarian.hera.proto.CommonModel.DataMapValue value) {
        if (dataBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          data_ = value;
          onChanged();
        } else {
          dataBuilder_.setMessage(value);
        }

        return this;
      }
      /**
       * <code>.com.elarian.hera.proto.DataMapValue data = 1;</code>
       */
      public Builder setData(
          com.elarian.hera.proto.CommonModel.DataMapValue.Builder builderForValue) {
        if (dataBuilder_ == null) {
          data_ = builderForValue.build();
          onChanged();
        } else {
          dataBuilder_.setMessage(builderForValue.build());
        }

        return this;
      }
      /**
       * <code>.com.elarian.hera.proto.DataMapValue data = 1;</code>
       */
      public Builder mergeData(com.elarian.hera.proto.CommonModel.DataMapValue value) {
        if (dataBuilder_ == null) {
          if (data_ != null) {
            data_ =
              com.elarian.hera.proto.CommonModel.DataMapValue.newBuilder(data_).mergeFrom(value).buildPartial();
          } else {
            data_ = value;
          }
          onChanged();
        } else {
          dataBuilder_.mergeFrom(value);
        }

        return this;
      }
      /**
       * <code>.com.elarian.hera.proto.DataMapValue data = 1;</code>
       */
      public Builder clearData() {
        if (dataBuilder_ == null) {
          data_ = null;
          onChanged();
        } else {
          data_ = null;
          dataBuilder_ = null;
        }

        return this;
      }
      /**
       * <code>.com.elarian.hera.proto.DataMapValue data = 1;</code>
       */
      public com.elarian.hera.proto.CommonModel.DataMapValue.Builder getDataBuilder() {
        
        onChanged();
        return getDataFieldBuilder().getBuilder();
      }
      /**
       * <code>.com.elarian.hera.proto.DataMapValue data = 1;</code>
       */
      public com.elarian.hera.proto.CommonModel.DataMapValueOrBuilder getDataOrBuilder() {
        if (dataBuilder_ != null) {
          return dataBuilder_.getMessageOrBuilder();
        } else {
          return data_ == null ?
              com.elarian.hera.proto.CommonModel.DataMapValue.getDefaultInstance() : data_;
        }
      }
      /**
       * <code>.com.elarian.hera.proto.DataMapValue data = 1;</code>
       */
      private com.google.protobuf.SingleFieldBuilderV3<
          com.elarian.hera.proto.CommonModel.DataMapValue, com.elarian.hera.proto.CommonModel.DataMapValue.Builder, com.elarian.hera.proto.CommonModel.DataMapValueOrBuilder> 
          getDataFieldBuilder() {
        if (dataBuilder_ == null) {
          dataBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
              com.elarian.hera.proto.CommonModel.DataMapValue, com.elarian.hera.proto.CommonModel.DataMapValue.Builder, com.elarian.hera.proto.CommonModel.DataMapValueOrBuilder>(
                  getData(),
                  getParentForChildren(),
                  isClean());
          data_ = null;
        }
        return dataBuilder_;
      }

      private java.util.List<com.elarian.hera.proto.AppModel.CustomerReminder> reminders_ =
        java.util.Collections.emptyList();
      private void ensureRemindersIsMutable() {
        if (!((bitField0_ & 0x00000001) != 0)) {
          reminders_ = new java.util.ArrayList<com.elarian.hera.proto.AppModel.CustomerReminder>(reminders_);
          bitField0_ |= 0x00000001;
         }
      }

      private com.google.protobuf.RepeatedFieldBuilderV3<
          com.elarian.hera.proto.AppModel.CustomerReminder, com.elarian.hera.proto.AppModel.CustomerReminder.Builder, com.elarian.hera.proto.AppModel.CustomerReminderOrBuilder> remindersBuilder_;

      /**
       * <code>repeated .com.elarian.hera.proto.CustomerReminder reminders = 2;</code>
       */
      public java.util.List<com.elarian.hera.proto.AppModel.CustomerReminder> getRemindersList() {
        if (remindersBuilder_ == null) {
          return java.util.Collections.unmodifiableList(reminders_);
        } else {
          return remindersBuilder_.getMessageList();
        }
      }
      /**
       * <code>repeated .com.elarian.hera.proto.CustomerReminder reminders = 2;</code>
       */
      public int getRemindersCount() {
        if (remindersBuilder_ == null) {
          return reminders_.size();
        } else {
          return remindersBuilder_.getCount();
        }
      }
      /**
       * <code>repeated .com.elarian.hera.proto.CustomerReminder reminders = 2;</code>
       */
      public com.elarian.hera.proto.AppModel.CustomerReminder getReminders(int index) {
        if (remindersBuilder_ == null) {
          return reminders_.get(index);
        } else {
          return remindersBuilder_.getMessage(index);
        }
      }
      /**
       * <code>repeated .com.elarian.hera.proto.CustomerReminder reminders = 2;</code>
       */
      public Builder setReminders(
          int index, com.elarian.hera.proto.AppModel.CustomerReminder value) {
        if (remindersBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureRemindersIsMutable();
          reminders_.set(index, value);
          onChanged();
        } else {
          remindersBuilder_.setMessage(index, value);
        }
        return this;
      }
      /**
       * <code>repeated .com.elarian.hera.proto.CustomerReminder reminders = 2;</code>
       */
      public Builder setReminders(
          int index, com.elarian.hera.proto.AppModel.CustomerReminder.Builder builderForValue) {
        if (remindersBuilder_ == null) {
          ensureRemindersIsMutable();
          reminders_.set(index, builderForValue.build());
          onChanged();
        } else {
          remindersBuilder_.setMessage(index, builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .com.elarian.hera.proto.CustomerReminder reminders = 2;</code>
       */
      public Builder addReminders(com.elarian.hera.proto.AppModel.CustomerReminder value) {
        if (remindersBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureRemindersIsMutable();
          reminders_.add(value);
          onChanged();
        } else {
          remindersBuilder_.addMessage(value);
        }
        return this;
      }
      /**
       * <code>repeated .com.elarian.hera.proto.CustomerReminder reminders = 2;</code>
       */
      public Builder addReminders(
          int index, com.elarian.hera.proto.AppModel.CustomerReminder value) {
        if (remindersBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureRemindersIsMutable();
          reminders_.add(index, value);
          onChanged();
        } else {
          remindersBuilder_.addMessage(index, value);
        }
        return this;
      }
      /**
       * <code>repeated .com.elarian.hera.proto.CustomerReminder reminders = 2;</code>
       */
      public Builder addReminders(
          com.elarian.hera.proto.AppModel.CustomerReminder.Builder builderForValue) {
        if (remindersBuilder_ == null) {
          ensureRemindersIsMutable();
          reminders_.add(builderForValue.build());
          onChanged();
        } else {
          remindersBuilder_.addMessage(builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .com.elarian.hera.proto.CustomerReminder reminders = 2;</code>
       */
      public Builder addReminders(
          int index, com.elarian.hera.proto.AppModel.CustomerReminder.Builder builderForValue) {
        if (remindersBuilder_ == null) {
          ensureRemindersIsMutable();
          reminders_.add(index, builderForValue.build());
          onChanged();
        } else {
          remindersBuilder_.addMessage(index, builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .com.elarian.hera.proto.CustomerReminder reminders = 2;</code>
       */
      public Builder addAllReminders(
          java.lang.Iterable<? extends com.elarian.hera.proto.AppModel.CustomerReminder> values) {
        if (remindersBuilder_ == null) {
          ensureRemindersIsMutable();
          com.google.protobuf.AbstractMessageLite.Builder.addAll(
              values, reminders_);
          onChanged();
        } else {
          remindersBuilder_.addAllMessages(values);
        }
        return this;
      }
      /**
       * <code>repeated .com.elarian.hera.proto.CustomerReminder reminders = 2;</code>
       */
      public Builder clearReminders() {
        if (remindersBuilder_ == null) {
          reminders_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000001);
          onChanged();
        } else {
          remindersBuilder_.clear();
        }
        return this;
      }
      /**
       * <code>repeated .com.elarian.hera.proto.CustomerReminder reminders = 2;</code>
       */
      public Builder removeReminders(int index) {
        if (remindersBuilder_ == null) {
          ensureRemindersIsMutable();
          reminders_.remove(index);
          onChanged();
        } else {
          remindersBuilder_.remove(index);
        }
        return this;
      }
      /**
       * <code>repeated .com.elarian.hera.proto.CustomerReminder reminders = 2;</code>
       */
      public com.elarian.hera.proto.AppModel.CustomerReminder.Builder getRemindersBuilder(
          int index) {
        return getRemindersFieldBuilder().getBuilder(index);
      }
      /**
       * <code>repeated .com.elarian.hera.proto.CustomerReminder reminders = 2;</code>
       */
      public com.elarian.hera.proto.AppModel.CustomerReminderOrBuilder getRemindersOrBuilder(
          int index) {
        if (remindersBuilder_ == null) {
          return reminders_.get(index);  } else {
          return remindersBuilder_.getMessageOrBuilder(index);
        }
      }
      /**
       * <code>repeated .com.elarian.hera.proto.CustomerReminder reminders = 2;</code>
       */
      public java.util.List<? extends com.elarian.hera.proto.AppModel.CustomerReminderOrBuilder> 
           getRemindersOrBuilderList() {
        if (remindersBuilder_ != null) {
          return remindersBuilder_.getMessageOrBuilderList();
        } else {
          return java.util.Collections.unmodifiableList(reminders_);
        }
      }
      /**
       * <code>repeated .com.elarian.hera.proto.CustomerReminder reminders = 2;</code>
       */
      public com.elarian.hera.proto.AppModel.CustomerReminder.Builder addRemindersBuilder() {
        return getRemindersFieldBuilder().addBuilder(
            com.elarian.hera.proto.AppModel.CustomerReminder.getDefaultInstance());
      }
      /**
       * <code>repeated .com.elarian.hera.proto.CustomerReminder reminders = 2;</code>
       */
      public com.elarian.hera.proto.AppModel.CustomerReminder.Builder addRemindersBuilder(
          int index) {
        return getRemindersFieldBuilder().addBuilder(
            index, com.elarian.hera.proto.AppModel.CustomerReminder.getDefaultInstance());
      }
      /**
       * <code>repeated .com.elarian.hera.proto.CustomerReminder reminders = 2;</code>
       */
      public java.util.List<com.elarian.hera.proto.AppModel.CustomerReminder.Builder> 
           getRemindersBuilderList() {
        return getRemindersFieldBuilder().getBuilderList();
      }
      private com.google.protobuf.RepeatedFieldBuilderV3<
          com.elarian.hera.proto.AppModel.CustomerReminder, com.elarian.hera.proto.AppModel.CustomerReminder.Builder, com.elarian.hera.proto.AppModel.CustomerReminderOrBuilder> 
          getRemindersFieldBuilder() {
        if (remindersBuilder_ == null) {
          remindersBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
              com.elarian.hera.proto.AppModel.CustomerReminder, com.elarian.hera.proto.AppModel.CustomerReminder.Builder, com.elarian.hera.proto.AppModel.CustomerReminderOrBuilder>(
                  reminders_,
                  ((bitField0_ & 0x00000001) != 0),
                  getParentForChildren(),
                  isClean());
          reminders_ = null;
        }
        return remindersBuilder_;
      }
      @java.lang.Override
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFields(unknownFields);
      }

      @java.lang.Override
      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:com.elarian.hera.proto.AppState)
    }

    // @@protoc_insertion_point(class_scope:com.elarian.hera.proto.AppState)
    private static final com.elarian.hera.proto.AppStateOuterClass.AppState DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new com.elarian.hera.proto.AppStateOuterClass.AppState();
    }

    public static com.elarian.hera.proto.AppStateOuterClass.AppState getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<AppState>
        PARSER = new com.google.protobuf.AbstractParser<AppState>() {
      @java.lang.Override
      public AppState parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new AppState(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<AppState> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<AppState> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.elarian.hera.proto.AppStateOuterClass.AppState getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_elarian_hera_proto_AppState_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_elarian_hera_proto_AppState_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\017app_state.proto\022\026com.elarian.hera.prot" +
      "o\032\022common_model.proto\032\017app_model.proto\"{" +
      "\n\010AppState\0222\n\004data\030\001 \001(\0132$.com.elarian.h" +
      "era.proto.DataMapValue\022;\n\treminders\030\002 \003(" +
      "\0132(.com.elarian.hera.proto.CustomerRemin" +
      "derb\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.elarian.hera.proto.CommonModel.getDescriptor(),
          com.elarian.hera.proto.AppModel.getDescriptor(),
        });
    internal_static_com_elarian_hera_proto_AppState_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_elarian_hera_proto_AppState_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_elarian_hera_proto_AppState_descriptor,
        new java.lang.String[] { "Data", "Reminders", });
    com.elarian.hera.proto.CommonModel.getDescriptor();
    com.elarian.hera.proto.AppModel.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}